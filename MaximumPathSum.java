public class MaximumPathSum {
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
        TreeNode root=new TreeNode(-10);
        root.left=new TreeNode(9);
        root.right=new TreeNode(20);
        root.right.left=new TreeNode(15);
        root.right.right=new TreeNode(7);
        maxPathSum(root);

    }

    private static int solve(TreeNode root, int [] maxSum){
        if(root==null){
            return 0;
        }

        int left=solve(root.left,maxSum);
        int right=solve(root.right,maxSum);

        if(left<0){
            left=0;
        }
        if(right<0){
            right=0;
        }
        maxSum[0]=Math.max(maxSum[0],left+right+root.val);
        return root.val+Math.max(left,right);
    }
    public static int maxPathSum(TreeNode root) {
        int [] maxSum={Integer.MIN_VALUE};
        solve(root,maxSum);
        return maxSum[0];
    }
}
