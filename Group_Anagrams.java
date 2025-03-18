import java.util.*;
public class Group_Anagrams {

    public static void main(String [] args){
        String [] strs = {"eat","tea","tan","ate","nat","bat"};
        groupAnagrams(strs);
    }

    private static String sortTheString(String str){
        char [] ch=str.toCharArray();
        Arrays.sort(ch);
        return new String(ch);
    }
    public static List<List<String>> groupAnagrams(String[] strs) {
        int n=strs.length;
        List<List<String>> result=new ArrayList<>();
        HashMap<String,List<String>> map=new HashMap<>();
        for(int i=0;i<n;i++){
            String sortedString=sortTheString(strs[i]);
            map.putIfAbsent(sortedString,new ArrayList<>());
            map.get(sortedString).add(strs[i]);
        }
        return result;
    }
}
