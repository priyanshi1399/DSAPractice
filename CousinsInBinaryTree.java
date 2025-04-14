import java.util.*;
public class CousinsInBinaryTree {
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
        TreeNode root=new TreeNode(1);
        root.left=new TreeNode(2);
        root.right=new TreeNode(3);
        root.left.left=new TreeNode(4);
        int x=4;
        int y=3;
        isCousins(root,x,y);
    }

        private static Map<Integer,Integer> parentMap=new HashMap<>();

        public static void inorder(TreeNode root){
            if(root==null){
                return;
            }

            if(root.left!=null){
                parentMap.put(root.left.val,root.val);
            }
            inorder(root.left);
            if(root.right!=null){
                parentMap.put(root.right.val,root.val);
            }
            inorder(root.right);

        }
        public static  int depth(TreeNode root,int val,int d){
            if(root==null){
                return -1;
            }
            if(root.val==val){
                return d;
            }
            int l=depth(root.left,val,d+1);
            if(l!=-1){
                return l;
            }
            return depth(root.right,val,d+1);
        }
        public static boolean isCousins(TreeNode root, int x, int y) {
            int Xdepth =depth(root,x,0);
            int Ydepth =depth(root,y,0);
            inorder(root);
            if((parentMap.get(x)!=parentMap.get(y)) && Xdepth==Ydepth){
                return true;
            }
            return false;
        }
    }

