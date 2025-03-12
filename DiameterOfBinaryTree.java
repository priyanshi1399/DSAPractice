import java.util.*;
public class DiameterOfBinaryTree {

    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int data){
            this.val=data;
        }
        public TreeNode(int data, TreeNode l, TreeNode r){
            this.val=data;
            this.left=l;
            this.right=r;
        }
    }

    public static void main(String [] args){
        TreeNode root=new TreeNode(1);
        root.left=new TreeNode(2);
        root.right=new TreeNode(3);
        root.left.left=new TreeNode(4);
        root.left.right=new TreeNode(5);
        diameterOfBinaryTree(root);
    }


    private static int solve(TreeNode root, int [] result){
        if(root==null){
            return 0;
        }

        int left=solve(root.left,result);
        int right=solve(root.right,result);

        result[0]=Math.max(result[0],left+right);
        return 1+Math.max(left,right);
    }
    public static int diameterOfBinaryTree(TreeNode root) {
        if(root==null){
            return 0;
        }
        int [] result={Integer.MIN_VALUE};
        solve(root,result);
        return result[0];
    }
}
