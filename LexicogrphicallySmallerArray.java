import java.util.*;
public class LexicogrphicallySmallerArray {

    public static void main(String [] args){
        int [] nums = {1,5,3,9,8};
        int limit = 2;
        lexicographicallySmallestArray(nums,limit);
    }

    public static int[] lexicographicallySmallestArray(int[] nums, int limit) {
        int [] arr=new int[nums.length];
        for(int i=0;i<nums.length;i++){
            arr[i]=nums[i];
        }

        Arrays.sort(arr);
        for(int i=0;i<arr.length;i++){
            System.out.println(arr[i]);
        }
        List<Integer> list1=new ArrayList<>();
        List<Integer> list2=new ArrayList<>();
        HashMap<Integer,Integer> map =new HashMap<>();
        int groupNum=0;
        list1.add(arr[0]);
        map.put(arr[0],groupNum);
        int i=1;
        for(;i<arr.length;i++){
            if(Math.abs(arr[i]-arr[i-1])>limit){
                groupNum++;
                break;
            }
            else{
                list1.add(arr[i]);
                map.put(arr[i],groupNum);

            }
        }

        for(int j=i;j<arr.length;j++){
            if(Math.abs(arr[j]-arr[j-1])>limit){
                groupNum++;
                break;
            }
            else{
                list2.add(arr[j]);
                map.put(arr[j],groupNum);

            }
        }


        Collections.reverse(list1);
        Collections.reverse(list2);
        for(i=0;i<list1.size();i++){
            System.out.println("List1 elements is" +list1.get(i));
        }
        for(i=0;i<list2.size();i++){
            System.out.println("List2 element is"+list2.get(i));
        }
        for(Map.Entry<Integer,Integer> entry:map.entrySet()){
            System.out.println(entry.getKey() +":" +entry.getValue());
        }
        int [] ans=new int[arr.length];
        for(i=0;i<arr.length;i++){
            if(map.containsKey(nums[i])){
                if(map.get(nums[i])==0){
                    ans[i]=list1.get(list1.size()-1);
                    list1.remove(list1.size()-1);
                }
                if(map.get(nums[i])==1){
                    ans[i]=list2.get(list2.size()-1);
                    list2.remove(list2.size()-1);
                }
            }
        }

        return ans;
    }
}
