import java.util.*;
public class Permutation2 {

    public static void main(String [] args){
    int [] nums = {1,2,3};
    permute(nums);
    }

    public static  void swap(int x,int y,int [] nums){
        int temp=nums[x];
        nums[x]=nums[y];
        nums[y]=temp;
    }

    public  static void solve(int idx,int [] nums,int n,List<List<Integer>> result){
        List<Integer> temp =new ArrayList<>();
        if(idx==n){
            for(int i=0;i<nums.length;i++){
                temp.add(nums[i]);
            }

            result.add(temp);
            return;
        }

        for(int i=idx;i<n;i++){

            swap(i,idx,nums);

            solve(idx+1,nums,n,result);

            swap(i ,idx,nums);
        }
    }
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result=new ArrayList<>();
        int n=nums.length;
        solve(0,nums,n,result);
        return result;

    }
}
