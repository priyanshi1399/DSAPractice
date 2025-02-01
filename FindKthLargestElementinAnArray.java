import java.util.*;
public class FindKthLargestElementinAnArray {

    public static void main(String [] args){
        int [] nums = {3,2,1,5,6,4};
        int k = 2;
        findKthLargest(nums,k);
    }

    public  static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        for(int i=0;i<nums.length;i++){
            pq.add(nums[i]);
            if(pq.size()>k){
                pq.poll();
            }
        }
        return pq.peek();
    }
}
