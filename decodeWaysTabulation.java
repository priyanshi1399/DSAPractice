import java.util.*;
public class decodeWaysTabulation {
    public static void main(String [] args){
        String s="10";
        int n=s.length();
        numDecodings(s,n);

    }
    public  static int numDecodings(String s, int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, 0);
        dp[0] = 1;
        dp[1] = s.charAt(0) == '0' ? 0 : 1;

        for (int i = 2; i <= n; i++) {
            if (s.charAt(i - 1) != '0') {
                dp[i] += dp[i - 1];
            }

            if (s.charAt(i - 2) == '1' || (s.charAt(i - 2) == '2' && s.charAt(i - 1) < '7')) {
                dp[i] += dp[i - 2];
            }
        }
        return dp[n];
    }
    /*public static int numDecodings(String s) {
        int n=s.length();
        int [] dp=new int[n+1];

        dp[n]=1;

        for(int i=n-1;i>=0;i--){
            if(s.charAt(i)=='0'){
                dp[i]=0;
            }
            else{
                dp[i]=dp[i+1];
                if(i<n-1){
                    if( s.charAt(i)=='1' || s.charAt(i)=='2' && s.charAt(i+1)<='6'){
                        dp[i]+=dp[i+1];
                    }
                }
            }
        }

        return dp[0];
    }*/



}
