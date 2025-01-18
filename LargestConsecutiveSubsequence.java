import java.util.*;
public class LargestConsecutiveSubsequence {

    public static void main(String [] args){
    int [] nums={0,3,7,2,5,8,4,6,0,1};
    longestConsecutive(nums);
    }

    public static int longestConsecutive(int[] nums) {
        HashMap<Integer,Integer> map=new HashMap<>();
        int ans=0;
        for(int i=0;i<nums.length;i++){
            int x=nums[i];
            if(!map.containsKey(x)){
                int left=map.getOrDefault(x-1,0);
                int right=map.getOrDefault(x+1,0);
                int len=1+left+right;
                map.put(x,len);
                map.put(x-left,len);
                map.put(x+right,len);
                ans=Math.max(ans,len);

            }

        }
        return ans;
    }
}
