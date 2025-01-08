import java.util.*;
public class MirrorScoreOfAString {


    public static void main(String [] args){
    String s="aaczzx";
    calculateScore(s);
    }

    public  static long calculateScore(String s) {
        HashMap<Character,Stack<Integer>> map=new HashMap<>();
        long score=0;
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            int distance=c-'a';
            char mirror=(char)('z'-distance);

            if(map.containsKey(mirror) && !map.get(mirror).isEmpty()){
                score+=i-map.get(mirror).pop();
            }
            else{
                map.computeIfAbsent(c,k->new Stack<>()).push(i);
            }
        }
        return score;
    }
}
