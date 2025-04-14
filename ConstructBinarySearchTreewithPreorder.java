import java.util.*;
public class ConstructBinarySearchTreewithPreorder {

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
        int [] preorder= {8,5,1,7,10,12};
         bstFromPreorder(preorder);
    }

    public static  TreeNode bstFromPreorder(int [] preorder){
        int [] idx={0};

        return solve(preorder,Integer.MAX_VALUE,idx);
    }
    public static TreeNode solve(int [] preorder, int bound, int [] idx){
        if(idx[0]>=preorder.length || preorder[idx[0]]>bound){
            return null;
        }
        TreeNode root=new TreeNode(preorder[idx[0]++]);
        root.left=solve(preorder,root.val,idx);
        root.right=solve(preorder,bound,idx);
        return root;
    }


}
