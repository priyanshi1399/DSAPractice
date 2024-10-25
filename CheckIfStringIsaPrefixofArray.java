public class CheckIfStringIsaPrefixofArray {

    public static boolean isPrefixString(String s, String[] words) {
        StringBuilder s1=new StringBuilder();
        for(int i=0;i<words.length;i++){
            s1.append(words[i]);

            if(s.equals(s1.toString())){
                return true;
            }
        }
        return false;
    }

    public static  void main(String [] args){
       // String s = "iloveleetcode";
        String s = "a";
        //String []words = {"i","love","leetcode","apples"};
        String []words = {"aa","aaaa","banana"};
       boolean b= isPrefixString(s,words);
        System.out.println(b);
    }
}
