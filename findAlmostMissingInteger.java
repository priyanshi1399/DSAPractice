import java.util.*;
public class findAlmostMissingInteger {
    public static void main(String [] args){
        int [] nums={0,0};
        int k=2;
        largestInteger(nums,k);
    }
    public static  int largestInteger(int[] nums, int k) {
        int n=nums.length;
        List<Integer> res=new ArrayList<>();
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<=n-k;i++){
            for(int j=i;j<i+k;j++){
                map.put(nums[j],map.getOrDefault(nums[j],0)+1);
            }
        }
        for(Map.Entry<Integer,Integer> entry:map.entrySet()){
            if(entry.getValue()==1){
                res.add(entry.getKey());
            }
        }
        if(res.isEmpty()){
            return -1;
        }
        Collections.sort(res);

        return res.get(res.size()-1);
    }
}
