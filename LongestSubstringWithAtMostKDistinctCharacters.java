import java.util.*;
public class LongestSubstringWithAtMostKDistinctCharacters {

    public static void main(String [] args){
        String s="aababbcaacc";
        int k=2;
        kDistinctChar(s,k);
    }

    public static int kDistinctChar(String s, int k) {
        HashMap<Character,Integer> map=new HashMap<>();

        int maxLength=0;
        for(int i=0;i<s.length();i++){
            for(int j=i;j<s.length();j++){
                char ch=s.charAt(j);
                map.put(ch,map.getOrDefault(ch,0)+1);

                if(map.size()<=k){
                    maxLength=Math.max(maxLength,j-i+1);
                    //maxLength=Math.max(maxLength,s.substring(i,j)); then it works till one position before so we have to do maxLength+1
                }

                if(map.size()>k){
                    map.clear();
                    break;
                }
            }
        }
        return maxLength;
    }
}
