import java.util.*;
public class MaximumWidthramp {

    public static void main(String [] args){
        int [] nums = {6,0,8,2,1,5};
        maxWidthRamp(nums);

    }
    public static int maxWidthRamp(int[] nums) {
        int n=nums.length;
        Stack<Integer> stck=new Stack<>();
        int maxValue=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            stck.push(nums[i]);
            for(int j=i+1;j<n;j++){
                if(i+1<n && !stck.isEmpty() && nums[stck.peek()]<=nums[j]){
                    maxValue=Math.max(maxValue,j-i);
                }
            }
        }
        return maxValue;
    }
}
