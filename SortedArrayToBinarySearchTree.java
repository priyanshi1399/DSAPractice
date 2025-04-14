public class SortedArrayToBinarySearchTree {
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

    public static  void main(String [] args){
        int [] nums = {-10,-3,0,5,9};
        sortedArrayToBST(nums);
    }

    private static TreeNode solve(int l,int h,int [] nums){
        if(l>h){
            return null;
        }
        int mid=l+(h-l)/2;
        TreeNode root=new TreeNode(nums[mid]);
        root.left=solve(l,mid-1,nums);
        root.right=solve(mid+1,h,nums);
        return root;
    }
    public static TreeNode sortedArrayToBST(int[] nums) {
        return solve(0,nums.length-1,nums);
    }
}
