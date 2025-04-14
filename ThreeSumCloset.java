import java.util.*;
public class ThreeSumCloset {

    public static void main(String [] args){
    int [] nums={1,1,1,0};
    int target=-100;
    threeSumClosest(nums,target);
    }

    public static  int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int n=nums.length;
        int i=0;
        int j=0;
        int k=0;
        int sum=0;
        for(;i<=n-3;i++){
            j=i+1;
            k=n-1;
            sum=0;
            sum=sum+nums[i]+nums[j]+nums[k];
            while(j<k){
                sum=0;
                sum=sum+nums[i]+nums[j]+nums[k];
                if(sum<target){
                    j++;
                }

                else if(sum>target){
                    k--;
                }

            }
        }

        return sum;
    }

}
