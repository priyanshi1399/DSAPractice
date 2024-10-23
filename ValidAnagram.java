public class ValidAnagram {
    public static void main(String [] args){
        //String s="anagram";
        //String t="nagaram";
        String s="dog";
        String t="cat";
        boolean k=anagramStrings(s,t);
        System.out.println(k);
    }

    public static boolean anagramStrings(String s, String t) {
        if(s.length()!=t.length()){
            return false;
        }
        int j=0;
        int count=0;
        int i=0;
        StringBuilder str=new StringBuilder();
        str.append(s);
        while(i<str.length() && j<t.length()){
            if(str.charAt(i)==t.charAt(j)){
                if(str.charAt(i)!='#'){
                    str.setCharAt(i,'#');
                    count++;
                    j++;
                    i=0;
                }
                else if(str.charAt(i)=='#'){
                    i++;
                    continue;
                }
            }
            else{
                i++;
            }
        }
        if(count==s.length()){
            return true;
        }
        else{
            return false;
        }
    }
}
