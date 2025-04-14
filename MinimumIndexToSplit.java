import java.util.*;
public class MinimumIndexToSplit {
    public static void main(String [] args){
        List<Integer> nums = new ArrayList<>(Arrays.asList(1,2,2,2));
        minimumIndex(nums);
    }
    public static int minimumIndex(List<Integer> nums) {
        int n=nums.size();
        int j=0,k=0;
        for(int i=0;i<n;i++){
            HashMap<Integer,Integer> map1=new HashMap<>();
            for(j=0;j<=i;j++){
                map1.put(nums.get(j),map1.getOrDefault(nums.get(j),0)+1);
            }

            HashMap<Integer,Integer> map2=new HashMap<>();
            for(k=i+1;k<n;k++){
                map2.put(nums.get(k),map2.getOrDefault(nums.get(k),0)+1);
            }
            for(Map.Entry<Integer,Integer> entry1:map1.entrySet()){
                int valueToCheck=entry1.getKey();
                if(map1.get(valueToCheck)>(i)/2){
                    if(map2.containsKey(valueToCheck) && map2.get(valueToCheck)>(n-k)/2){
                        return i;
                    }
                    else{
                        break;
                    }
                }
            }
        }
        return -1;

    }
}
