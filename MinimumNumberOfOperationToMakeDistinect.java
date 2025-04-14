import java.util.*;
public class MinimumNumberOfOperationToMakeDistinect {

    public static void main(String [] args){

        int [] nums={3,7,12,12,3,14,1,1};
        minimumOperations(nums);

    }
    public static int minimumOperations(int[] nums) {
        List<Integer> arr=new ArrayList<>();

        for(int i=0;i<nums.length;i++){
            arr.add(nums[i]);
        }
        int n=nums.length;
        int op=0;
        int idx=0;
        while(!distinctArray(arr,idx,n,nums)){
            if(arr.size()<3){
                op++;
                return op;
            }
            op++;
            idx=idx+3;
            arr.clear();
            for(int i=idx;i<nums.length;i++){
                arr.add(nums[i]);
            }

        }
        return op;

    }
    public static boolean distinctArray(List<Integer> arr,int idx,int n,int [] nums){
        if(arr.size()<1){
            return true;
        }

        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=idx;i<n;i++){
            map.put(nums[idx],map.getOrDefault(nums[idx],0)+1);
        }
        for(Map.Entry<Integer,Integer> entry:map.entrySet()){
            if(entry.getValue()>1){
                return false;
            }
        }
        return true;
    }
}
