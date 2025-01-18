import java.util.*;
public class MostCommonWord {

    public static void main(String [] args){
      String paragraph = "Bob. hIt, baLl";
      String [] banned = {"bob","hit"};
      mostCommonWord(paragraph,banned);

    }

    public static String mostCommonWord(String paragraph, String[] banned) {
        HashMap<String,Integer> bannedMap=new HashMap<>();
        for(int i=0;i<banned.length;i++){
            bannedMap.put(banned[i],1);
        }
        HashMap<String,Integer> map=new HashMap<>();
        String [] str=paragraph.split("[ ,]");
        String result=null;
        int MaxCount=0;
        for(int i=0;i<str.length;i++){
            String s=str[i];
            s=s.replaceAll("[!?',;.]","");
            s=s.toLowerCase();
            if(bannedMap.containsKey(s) || s.trim()==""){
                continue;
            }
            map.put(s,map.getOrDefault(s,0)+1);
            int count=map.get(s);
            if(count>MaxCount){
                MaxCount=count;
                result=s;
            }
        }

        return result;
    }
}
