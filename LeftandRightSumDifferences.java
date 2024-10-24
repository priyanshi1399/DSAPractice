public class LeftandRightSumDifferences {

    public static int [] leftandRightSum(int [] nums){
        int n=nums.length;
        int [] leftSum=new int [n];
        int [] rightSum=new int [n];
        int [] ans=new int [n];

        leftSum[0]=0;
        for(int i=1;i<n;i++){
            leftSum[i]=leftSum[i-1]+nums[i-1]; // prefix sum
        }

        rightSum[n-1]=0;
        for(int i=n-2;i>=0;i--){
            rightSum[i]=rightSum[i+1]+nums[i+1]; //suffix sum
        }

        for(int i=0;i<ans.length;i++){
            ans[i]=Math.abs(leftSum[i]-rightSum[i]);
        }
        return ans;
    }



    public static void main(String [] args){
        int [] nums = {10,4,8,3};
        int [] res=leftandRightSum(nums);
        System.out.println(res);

    }

}
