import java.util.*;
public class FindAllAnagraminAllStrings {

    public static void main(String [] args){
       String s = "cbaebabacd";
       String p = "abc";
       findAnagrams(s,p);
    }

    public static boolean isEqual(int [] countA, int [] countB){
        boolean flag=true;

        for(int i=0;i<26;i++){
            if(countA[i]!=countB[i]){
                flag=false;
                break;
            }
        }
        return flag;
    }
    public static List<Integer> findAnagrams(String s, String p) {
        int lP=p.length();
        List<Integer> l=new ArrayList<>();
        if(s.length()<lP){
            return l;
        }
        int  [] countS= new int [26];
        int  [] countP= new int [26];

        for(int i=0;i<lP;i++){
            countS[s.charAt(i)-'a']++;
            countP[p.charAt(i)-'a']++;
        }
        if(isEqual(countS,countP)){
            l.add(0);
        }
        for(int i=lP;i<s.length();i++){
            countS[s.charAt(i)-'a']++;
            countS[s.charAt(i-lP)-'a']--;
            if(isEqual(countS,countP)){
                l.add(i-lP+1);
            }
        }
        return l;

    }
}
