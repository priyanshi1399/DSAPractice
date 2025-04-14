import java.util.*;
public class MinimumOperationtoexceedThresholdvalue {

    public static void main(String [] args){
        int [] nums={1000000000,999999999,1000000000,999999999,1000000000,999999999};
        int k=1000000000;
        minOperations(nums,k);
    }

    public static int minOperations(int[] nums, int k) {

        PriorityQueue<Long> pq=new PriorityQueue<>();
        for(int i=0;i<nums.length;i++){
            pq.add((long)nums[i]);
        }
        int count=0;
        while(pq.peek()<k){
            long value1=pq.peek();
            pq.poll();
            long value2=pq.peek();
            pq.poll();
            pq.add(Math.min(value1,value2)*2+Math.max(value1,value2));
            count++;
            if(pq.size()==1){
                return count;
            }
        }
        return count;
    }
}
