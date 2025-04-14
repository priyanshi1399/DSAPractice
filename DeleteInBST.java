
/*public class DeleteInBST {

    /*public static class TreeNode{
        int val;
        BinaryTreeLevelOrder.TreeNode left,right;

        public TreeNode(int data){
            this.val=data;
        }

        public TreeNode(int data, BinaryTreeLevelOrder.TreeNode l, BinaryTreeLevelOrder.TreeNode r){
            this.val=data;
            this.left=l;
            this.right=r;
        }
    }*/
/*
    public static void main(String [] args){
        DeleteInBST root=new DeleteInBST.TreeNode(3);
        root.left=new BinaryTreeLevelOrder.TreeNode(9);
        root.right=new BinaryTreeLevelOrder.TreeNode(20);
        root.right.left=new BinaryTreeLevelOrder.TreeNode(15);
        root.right.right=new BinaryTreeLevelOrder.TreeNode(7);
        int key=0;
        deleteNode(root,0);

    }



    private static boolean search(TreeNode root,int key){
        if(key==root.val){
            root=root.right;
            return true;
        }
        if(key>root.val){
            search(root.right,key);
        }
        else{
            search(root.left,key);
        }
        return false;
    }
    public static TreeNode deleteNode(TreeNode root, int key) {
        if(root==null){
            return root;
        }
        if(search(root,key)!=true){
            return root;
        }
        return root;
    }
}
*/