public class DeleteNodeinBST {

    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int data){
            this.val=data;
        }
        public TreeNode(int data,TreeNode l,TreeNode r){
            this.val=data;
            this.left=l;
            this.right=r;
        }
    }

    public static void main(String [] args){
        TreeNode root=new TreeNode(5);
        root.left=new TreeNode(3);
        root.right=new TreeNode(6);
        root.left.left=new TreeNode(2);
        root.left.right=new TreeNode(4);
        root.right.right=new TreeNode(7);
        int key=7;
        deleteNode(root,key);
    }
    public static TreeNode deleteNode(TreeNode root, int key) {
        if(root==null){
            return root; //return null
        }
        else if(root.val==key) { // if 5 has to be deleted then 5->left connects to 5-> right
            return helper(root);
        }
        TreeNode dummy=root;
        while(root!=null) {
            if (root.val > key) {
                if (root.left != null && root.left.val == key) {
                    root.left = helper(root.left);
                    break;

                } else {
                    root = root.left;
                }
            } else {
                if (root.right != null && root.right.val == key) {
                    root.right = helper(root.right);
                    break;

                } else {
                    root = root.right;
                }
            }
        }
        return dummy;
    }

    public static  TreeNode helper(TreeNode root){
        if(root==null){
            return root;
        }
        else if(root.left==null){
            return root.right;
        }
        else if(root.right==null){
            return root.left;
        }

        TreeNode rightChild=root.right; //here it is 4 in example if we see
        TreeNode lastRightfromLeft=findLastRight(root.left); //finding left ka rightmost to attach like here 2 ka rightMost element
        lastRightfromLeft.right=rightChild; //it becomes 2->right->4
        return root.left; //return 2-->right>4
    }

    public static TreeNode findLastRight(TreeNode root){
        if(root.right==null){
            return root; //here returns 2;
        }
        return findLastRight(root.right);
    }
}
