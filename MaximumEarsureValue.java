import java.util.*;
public class MaximumEarsureValue {

    public static void main(String [] args){
    int [] nums={5,2,1,2,5,2,1,2,5};
    maximumUniqueSubarray(nums);
    }

    public static int maximumUniqueSubarray(int[] nums) {
        int n=nums.length;
        int start=0;
        int maxSum=0;
        HashMap<Integer,Integer> map=new HashMap();
        int [] prefixSum=new int[n];
        /*
        4,2,4,2,5,6
        prefixSum[0]=4
        prefixSum[1]=6
        prefixSum[2]=10
        prefixSum[3]=15
        prefixSum[4]=21
        map={4:0}
        maxSum=4
        map={4:0, 2:1}
        maxSum=6
        start=1
        */
        for(int end=0;end<n;end++){
            if(end==0){
                prefixSum[end]=nums[end]+prefixSum[end];
            }
            else{
                prefixSum[end]=nums[end]+prefixSum[end-1];
            }

            if(map.containsKey(nums[end])){
                start=Math.max(start,map.get(nums[end])+1);
            }
            map.put(nums[end],end);
            maxSum=Math.max(maxSum,prefixSum[end]-((start>0)?prefixSum[start-1]:0));
            //prefixSum[end]
            //prefixSum[end]-prefixSum[start-1] two things can be done
        }
        return maxSum;

    }
}
