import java.util.*;
public class DecodeWays {

    public static void main(String [] args){
        String s="226";
        numDecodings(s);
    }

    public static int numDecodings(String s) {
        int [] dp=new int[101];
        Arrays.fill(dp,-1);
        int n=s.length();
        return solve(0,s,n,dp);
    }

    public static int solve(int i,String s,int n,int [] dp){

        if(dp[i]!=-1){
            return dp[i];
        }
        if(i==n){
            return dp[i]=1;
        }

        if(s.charAt(i)=='0'){
            return dp[i]=0;
        }

        int result=solve(i+1,s,n,dp);
        if(i+1<n){
            if(s.charAt(i)=='1' || (s.charAt(i)=='2' && s.charAt(i+1)<='6')){
                result+=solve(i+2,s,n,dp);
            }
        }
        return dp[i]=result;
    }
}
