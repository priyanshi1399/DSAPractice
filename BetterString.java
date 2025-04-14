import java.util.*;
public class BetterString {

        public static void main(String [] args){

            String str1="gfg";
            String str2="ggg";
            betterString(str1,str2);
        }

    public static void solve1(int index, List<String> res1, String str1,StringBuilder curr1,int n){
        if(index==n){
            if(!res1.contains(curr1.toString())){
                res1.add(curr1.toString());
                return;
            }
        }

        curr1.append(str1.charAt(index));
        solve1(index+1,res1,str1,curr1,n);
        curr1.deleteCharAt(curr1.length()-1);
        solve1(index+1,res1,str1,curr1,n);



    }

    public static void solve2(int index, List<String> res2, String str2,StringBuilder curr2,int n){
        if(index==n){
            if(!res2.contains(curr2.toString())){
                res2.add(curr2.toString());
                return;
            }
        }

        System.out.println(curr2.toString());
        curr2.append(str2.charAt(index));
        solve2(index+1,res2,str2,curr2,n);
        curr2.deleteCharAt(curr2.length()-1);
        solve2(index+1,res2,str2,curr2,n);

    }


    public static String betterString(String str1, String str2) {
        int n=str1.length();
        List<String> res1=new ArrayList<>();
        List<String> res2=new ArrayList<>();
        StringBuilder curr1=new StringBuilder();
        StringBuilder curr2=new StringBuilder();
        solve1(0,res1,str1,curr1,n);
        solve2(0,res2,str2,curr2,n);
        if(res1.size()>=res2.size()){
            return str1;
        }
        else{
            return str2;
        }

    }
}
