import com.sun.source.tree.Tree;

import java.util.*;
public class SumRootToLeafNumbers {

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

        TreeNode root=new TreeNode(1);
        root.left=new TreeNode(0);
        root.right=new TreeNode(1);
        root.left.left=new TreeNode(0);
        root.left.right=new TreeNode(1);
        root.right.left=new TreeNode(0);
        root.right.right=new TreeNode(1);

        sumRootToLeaf(root);
    }


    private static int solve(TreeNode root, int curr){
        if(root==null){
            return 0;
        }
        curr=2*curr+root.val;
        if(root.left==null && root.right==null){
            return curr;
        }
        int l=solve(root.left,curr);
        int r=solve(root.right,curr);

        return l+r;
    }
    public static int sumRootToLeaf(TreeNode root) {
        int curr=0;
        return solve(root,curr);

    }
}
