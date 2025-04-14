import java.util.*;
public class BinaryTreeRepresentation {
    
    public static class TreeNode{
        int val;
        TreeNode left,right;

        public TreeNode(int data){
            this.val=data;
        }

        public TreeNode (int data,TreeNode l,TreeNode r){
            this.val=data;
            this.left=l;
            this.right=r;
        }
    }
    public static void main(String [] args){
    ArrayList<Integer> v=new ArrayList<>();
    v.add(1);
    v.add(2);
    v.add(3);
    v.add(4);
    v.add(5);
    v.add(6);
    v.add(7);
    TreeNode root0=new TreeNode(1);
    createTree(root0,v);
    }

    public static void createTree(TreeNode root0, ArrayList<Integer> v ){
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root0);
        int n=v.size();
        for(int i=0;i<n && !q.isEmpty();i++){
            TreeNode root=q.poll();
            if(2*i+1<n){
                TreeNode leftTreeNode=new TreeNode(v.get(2*i+1));
                root.left=leftTreeNode;
                q.add(leftTreeNode);

            }

            if(2*i+2<n){
                TreeNode rightTreeNode=new TreeNode(v.get(2*i+2));
                root.right=rightTreeNode;
                q.add(rightTreeNode);
            }
        }

    }

}
