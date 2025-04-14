import java.util.ArrayList;
import java.util.*;
public class WordBreak {

    public static void main(String [] args){
        String s = "catsandog";
        ArrayList<String> wordDict =new ArrayList<>(Arrays.asList("cats","dog","sand","and","cat"));
        wordBreak(s,wordDict);
    }

    private static boolean solve(int idx,String s,int n,List<String> wordDict){
        if(idx==n){
            return true;
        }
        if(wordDict.contains(s)){
            return true;
        }

        for(int l=1;l<=n;l++){
            String subStr=s.substring(idx,idx+l);
            if(wordDict.contains(subStr) && solve(idx+l,s,n,wordDict)){
                return true;
            }
        }
        return false;
    }

    public static boolean wordBreak(String s, List<String> wordDict) {
        int n=s.length();
        return solve(0,s,n,wordDict);
    }


}
