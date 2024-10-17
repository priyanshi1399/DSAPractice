public class ClimbingStairs {
//it follows a pattern 1,2,3,5,8,13

    public static int climbingStairs(int n) {
        int[] dp = new int[n + 1];

        if(n==1 || n==2){
            return n;
        }
        dp[0]=1;
        dp[1]=2;

        for(int i=2;i<=n;i++){
            dp[i]=dp[i-1]+dp[i-2];
        }
        return dp[n];

    }

   public static void main(String[] args){
        int n=5;
        int k=climbingStairs(n);
       System.out.println(k);
   }
}
