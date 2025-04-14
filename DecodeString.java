import java.util.*;
public class DecodeString {

    public static void main(String [] args){
    String s="100[leetcode]";
    decodeString(s);
    }

    public static String stringCombine(String str,String num){
        int n=Integer.parseInt(num);
        String k="";
        for(int i=0;i<n;i++){
            k=k+str;
        }
        return k;
    }

    public static String decodeString(String s) {
        Stack<String> stck=new Stack<>();
        String str;
        String num;
        for(int i=0;i<s.length();i++){
            str="";
            num="";
            char ch=s.charAt(i);
            if(ch==']'){
                while((!stck.isEmpty()) && (!stck.peek().equals("["))){
                    str=stck.pop()+str;
                }
                stck.pop();
                while (!stck.isEmpty() && Character.isDigit(stck.peek().charAt(0))) {
                    num=stck.pop()+num;
                }
                String s1= stringCombine(str,num);
                stck.push(s1);
            }
            else{
                stck.push(String.valueOf(ch));
            }
        }
        String ans="";
        while(!stck.isEmpty()){
            ans=stck.pop()+ans;
        }
        return ans;
    }
}
