import java.util.*;
public class ContinuousSubArraySum {

    public  static void main(String [] args){
        int [] nums={23,2,6,4,7};
         int k=6;
         checkSubarraySum(nums,k);
    }

    public static boolean checkSubarraySum(int[] nums, int k) {
        int n=nums.length;
        HashMap<Integer,Integer> map=new HashMap<>();
        int sum=0;
        map.put(0,-1);
        for(int i=0;i<n;i++){
            sum=sum+nums[i];
            int rem=sum%k;
            if(rem<0){
                rem=rem+k;
            }
            if(map.containsKey(rem)){
                if(i-map.get(rem)>1){
                    return true;
                }
            }
            else{
                map.put(rem,i);
            }
        }


        return false;
    }
}
