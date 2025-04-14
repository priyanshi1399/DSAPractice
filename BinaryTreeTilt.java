public class BinaryTreeTilt {

    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val){
            this.val=val;

        }

        public TreeNode(int val,TreeNode l,TreeNode r){
            this.val=val;
            this.left=l;
            this.right=r;
        }
    }

    public static void main(String [] args){
        TreeNode root=new TreeNode(4);
        root.left=new TreeNode(2);
        root.right=new TreeNode(9);
        root.left.left=new TreeNode(3);
        root.left.right=new TreeNode(5);
        root.right.right=new TreeNode(7);
        findTilt(root);
    }

    private static int solve(TreeNode root, int [] sum){
        if(root==null){
            return 0;
        }

        int left=solve(root.left,sum);
        int right=solve(root.right,sum);

        sum[0]+=Math.abs(left-right);
        return left+right+root.val;

    }
    public static int findTilt(TreeNode root) {
        int [] sum={0};
        solve(root,sum);
        return sum[0];
    }
}
