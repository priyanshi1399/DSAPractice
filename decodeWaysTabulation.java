public class decodeWaysTabulation {
    public static void main(String [] args){
        String s="12";
        numDecodings(s);

    }

    public static int numDecodings(String s) {
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
    }
}
