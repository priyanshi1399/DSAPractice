import java.util.*;
public class LongestSubstringWithoutRepeatingCharacter {

    public static void main(String [] args){
        String s="abcabcbb";
        lengthOfLongestSubstring(s);
    }
    public static int lengthOfLongestSubstring(String s) {
        int n=s.length();
        //babcad
        int start=0;// starting point of the window
        //our window will not have any repeating characters
        int maxLen=0; //Final answer
        HashMap<Character,Integer> map=new HashMap<>();
        /*
        maxLen=0
        start=0
        end=0
        map={d:0}
        maxLen=1
        end=1
        char at end=a
         map={d:0,a:1}
         maxLen=2
         now b
         map={d:0,a:1, b:2}
         maxLen=3
            now c
            maxLen=4
            start=2
            end=4
         map={d:0,a:1, b:2 c:3}







        */
        for(int end=0;end<n;end++){
            char ch=s.charAt(end);
            if(map.containsKey(ch)){
                start=Math.max(start,map.get(ch)+1);
            }
            map.put(ch,end);
            maxLen=Math.max(maxLen,end-start+1);
        }
        return maxLen;

    }

}
