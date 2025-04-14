import java.util.*;

public class flattenBinaryTreeToLinkedList {


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

    private static TreeNode prev = null;
    public static void main(String [] args){
        //root = [1,2,5,3,4,null,6]
        TreeNode root=new TreeNode(1);
        root.left=new TreeNode(2);
        root.right=new TreeNode(5);
        root.left.left=new TreeNode(3);
        root.left.right=new TreeNode(4);
        root.right.right=new TreeNode(6);
        flatten(root);
    }

    public  static void flatten(TreeNode root) {
        Stack<TreeNode> stck=new Stack<>();
        stck.push(root);
        while(true){
            if(root.right!=null){
                stck.push(root.right);
            }
            if(root.left!=null){
                stck.push(root.left);
            }

            if(!stck.isEmpty()){
                root.right=stck.peek();
                root.left=null;
                root=stck.pop();
            }

        }
    }
}
