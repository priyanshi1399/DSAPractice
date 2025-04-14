public class StringToInteger {

    public static void main(String [] args){
        String s="1337c0d3";
        myAtoi(s);
    }
    public static int myAtoi(String s) {
        int sum=0;
        int i=0;
        int sign=1;

        while(i<s.length()){
            while(s.charAt(i)==' '){
                i++;
            }

            if(s.charAt(i)=='+'){
                sign=1;
                i++;
            }
            else if(s.charAt(i)=='-'){
                sign=-1;
                i++;
            }

            while(i<s.length() && Integer.parseInt(String.valueOf(s.charAt(i)))>=0 && Integer.parseInt(String.valueOf(s.charAt(i)))<=9 ){
                sum=10*sum+Integer.parseInt(String.valueOf(s.charAt(i)));
                i++;
            }

            if((i==s.length()) || (!Character.isDigit(s.charAt(i)))){
                break;
            }
        }
        if(sign==1){
            return sum;
        }
        else if(sign==-1){
            return sum*-1;
        }
        else if(sum==Integer.MIN_VALUE){
            return Integer.MIN_VALUE;
        }
        else if(sum==Integer.MAX_VALUE){
            return Integer.MAX_VALUE;
        }
        return 1;

    }
}
