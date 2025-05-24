import  java.util.*;
public class SumofLargestPrimeSubstring {
    public static void main(String [] args){
    String s = "12234";
    sumOfLargestPrimes(s);
    }

    public static  boolean isPrime(long num){
        if(num==1){
            return false;
        }
        if(num==2){
            return true;
        }
        if(num%2==0){
            return false;
        }
        for(long i=3;i<=num*num;i+=2){
            if(num%i==0){
                return false;
            }
        }
        return true;
    }
    public static  long sumOfLargestPrimes(String s) {
        HashSet<Long> primes=new HashSet<>();
        int n=s.length();
        for(int i=0;i<n;i++){
            for(int j=i+1;j<=n;j++){
                String str=s.substring(i,j);
                long num=Long.parseLong(str);
                System.out.println(num);

                if(isPrime(num)){
                    primes.add(num);
                }
            }
        }


        List<Long> sortedList=new ArrayList<>(primes);
        // for(int i=0;i<sortedList.size();i++){
        //     System.out.print(sortedList.get(i) + " ");
        // }
        Collections.sort(sortedList,Collections.reverseOrder());
        long sum = 0;
        int count = 0;
        for (long prime : sortedList) {
            if (count == 3) break;
            sum += prime;
            count++;
        }

        return sum;

    }
}
