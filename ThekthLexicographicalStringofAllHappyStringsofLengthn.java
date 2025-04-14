import java.util.*;
public class ThekthLexicographicalStringofAllHappyStringsofLengthn {

    public static void main(String [] args){

        int n = 3;
        int k = 9;
        getHappyString(n,k);
    }
    public  static void solve(StringBuilder curr, String  [] res, int n,int k,int [] count){

        if(curr.length()==n){
            count[0]++;
            if(count[0]==k){
                res[0]=curr.toString();
            }
            return;
        }


        for(char ch='a';ch<='c';ch++){

            if(curr.length()>=1 && curr.charAt(curr.length()-1)==ch){
                continue;
            }
            curr.append(ch);
            solve(curr,res,n,k,count);
            curr.deleteCharAt(curr.length()-1);
        }

    }


    public static String getHappyString(int n, int k) {
        String [] res={""};
        StringBuilder curr=new StringBuilder();
        int [] count={0};
        solve(curr,res,n,k,count);

        return res[0];
    }
}
