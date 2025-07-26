import java.util.HashMap;
import java.util.Map;

public class Count_and_Say {


    public static void main(String[] args) {
        int n=4;
        countAndSay(n);

    }
    public static  String countAndAppend(String ans){
        StringBuilder str=new StringBuilder();
        for(int i=0;i<ans.length();i++){
            int count=1;
            String num=String.valueOf(ans.charAt(i));
            while(i+1<ans.length() && ans.charAt(i)==ans.charAt(i+1)){
                count++;
                i++;
            }
            str.append(String.valueOf(count));
            str.append(num);

        }

        return str.toString();

    }
    public static String solve(int n){
        if(n==1 || n==0){
            return "1";
        }

        String ans=solve(n-1);
        System.out.println(ans);
        return countAndAppend(ans);



    }
    public static String countAndSay(int n) {
        return solve(n);
    }


}
