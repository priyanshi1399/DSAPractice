import java.util.*;
public class LongestPalindromic {
    public static void main(String[] args){
    String s="babad";
    longestPalindrome(s);
    }

    public static boolean checkPalindrome(String s1){
        StringBuilder str=new StringBuilder();
        str.append(s1);
        if((str.reverse().toString()).equals(s1)){
            return true;
        }
        return false;
    }
    public static String longestPalindrome(String s) {
        if(s.length()==1){
            return s;
        }
        HashMap<Integer,String> map=new HashMap<>();
        int maxLength=0;
        int i=0;
        while(i<s.length()-1){
            int j=i+1;
            while(j<s.length()){
                String subPart="";
                subPart=s.substring(i,j);
                System.out.println(subPart);
                if(checkPalindrome(subPart)){
                    maxLength=Math.max(maxLength,j-i+1);
                    map.put(maxLength,subPart);
                }
                j++;
            }
            i++;
        }
        return map.get(maxLength);
    }
}
