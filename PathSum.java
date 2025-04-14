import java.nio.file.Path;
import java.sql.SQLOutput;

public class PathSum {
    public static class TreeNode {
        int val;
        TreeNode left, right;

        public TreeNode(int data) {
            this.val = data;
        }

        public TreeNode(int data, TreeNode l, TreeNode r) {
            this.val = data;
            this.left = l;
            this.right = r;
        }
    }
        public static void main(String [] args) {
            PathSum ps = new PathSum();

            TreeNode root = new TreeNode(5);
            root.left = new TreeNode(4);
            root.right = new TreeNode(8);
            root.left.left = new TreeNode(11);
            root.left.left.left = new TreeNode(7);
            root.left.left.right = new TreeNode(2);
            root.right.left = new TreeNode(13);
            root.right.right = new TreeNode(4);
            root.right.right.right = new TreeNode(1);
            int targetSum=22;
            //printTree(root, 0);
            hasPathSum(root,targetSum);

        }

    public static boolean hasPathSum(TreeNode root, int targetSum) {
        if(root==null){
            return false;
        }

        if(root.left==null && root.right==null && root.val==targetSum){
            return true;
        }

        if(hasPathSum(root.left,targetSum-root.val) || hasPathSum(root.right,targetSum-root.val)){
            return true;
        }
        return false;
    }



}
