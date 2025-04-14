public class divideconcept {
    public static void main(String [] args){
        int a=2;
        int n=11;
        exp(a,n);
    }
    public static  int exp(int a, int n){
        int ans=1;
        while(n!=0){
            if(n%2==1){
                ans=(ans* a);
            }
            a=(a*a);
            n=n/2;
        }
        return ans;
    }
}
