public class ProductOfArrayExceptSelf {

    public static void main(String [] args){
        int [] nums={1,2,3,4};
        productExceptSelf(nums);

    }
    public static int[] productExceptSelf(int[] nums) {
        int [] ans=new int[nums.length];
        for(int i=0;i<nums.length;i++){
            ans[i]=1;
        }
        int left=1;
        for(int i=0;i<nums.length;i++){
            ans[i]*=left;
            left*=nums[i];
        }
        int right=1;
        for(int i=nums.length-1;i>=0;i--){
            ans[i]*=right;
            right*=nums[i];
        }
        return ans;

    }
}

