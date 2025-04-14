public class Delete_NodeINBST {

    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val){
            this.val=val;
        }
        public TreeNode(int val,TreeNode left,TreeNode right){
            this.val=val;
            this.left=left;
            this.right=right;
        }
    }

    public static void main(String [] args){
        TreeNode root=new TreeNode(5);
        root.left=new TreeNode(3);
        root.right=new TreeNode(6);
        root.left.left=new TreeNode(2);
        root.left.right=new TreeNode(4);
        root.right.right=new TreeNode(7);
        int key=0;
        deleteNode(root,key);
    }

    public  static TreeNode deleteNode(TreeNode root, int key) {
        if(root==null){
            return root;
        }
        TreeNode dummy=root;
        while(root!=null){
            if(root.val>key){
                if(root.left!=null && root.left.val==key){
                    root.left=helper(root.left);
                    break;
                }
                else{
                    root=root.left;
                }
            }
            else{
                if(root.right!=null && root.right.val==key){
                    root.right=helper(root.right);
                    break;
                }
                else{
                    root=root.right;
                }
            }
        }
        return dummy;
    }

    public static TreeNode helper(TreeNode root){ //passed 3
        if(root.left==null){ //if 3's left is null
            return root.right;
        }
        else if(root.right==null){
            return root.left; //if 3's right is null it returns 2
        }
        else{
            TreeNode rightChild=root.right; //here 4
            TreeNode lastRight=findRight(root.left); //2 is passed
            lastRight.right=rightChild; //extreme right
            return root.left; // 2's right is connected to 4 and returns 2
        }
    }

    public static TreeNode findRight(TreeNode root){
        if(root.right==null){
            return root;
        }
        return findRight(root.right);
    }

}
