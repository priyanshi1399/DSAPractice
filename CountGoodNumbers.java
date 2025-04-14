import java.util.*;
public class CountGoodNumbers {


    public static void main(String[] args) {
        int n = 2;
        System.out.println(countGoodNumbers(n));
    }



    public static int countGoodNumbers(long n) {
        int mod=(int)1e9+7;
        long first=(n%2==0?(n/2):((n/2)+1));
        long second=n/2;

        long multi1=Power(5,first)%mod;
        long multi2=Power(4,second)%mod;

        long ans=1;
        ans=(ans*multi1)%mod;
        ans=(second!=0)?(ans*multi2)%mod:ans;
        return (int)(ans%mod);

    }

    public static long Power(long x,long y){
        int mod=(int)1e9+7;
        long temp;
        if(y==0){
            return 1;
        }
        temp=Power(x,y/2);
        if(y%2==0){
            return (temp*temp)%mod;
        }
        else{
            return (x*temp*temp)%mod; //for odd length we multiply 5 one more time
        }
    }
   /* public static int countGoodNumbers(long n) {
        if (n == 1) {
            return 5;
        }
        if (n % 2 == 0) {
            return Power(20, n / 2);
        }
        return (int) Multi(Power(20, n / 2), 5);

    }

    public static int Power(int a, long n) {
        if (n == 0) {
            return 1;
        }
        long partialAnswer = Power(a, n / 2);
        partialAnswer = Multi(partialAnswer, partialAnswer);
        if (n % 2 == 0) {
            return (int) (partialAnswer);
        }
        return (int) Multi(partialAnswer, a);
    }

    public  static int Multi(long a, long b) {
        int mod = (int) (Math.pow(10, 9) + 7);
        return (int) (((a % mod) * (b % mod)) % mod);
    }*/
}
