import java.util.*;

public class MinimumDepthOfBinaryTree {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int data) {
            this.val = data;
        }

        public TreeNode(int data, TreeNode l, TreeNode r) {
            this.val = data;
            this.left = l;
            this.right = r;
        }
    }
        public static void main(String [] args){
            TreeNode root=new TreeNode(3);
            root.left=new TreeNode(9);
            root.right=new TreeNode(20);
            root.right.left=new TreeNode(15);
            root.right.right=new TreeNode(7);
            minDepth(root);

        }

    public  static int minDepth(TreeNode root) {
        if(root==null){
            return 0;
        }
        Queue<TreeNode> q=new LinkedList<>();
        TreeNode curr=root;
        q.add(curr);
        int depth=1;
        while(!q.isEmpty()){
            int n=q.size();
            while(n-- >0){
                curr=q.peek();
                q.poll();
                if(curr.left==null && curr.right==null){
                    return depth;
                }

                if(curr.left!=null){
                    q.add(curr.left);
                }
                if(curr.right!=null){
                    q.add(curr.right);
                }
            }
            depth++;
        }
        return -1;

    }
    }



