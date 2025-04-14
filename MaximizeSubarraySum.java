import java.util.*;
public class MaximizeSubarraySum {

    public static void main(String [] args){
    int [] nums={-31,-23,-47};
    maxSubarraySum(nums);
    }

    public static long maxSubarraySum(int[] nums) {
        long sum=0;
        long answer=Long.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            sum=Math.max(nums[i],sum+nums[i]);
            answer=Math.max(answer,sum);

        }
        // System.out.println(answer);

        List<Integer> lst=new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            if(!lst.contains(nums[i])){
                lst.add(nums[i]);
            }

        }

        long maxVal=Long.MIN_VALUE;
        while(lst.size()>0){
            sum=0;
            long answer1=Long.MIN_VALUE;
            int k=lst.get(0);
            for(int i=0;i<nums.length;i++){
                sum=Math.max(sum+((nums[i]==k)?0:nums[i]),(nums[i]==k)?0:nums[i]);
                answer1=Math.max(answer1,sum);

            }
            maxVal=Math.max(maxVal,answer1);
            lst.remove(lst.get(0));
        }
        // System.out.println(Math.max(maxVal,answer));
        return Math.max(maxVal,answer);
    }
}
