import java.util.*;
public class WordsSubsets {

    public static void main(String [] args){

        String [] words1 = {"amazon","apple","facebook","google","leetcode"};
        String [] words2 = {"e","o"};
        wordSubsets(words1,words2);
    }




    public static  List<String> wordSubsets(String[] words1, String[] words2) {
        List<String> res=new ArrayList<>();

        int [] freq2=new int [26];
        for(String words: words2){

            int [] temp=new int[26];

            for(char ch: words.toCharArray()){
                temp[ch-'a']++;

                freq2[ch-'a']=Math.max( freq2[ch-'a'],temp[ch-'a']);
            }
        }


        for(String word: words1){
            int [] freq1=new int [26];
            for(char ch1: word.toCharArray()){
                freq1[ch1-'a']++;
            }

            if(isCheckSubset(freq1,freq2)){
                res.add(word);
            }
        }
        return res;
    }

    public static  boolean isCheckSubset(int [] words1,int [] words2){

        for(int i=0;i<26;i++){
            if(words1[i]<words2[i]){
                return false;
            }
        }
        return true;
    }
}
