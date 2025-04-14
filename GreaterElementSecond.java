import java.util.*;
public class GreaterElementSecond {
    public static void main(String[] args){
        int [] nums={1,2,1};
        nextGreaterElements(nums);

    }


    public static int[] nextGreaterElements(int[] nums) {
        int n=nums.length;
        int res[] =new int[n];
        Arrays.fill(res,-1);
        Stack<Integer> s=new Stack<>();
        for(int i=0;i<2*n;i++){
            while(!s.isEmpty() && nums[i%n]>nums[s.peek()]){
                res[s.pop()]=nums[i%n];
            }
            s.push(i%n);
        }
        return res;
    }
}
