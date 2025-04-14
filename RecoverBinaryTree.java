import java.util.*;
public class RecoverBinaryTree {


    public static  class TreeNode{
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
        TreeNode root=new TreeNode(1);
        root.left=new TreeNode(3);
        root.left.right=new TreeNode(2);
        recoverTree(root);

    }

    public static void dfs(TreeNode root,List<Integer> treeValues ){
        if(root==null){
            return;
        }

        dfs(root.left,treeValues);
        treeValues.add(root.val);
        dfs(root.right,treeValues);

    }
    public static void replaceValues(List<Integer> treeValues,TreeNode root,int [] index){
        if(root==null){
            return;
        }

        replaceValues(treeValues,root.left,index);
        root.val=treeValues.get(index[0]);
        index[0]++;
        replaceValues(treeValues,root.right,index);


    }
    public static void recoverTree(TreeNode root) {
        List<Integer> treeValues=new ArrayList<>();
        dfs(root,treeValues);
        Collections.sort(treeValues);
        int [] index={0};
        replaceValues(treeValues,root,index);


    }
}
