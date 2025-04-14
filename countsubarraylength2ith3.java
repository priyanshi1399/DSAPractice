public class countsubarraylength2ith3 {

public static void main(String [] args){
    int [] nums={1,2,1,4,1};
    countSubarrays(nums);
}
    public static int countSubarrays(int[] nums) {
        if(nums.length<3){
            return 0;
        }
        int count=0;
        int n=nums.length;
        for(int i=0;i<=n-3;i++){
            if((nums[i]+nums[i+2])==(int)((nums[i+1])/2)){
                count++;
            }
        }
        return count;
    }
}
