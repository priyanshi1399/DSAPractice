public class DistributeCoinsinBinaryTree {

    public static class TreeNode{
        int val;
        DeleteNodeinBST.TreeNode left;
        DeleteNodeinBST.TreeNode right;

        public TreeNode(int data){
            this.val=data;
        }
        public TreeNode(int data, DeleteNodeinBST.TreeNode l, DeleteNodeinBST.TreeNode r){
            this.val=data;
            this.left=l;
            this.right=r;
        }
    }

    public static void main(String [] args){
        TreeNode root=new TreeNode(5);
        root.left=new DeleteNodeinBST.TreeNode(3);
        root.right=new DeleteNodeinBST.TreeNode(6);
        root.left.left=new DeleteNodeinBST.TreeNode(2);
        root.left.right=new DeleteNodeinBST.TreeNode(4);
        root.right.right=new DeleteNodeinBST.TreeNode(7);
        int key=7;
       //deleteNode(root,key);
    }
}
