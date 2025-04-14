import java.util.*;
public class TopKfrequentElement {

    public static void main(String [] args){
        int  [] nums = {1,1,1,2,2,3};
        int k = 2;
        topKFrequent(nums,k);
    }

    public  static int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> map=new HashMap<>();
        int n=nums.length;
        for(int i=0;i<n;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }


        Map<Integer,List<Integer>> bucket=new HashMap<>();
        for(Map.Entry<Integer,Integer> entry:map.entrySet()){
            int freq=entry.getValue();
            int value=entry.getKey();
            if(!bucket.containsKey(freq)){
                List<Integer> res=new ArrayList<>();
                res.add(value);
                bucket.put(freq,res);
            }
            else{
                bucket.get(freq).add(value);
            }
        }

        for(Map.Entry<Integer,List<Integer>> entry:bucket.entrySet()){
            System.out.println(entry.getKey() +":" +entry.getValue());

        }

        int [] res=new int[k];
        int index=0;
        for(Map.Entry<Integer,List<Integer>> entry:bucket.entrySet()){

            if(entry.getValue().size()==0){
                continue;
            }
            while(entry.getValue().size()>0 && k>0){
                int s=entry.getValue().size();
                for(int i=0;i<s;i++){
                    res[index]=entry.getValue().get(i);
                    index++;
                    k--;
                }



            }
        }


        return res;
    }
}
