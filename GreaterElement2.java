import java.util.*;
public class GreaterElement2 {

    public static void main(String [] args){
    int [] nums={1,5,3,6,8};
    nextGreaterElements(nums);
    }
    public  static int[] nextGreaterElements(int[] nums) {
        Stack<Integer> stack=new Stack<>();
        HashMap<Integer,Integer> map=new HashMap<>();
        int max=0;
        for(int i=0;i<nums.length;i++){
            while(!stack.isEmpty() && nums[stack.peek()]<nums[i]){
                //map.put(nums[stack.pop()],nums[i]);
                max=Math.max(nums[stack.pop()],max);
                map.put(max,nums[i]);

            }
            while(!stack.isEmpty() && i!=stack.peek() ){
                max=Math.max(nums[stack.pop()],max);
                map.put(nums[i],max);

            }
            stack.push(i);
        }

        for(int i=0;i<nums.length;i++){
            nums[i]=map.getOrDefault(nums[i],-1);
        }

        return nums;
    }
}
