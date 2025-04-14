import java.util.*;
public class PthSum2 {

    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val){
            this.val=val;
        }
        public TreeNode(int val,TreeNode l,TreeNode r){
            this.val=val;
            this.left=l;
            this.right=r;
        }

    }

    public static void main(String [] args){

        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.right.right.left = new TreeNode(5);
        root.right.right.right = new TreeNode(1);
        int targetSum=22;
        pathSum(root,targetSum);
    }


    private static List<List<Integer>> result=new ArrayList<>();
    private static  void solve(TreeNode root, int remainingSum,List<Integer> path){
        if(root==null){
            return;
        }

        path.add(root.val);
        if(root.left==null && root.right==null && remainingSum==root.val){
            result.add(new ArrayList<>(path));
        }
        solve(root.left,remainingSum-root.val,path);
        solve(root.right,remainingSum-root.val,path);
        path.remove(path.size()-1);
    }
    public static List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<Integer> path=new ArrayList<>();
        solve(root,targetSum,path);
        return result;
    }
}
