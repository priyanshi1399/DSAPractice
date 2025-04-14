import java.util.*;
public class VerifyingAnAlienDictionary {

    public static void main(String [] args){
        String [] words={"hello","hellob", "helloa"};
        String order="hlabcdefgijkmnopqrstuvwxyz";
        isAlienSorted(words,order);

    }

    public static boolean isAlienSorted(String[] words, String order) {
        HashMap<Character,Integer> map=new HashMap<>();
        for(int i=0;i<order.length();i++){
            char ch=order.charAt(i);
            map.put(ch,i);
        }

        for(Map.Entry<Character,Integer> entry: map.entrySet()){
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }

        for(int i=0;i<words.length-1;i++){
            String s1=words[i];
            String s2=words[i+1];

            for(int j=0;j<(s2.length()>=s1.length()?s2.length():s1.length());j++){
                if(j<s1.length() && j<s2.length() && s1.charAt(j)!=s2.charAt(j)){
                    System.out.println("Character not equal");
                    int val1=map.get(s1.charAt(j));
                    int val2=map.get(s2.charAt(j));
                    System.out.println(val1);
                    System.out.println(val2);
                    if(val1<val2){
                        break;
                    }
                    else{
                        return false;
                    }
                }
                else if(j<s1.length() && j<s2.length() && s1.charAt(j)==s2.charAt(j)){
                    System.out.println("Character are equal");
                    int val1=map.get(s1.charAt(j));
                    int val2=map.get(s2.charAt(j));
                    System.out.println(val1);
                    System.out.println(val2);

                }
                else{
                    if(s1.length()<=s2.length()){
                        return true;
                    }
                    else{
                        return false;
                    }
                }
            }
        }
        return true;
    }

}
