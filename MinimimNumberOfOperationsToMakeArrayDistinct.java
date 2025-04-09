import java.util.*;
public class MinimimNumberOfOperationsToMakeArrayDistinct {

    public static void main(String [] main){
    int [] nums={1,2,3,4,2,3,3,5,7};
    int k=minimumOperations(nums);
    System.out.println(k);
    }

    public static int minimumOperations(int[] nums) {

        int i=0;
        int op=0;
        int n=nums.length;
        while(i<n){
            int j=i;
            HashMap<Integer,Integer> map=new HashMap<>();
            while(j<n){
                map.put(nums[j],map.getOrDefault(nums[j],0)+1);
                if(map.get(nums[j])==2){
                    op++;
                    break;
                }
                else{
                    j++;
                }
            }
            i=i+3;
        }
        return op;
    }
}
