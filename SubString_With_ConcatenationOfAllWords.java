import java.util.*;
public class SubString_With_ConcatenationOfAllWords {

    public static void main(String [] args){
        String s="barfoothefoobarman";
        String [] words={"foo","bar"};
        findSubstring(s,words);
    }

    public static  List<Integer> findSubstring(String s, String[] words) {
        HashMap<String,Integer> wordsCount=new HashMap<>();
        for(int i=0;i<words.length;i++){
            wordsCount.put(words[i],wordsCount.getOrDefault(words[i],0)+1);
        }

        List<Integer> index=new ArrayList<>();
        int n=s.length(), wordsLength=words.length, stringLen=words[0].length();
        for(int i=0;i<n-wordsLength*stringLen+1;i++){
            HashMap<String,Integer> seen=new HashMap<>();
            int j=0;
            while(j<stringLen){
                String word=s.substring(i+j*stringLen, i+(j+1)*stringLen);
                if(wordsCount.containsKey(word)){
                    seen.put(word, seen.getOrDefault(word,0)+1);
                    if(seen.get(word)>wordsCount.get(word)){
                        break;
                    }
                }
                else{
                    break;
                }
                j++;
            }
            if(j==wordsLength){
                index.add(i);
            }
        }
        return index;
    }
}
