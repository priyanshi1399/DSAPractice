public class SubArrayMaximumdivisiblebyLengthK {

    public static void main(String [] args){
        int [] nums={-5,1,2,-3,4};
        int k=2;
        maxSubarraySum(nums,k);
    }
    public static long maxSubarraySum(int[] nums, int k) {
        //prefix sum
        long[] ps = new long[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            ps[i + 1] = ps[i] + nums[i];
        }

        long res = Long.MIN_VALUE;// Result to store the maximum sum

        for (int j = 0; j < k; j++) {
            long sum = 0;
            for (int i = j; i + k <= nums.length; i += k) {
                long subSum = ps[i + k] - ps[i];
                sum = Math.max(subSum, sum + subSum);
                res = Math.max(res, sum);
            }
        }

        return res;
    }
}
