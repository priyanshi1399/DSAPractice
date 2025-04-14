import java.util.*;
public class Path_Sum {

    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int data){
            this.val=data;
        }

        public TreeNode(int data,TreeNode left, TreeNode right){
            this.val=data;
            this.left=left;
            this.right=right;
        }
    }
    //[5,4,8,11,null,13,4,7,2,null,null,5,1],
    public static void main(String [] args){
        TreeNode root=new TreeNode(5);
        root.left=new TreeNode(4);
        root.right=new TreeNode(8);
        root.left.left=new TreeNode(11);
        root.left.left.left=new TreeNode(7);
        root.left.left.right=new TreeNode(2);
        root.right.left=new TreeNode(13);
        root.right.right=new TreeNode(4);
        root.right.right.left=new TreeNode(5);
        root.right.right.right=new TreeNode(1);
        int targetSum=22;
        pathSum(root,targetSum);

    }
    private static void solve(TreeNode root, int targetSum,List<Integer> temp,List<List<Integer>> result){
        if(root==null){
            return;
        }
        temp.add(root.val);

        if(root.left==null && root.right==null){
            if(targetSum==root.val){
                result.add(new ArrayList<>(temp));
            }
            return;
        }







            solve(root.left, targetSum - root.val, temp, result);



            solve(root.right, targetSum - root.val, temp, result);

    }
    public static List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result=new ArrayList<>();

        if(root==null){
            return result;
        }
        solve(root,targetSum,new ArrayList<>(),result);
        return result;
    }
}

