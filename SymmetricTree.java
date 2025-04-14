import java.util.*;
public class SymmetricTree {

        public static class TreeNode{
            int val;
            TreeNode left,right;

            public TreeNode(int data){
               this.val=data;

            }
            public TreeNode(int data,TreeNode l,TreeNode r){
                this.val=data;
                this.left=l;
                this.right=r;
            }
        }
    public static void main(String [] args) {
        SymmetricTree sm = new SymmetricTree();
        TreeNode root = new TreeNode(1);
        root.left=new TreeNode(2);
        root.right=new TreeNode(2);
        root.left.left=new TreeNode(3);
        root.left.right=new TreeNode(4);
        root.right.left=new TreeNode(4);
        root.right.right=new TreeNode(3);

        isSymmetric(root);
    }

    public static boolean solve(TreeNode l, TreeNode r){
        if(l==null && r==null){
            return true;
        }
        if(l==null || r==null){
            return false;
        }

        if(l.val==r.val && solve(l.left,r.right) && solve(l.right,r.left)){
            return true;
        }
        return false;
    }
    public static boolean isSymmetric(TreeNode root) {
        return  solve(root.left,root.right);
    }

    }



