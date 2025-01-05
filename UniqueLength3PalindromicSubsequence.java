import java.util.*;
public class UniqueLength3PalindromicSubsequence {

    public static void main(String [] args){
        String s="aabca";
        countPalindromicSubsequence(s);

    }

    public static  int countPalindromicSubsequence(String s) {

        int [] first=new int[26];
        int [] last=new int [26];
        Arrays.fill(first,-1);
        Arrays.fill(last,-1);
        for(int i=0;i<s.length();i++){
            if(first[s.charAt(i)-'a']==-1){
                first[s.charAt(i)-'a']=i;
            }
            last[s.charAt(i)-'a']=i; //keep updating all the time
        }

        //[0,4],[2,-1][3,-1] //aabca
        int result=0;
        for(int i=0;i<26;i++){
            int leftMostIdx=first[i];
            int rightMostIdx=last[i]; //if 0 then its of a like this
            if(leftMostIdx==-1){
                continue;
            }
            HashSet<Character> set=new HashSet<>();
            for(int middle=leftMostIdx+1;middle<rightMostIdx;middle++){
                set.add(s.charAt(middle));
            }

            result=result+set.size();
        }
        return result;

    }
}
