import java.util.*;
public class GroupAnagrams {

    public static void main(String [] args){
    String [] strs={"eat","tea","tan","ate","nat","bat"};
    groupAnagrams(strs);

    }

    public static  String checkSortedString(String s){
        char [] ch=s.toCharArray();
        Arrays.sort(ch);
        String newStr=new String(ch);
        return newStr;

    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans=new ArrayList<>();
        HashMap<String,Integer> map=new HashMap<>();
        List<String> lst=new ArrayList<>();
        if(strs.length==1){
            lst.add(strs[0]);
            ans.add(lst);
            return ans;
        }

        for(int i=0;i<strs.length;i++){
            if((!strs[i].equals("-1")) && (!map.containsKey(checkSortedString(strs[i])))){
                map.put(checkSortedString(strs[i]),i);

            }
            else{
                continue;
            }

            for(Map.Entry<String,Integer> entry:map.entrySet()){
                System.out.println(entry.getKey() +":"+ entry.getValue());
            }

            List<String> res=new ArrayList<>();
            for(int j=i;j<strs.length;j++){
                String newStr=checkSortedString(strs[j]);
                if(map.containsKey(newStr)){
                    res.add(strs[j]);
                    strs[j]="-1";

                }
            }
            ans.add(res);
        }
        for(int i=0;i<strs.length;i++){
            if(!strs[i].equals("-1")){
                lst.add(strs[i]);
                ans.add(lst);
            }
        }
        return ans;
    }
}
