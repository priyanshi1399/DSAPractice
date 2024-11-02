public class BitManipulation {

    public static void main(String [] args){
        int [] nums={3,0,1};
        missingNumber(nums);
    }

    public static int missingNumber(int[] nums) {
        int ans=0;
       // int ans = nums.length;
        for (int i = 0; i < nums.length; i++) {
            ans=ans^nums[i]^(i+1);

        }
        return ans;
    }
}