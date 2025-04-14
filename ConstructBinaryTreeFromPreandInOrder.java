public class ConstructBinaryTreeFromPreandInOrder {

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
        int [] preorder={3,9,20,15,7};
        int [] inorder={9,3,15,20,7};
        buildTree(preorder,inorder);

    }
    private static int idx=0;
    public static TreeNode solve(int[] preorder, int[] inorder,int start,int end){
        if(start>end){
            return null;
        }

        TreeNode root=new TreeNode(preorder[idx]); //making the root
        int i=start;
        for(;i<=end;i++){
            if(inorder[i]==root.val){
                break;
            }
        }
        idx++;
        root.left=solve(preorder,inorder,start,i-1);
        root.right=solve(preorder,inorder,i+1,end);
        return root;
    }
    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        int n=preorder.length;
        return solve(preorder,inorder,0,n-1);
    }
}
