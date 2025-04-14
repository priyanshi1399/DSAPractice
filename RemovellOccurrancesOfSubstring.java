public class RemovellOccurrancesOfSubstring {

    public  static void main(String[] args){
       String  s = "daabcbaabcbc";
       String part = "abc";
       removeOccurrences(s,part);

    }
    public static String removeOccurrences(String s, String part) {

        while(true){
            int index=-1;
            index=s.indexOf(part);
            if(index==-1){
                break;
            }

            s=s.substring(0,index)+s.substring(index+part.length() ,s.length());
        }
        return s;

    }
}
