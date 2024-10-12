import java.sql.SQLOutput;

public class CountNumberofPrime {

    public static void main(String[] args){
        int n=10;
        int p=countPrime(n);
        System.out.println(p);
    }

    private static int countPrime(int n){
        boolean [] isPrime=new boolean[n];
        int count=0;
        for(int i=0;i<n;i++){
            isPrime[i]=true;
        }
        if(n<=2){
            return 0;
        }
        for(int i=2;i<n;i++){
            if(isPrime[i]){
                count++;
                for(int j=i*2;j<n;j=j+i){
                    isPrime[j]=false;
                }
            }
        }
        return count;
    }
}
