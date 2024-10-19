import java.sql.SQLOutput;

public class PrimeNumber {
    public static int isPrime(int N){
        if(N==2){
            return 1;
        }
        if(N<2){
            return 0;
        }
        for(int i=2;i<=N/2;i++){
            System.out.println(N/2);
            if(N%i==0){
                return 0;
            }
        }
        return 1;
    }

    public static void main(String args[]){
        int n=1223;
        int k=isPrime(n);
        System.out.println(k);

    }

}
