import java.util.*;
public class IsomorphicQuestionString {

public static void main(String [] args){
    String s="abab";
    String t="baba";
    isIsomorphic(s,t);
}
    public static boolean isIsomorphic(String s, String t) {
        HashMap<Character,Character> map1=new HashMap<>();
        HashMap<Character,Character> map2=new HashMap<>();

        if(s.length()!=t.length()){
            return false;
        }

        for(int i=0;i<s.length();i++){
            char ch1=s.charAt(i);
            char ch2=t.charAt(i);
            map1.put(ch1,map1.getOrDefault(map1.get(ch1),ch2));
            map2.put(ch2,map2.getOrDefault(map2.get(ch2),ch1));
        }
        if(map1.size()!=map2.size()){
            return false;
        }

        for(int i=0;i<s.length();i++){
            if(map1.get(s.charAt(i))!=t.charAt(i)){
                return false;
            }
        }
        return true;
    }
}
