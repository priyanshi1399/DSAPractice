import java.util.*;
public class HouseRobberSecond {
    public static void main(String [] args){
    int [] nums={1,2,3};
    rob(nums);

    }
    private static int solve(int index,int [] nums,int n,int [] dp){
        if(index>n){
            return 0;
        }
        if(dp[index]!=-1){
            return dp[index];
        }


        int steal=nums[index]+solve(index+2,nums,n,dp);
        int skip=solve(index+1,nums,n,dp);

        dp[index]=Math.max(steal,skip);
        return dp[index];

    }
    public static int rob(int[] nums) {
        int n=nums.length;
        int [] dp=new int[n+1];
        Arrays.fill(dp,-1);
        if(nums.length==1){
            return nums[0];
        }

        if(nums.length==2){
            return Math.max(nums[0],nums[1]);
        }

        int take_0th_House=solve(0,nums,n-2,dp);

        int take_1th_house=solve(1,nums,n-1,dp);
        return Math.max(take_0th_House,take_1th_house);
    }

}

