public class BalancedBinaryTree {

    public static class TreeNode{
        int val;
        TreeNode left,right;
        public TreeNode(int data){
            this.val=data;

        }
        public TreeNode(int data,TreeNode l,TreeNode r){
            this.val=data;
            this.left=l;
            this.right=r;
        }
    }
//[1,2,2,3,null,null,3,4,null,null,4]
    public static void main(String [] args){
        TreeNode root=new TreeNode(1);
        root.left=new TreeNode(2);
        root.right=new TreeNode(2);
        root.left.left=new TreeNode(3);
        root.right.right=new TreeNode(3);
        root.left.left.left=new TreeNode(4);
        root.right.right.right=new TreeNode(4);
        isBalanced(root);
    }


    public static  int height(TreeNode root){
        if(root==null){
            return 0;
        }

        int l=height(root.left);
        int r=height(root.right);
        if(Math.abs(l-r)>1){
            return -1;
        }
        return 1+Math.max(l,r);
    }
    public static boolean isBalanced(TreeNode root) {
        if(root==null || root.left==null && root.right==null){
            return true;
        }
        if(height(root)==-1){
            return false;
        }
        return true;
    }
}
