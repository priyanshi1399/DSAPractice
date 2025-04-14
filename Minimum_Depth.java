import java.util.*;
public class Minimum_Depth {
    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int data){
            this.val=data;
        }

        public TreeNode(int data,TreeNode left,TreeNode right){
            this.val=data;
            this.left=left;
            this.right=right;
        }
    }
    public static void main(String [] args){
        TreeNode root=new TreeNode(2);
        root.right=new TreeNode(3);
        root.right.right=new TreeNode(4);
        root.right.right.right=new TreeNode(5);
        root.right.right.right.right=new TreeNode(6);
        minDepth(root);

    }
    public static int minDepth(TreeNode root) {
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        int depth=1;
        while(!q.isEmpty()){
            int n=q.size();
            while(n -->0){
                TreeNode curr=q.poll();
                if(curr.left!=null){
                    q.add(curr.left);
                }
                if(curr.right!=null){
                    q.add(curr.right);
                }
                else if(curr.left==null && curr.right==null) {
                    return n;
                }
            }
            depth++;
        }
        return -1;
    }

}
