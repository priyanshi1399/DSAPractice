import java.util.*;
public class LonestNiceSubstring {

    public static void main(String [] args){
        String s="YazaAay";
        longestNiceSubstring(s);

    }

    public  static String longestNiceSubstring(String s) {
        if(s.length()==0){
            return "";
        }
        HashMap<Character,Character> map=new HashMap<>();
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if((ch>='a') && (ch<='z') && (s.contains(String.valueOf(Character.toUpperCase(ch))) )){
                map.put(ch,Character.toUpperCase(ch));
            }
        }

        for(Map.Entry<Character,Character> entry:map.entrySet()){
            System.out.println(entry.getKey() +":" + entry.getValue() );
        }

        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if((!map.containsKey(ch)) && (!map.containsValue(ch))){
                String left=longestNiceSubstring(s.substring(0,i));
                String right=longestNiceSubstring(s.substring(i+1,s.length()));
                if(left.length()>=right.length()){
                    return left;
                }
                else{
                    return right;
                }
            }
        }
        return s;
    }
}
