import java.util.*;
public class HouseRobber2 {

    public static void main(String [] args){
    int [] nums={1,2,3,1};
    rob(nums);
    }

    public static int helper(int index, int n,int [] nums,int [] dp){
        if(index>n){
            return 0;
        }
        if(dp[index]!=-1){
            return dp[index];
        }
        int include=nums[index]+helper(index+2,n,nums,dp);
        int exclude=helper(index+1,n,nums,dp);

        dp[index]= Math.max(include,exclude);
        return dp[index];
    }
    public static int rob(int[] nums) {
        int n=nums.length;
        int [] dp=new int [n+1];
        Arrays.fill(dp,-1);
        if(n==1){ //one house rob that
            return nums[0];
        }
        if(n==2){
            return Math.max(nums[0],nums[1]);
        }
        int take_0th_house=helper(0,n-2,nums,dp);

        Arrays.fill(dp,-1);

        int take_1th_house=helper(1,n-1,nums,dp);
        return Math.max(take_0th_house,take_1th_house);
    }
}
