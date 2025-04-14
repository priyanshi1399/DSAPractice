import java.util.*;
public class CountOfSubStringContainingVowelConsonant {

    public static void main(String [] args){
        String word="iqeaouqi";
        int k = 2;
        countOfSubstrings(word,k);
    }

    public  static int countOfSubstrings(String word, int k) {
        int n=word.length();
        int result=0;
        for(int i=0;i<n;i++){
            int countCons=0;
            HashMap<Character,Integer> map=new HashMap<>();
            for(int j=i;j<n;j++){
                char ch=word.charAt(j);
                if(ch=='a' || ch=='e' || ch=='i' || ch=='o' || ch=='u'){
                    map.put(ch,map.getOrDefault(ch,0)+1);
                }
                else{
                    countCons++;
                }

                if(map.size()==5 && countCons==k){
                    result++;
                }

                if(map.size()==5 && countCons>k){
                    break;
                }
            }
            for(Map.Entry<Character,Integer> entry: map.entrySet()){
                System.out.println(entry.getKey() + ":"+ entry.getValue());
            }
        }
        return result;
    }
}
