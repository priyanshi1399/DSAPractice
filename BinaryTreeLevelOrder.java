import com.sun.source.tree.Tree;

import java.util.*;
public class BinaryTreeLevelOrder {

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
//[[3],[20,9],[15,7]]
    public static void main(String [] args){
        TreeNode root=new TreeNode(3);
        root.left=new TreeNode(9);
        root.right=new TreeNode(20);
        root.right.left=new TreeNode(15);
        root.right.right=new TreeNode(7);
        zigzagLevelOrder(root);

    }

    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result=new ArrayList<>();
        if(root==null){
            return result;
        }
        boolean leftToRight=true;
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int n=q.size();
            Integer [] temp=new Integer[n];
            for(int i=0;i<n;i++){
                TreeNode curr=q.poll();
                int index=leftToRight?i:n-1-i;
                temp[index]=curr.val;
                if(curr.left!=null){
                    q.add(curr.left);
                }
                if(curr.right!=null){
                    q.add(curr.right);
                }
            }
            leftToRight=!leftToRight;
            result.add(Arrays.asList(temp));
        }
        return result;

    }


}
