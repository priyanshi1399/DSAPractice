import java.util.*;
public class SubstringOfsizethreewiththreedistinctcharacter {

    public static void main(String[] args) {
        String s = "aababcabc";
        countGoodSubstrings(s);
    }

    public static int countGoodSubstrings(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int count = 0;
        int subCount = 0;

        for (int i = 0; i < s.length(); i++) {
            count++;
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);


            if ((count == 3) && (map.size() == 3)) {
                for (Map.Entry<Character, Integer> ent : map.entrySet()) {
                    System.out.println(ent.getKey() + ":" + ent.getValue());
                }
                subCount++;
                count = 0;
                map.clear();
                i=i-3+1;
            } else if ((count == 3) && (map.size() < 3)) {
                count = 0;
                map.clear();
                i=i-3+1;
            }

        }
        return subCount;

    }
}
