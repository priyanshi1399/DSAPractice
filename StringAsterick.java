public class StringAsterick {

    public static void main(String [] args){
        String s = "leetcode";
        String p = "ee*e";
        hasMatch(s,p);
    }

    public static String substringConversion(String str,String p){
        String newStr="";
        for(int i=0;i<p.length();i++){
            if(p.charAt(i)=='*'){
                newStr=p.substring(0,i)+str+p.substring(i+1,p.length());
                break;
            }
        }
        return newStr;

    }

    public  static boolean hasMatch(String s, String p) {
        for(int i=0;i<s.length()-1;i++){
            for(int j=i;j<s.length();j++){
                String str=  substringConversion(s.substring(i,j),p);
                System.out.println(str);
                if(s.contains(str)){
                    return true;
                }
            }
        }
        return false;
    }
}
