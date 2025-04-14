import java.util.*;
public class MaximumLengthStringWithTwoOccurrances {

    public static void main(String[] args){
        String s="bcbbbcba";
        maximumLengthSubstring(s);
    }

    public  static int maximumLengthSubstring(String s) {
        if(s.length()<2){
            return 0;
        }
        HashMap<Character,Integer> map=new HashMap<>();
        int n=s.length();
        int maxLength=0;
        int start=0;
        int end=0;
        while(end<n){
            char ch=s.charAt(end);
            map.put(ch,map.getOrDefault(ch,0)+1);
            if(map.get(ch)<=2){
                maxLength=Math.max(maxLength,end-start+1);
            }
            else if(map.get(ch)>2){
                start=end;
                System.out.println(start);
                map.clear();
            }
            end++;

        }
        return maxLength;
    }
}
