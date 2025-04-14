import java.util.*;
public class LongestSubstringWithAtleastKRepeatingCharacter {
    public static void main(String [] args){
    String s="ababacb";
    int k=3;
    longestSubstring(s,k);
    }

    public static int longestSubstring(String s, int k) {
        if(s.length()==0){
                return 0;
        }

        HashMap<Character, Integer> map=new HashMap<>();

        for(int i=0;i<s.length();i++){
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }


        //  for(Map.Entry<Character,Integer> ent: map.entrySet()){
        //     System.out.println(ent.getKey() + ":" + ent.getValue());
        //  }


        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(map.get(ch)<k){
                int leftPart=longestSubstring(s.substring(0,i),k);
                int rightPart=longestSubstring(s.substring(i+1,s.length()),k);
                return Math.max(leftPart,rightPart);
            }
        }
        return s.length();
    }
}
