import java.util.*;
public class LragestNumber {

    public static void main(String [] args){
       int []  nums = {3,30,34,5,9};
       largestNumber(nums);

    }

    public static String largestNumber(int[] nums) {

        String [] arr=new String[nums.length];
        for(int i=0;i<arr.length;i++){
            arr[i]=String.valueOf(nums[i]);
        }

        for(int i=0;i<arr.length;i++){
            Arrays.sort(arr,(a,b)->(b+a).compareTo(a+b));

            if(arr[0].equals("0")){
                return "0";
            }
        }

        StringBuilder str=new StringBuilder();
        for(int i=0;i<arr.length;i++){
            str.append(arr[i]);
        }

        return str.toString();
    }
}
