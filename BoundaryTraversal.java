import java.util.*;
public class BoundaryTraversal {
    public static class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;

        public TreeNode(int data) {
            this.data = data;
        }

        public TreeNode(int data, TreeNode left, TreeNode right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }
//1 2 3 4 5 6 7 null null 8 9
    public static void main(String []args){
        TreeNode root=new TreeNode(1);
        root.left=new TreeNode(2);
        root.right=new TreeNode(3);
        root.left.left=new TreeNode(4);
        root.left.right=new TreeNode(5);
        root.right.left=new TreeNode(6);
        root.right.right=new TreeNode(7);
        root.left.right.left=new TreeNode(8);
        root.left.right.right=new TreeNode(9);
        boundary(root);
    }
    public static boolean isLeaf(TreeNode root){
        if(root==null){
            return true;
        }
        if(root.left==null && root.right==null){
            return true;
        }
        return false;
    }
    public static void addLeftBoundary(TreeNode root, List<Integer> result){
        TreeNode curr=root.left;
        while(curr!=null){
            if(isLeaf(curr)==false){
                result.add(root.data);
            }
            if(curr.left!=null){
                curr=curr.left;
            }
            else{
                curr=curr.right;
            }
        }

    }
    public static void addRightBoundary(TreeNode root, List<Integer> result){
        TreeNode curr=root.right;
        List<Integer> temp=new ArrayList<>();
        while(curr!=null){
            if(!isLeaf(curr)){
                temp.add(curr.data);
            }
            if(curr.right!=null){
                curr=curr.right;
            }
            else{
                curr=curr.left;
            }
        }

        for(int i=temp.size()-1;i>=0;i--){
            result.add(temp.get(i));
        }

    }
    public  static void addLeaves(TreeNode root,List<Integer> result){
        if(isLeaf(root)){
            result.add(root.data);
            return;
        }

        if(root.left!=null){
            addLeaves(root.left,result);
        }
        if(root.right!=null){
            addLeaves(root.right,result);
        }

    }
    public static List<Integer> boundary(TreeNode root) {
        List<Integer> result=new ArrayList<>();
        if(root==null){
            return result;
        }
        addLeftBoundary(root,result);
        addLeaves(root,result);
        addRightBoundary(root,result);
        return result;
    }

}
