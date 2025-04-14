import java.util.*;
public class LongestNonRepeatingCharacter {

    public static void main(String [] args){
        String s="AABABBA";
        int k=1;
        characterReplacement(s,k);

    }

    public static int characterReplacement(String s, int k) {
        int  n=s.length();
        int [] hash=new int[26];
        int left=0;
        int maxLength=0;
        int maxFreqOfChar=0;
        for(int right=0;right<n;right++){
            hash[s.charAt(right)-'A']++;
            maxFreqOfChar=Math.max(maxFreqOfChar,hash[s.charAt(right)-'A']);

            if((right-left+1)-maxFreqOfChar<=k){
                maxLength=Math.max(maxLength,right-left+1); // calculating the length for which operations are ok
            }

            if((right-left+1)-maxFreqOfChar>k){
                hash[s.charAt(left)-'A']--; //decreasing the frequency of the left Character
               // maxFreqOfChar=Arrays.stream(hash).max().getAsInt();
                left++;
            }


        }
        return maxLength;
    }
}
