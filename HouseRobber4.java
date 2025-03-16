public class HouseRobber4 {

    public static void main(String [] args){

        int [] nums = {2,3,5,9};
        int k = 2;
        minCapability(nums,k);
    }

    private static int solve(int index,int [] nums,int k,int n){
        if(k==0){
            return 0;
        }

        if(index>=n){
            return Integer.MAX_VALUE;
        }


        int take=Math.max(nums[index],solve(index+2,nums,k-1,n));
        int not_take=solve(index+1,nums,k,n);

        return Math.min(take,not_take);
    }
    public  static int minCapability(int[] nums, int k) {
        int n=nums.length;
        return solve(0,nums,k,n);
    }
}
