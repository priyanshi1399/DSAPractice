public class RangeSumOfBST {

    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val){
            this.val=val;
        }
        public TreeNode(int val, TreeNode l, TreeNode r){
            this.val=val;
            this.left=l;
            this.right=r;
        }

    }

    public static void main(String [] args){

        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(15);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(7);
        root.left.left.left = new TreeNode(1);
        root.left.right.left = new TreeNode(6);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(18);
        int low=6;
        int high=10;
        rangeSumBST(root,low,high);
    }
    public static int rangeSumBST(TreeNode root, int low, int high) {
        if(root==null){
            return 0;
        }
        if(root.val<low){
            return rangeSumBST(root.right,low,high); //no need to go to right subtree
        }
        else if(root.val>high){
            return rangeSumBST(root.left,low,high); //no need to go to left subtree
        }
        else{
            return root.val+ rangeSumBST(root.left,low,high)+rangeSumBST(root.right,low,high);
        }
    }
}
