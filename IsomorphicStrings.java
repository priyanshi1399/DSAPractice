import java.util.*;
public class IsomorphicStrings {

    public static void main(String [] args){
    String s="badc";
    String t="baba";
    isIsomorphic(s,t);
    }
    public static  boolean isIsomorphic(String s, String t) {
        HashMap<Character,Character> map=new HashMap<>();
        for(int i=0;i<s.length();i++){
            if((map.containsKey(s.charAt(i))) && map.get(s.charAt(i))==s.charAt(i)){
                s=s.replace(s.charAt(i),map.get(s.charAt(i)));
                System.out.println(s);
            }
            else  if((map.containsKey(s.charAt(i))) && map.get(s.charAt(i))!=s.charAt(i)){
                i++;
            }
            else{
                map.put(s.charAt(i),t.charAt(i));
                s=s.replace(s.charAt(i),t.charAt(i));
                System.out.println(s);
            }
        }
        if(s.equals(t)){
            return true;
        }
        return false;
    }
}


