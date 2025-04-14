public class ReverseInteger {
    public static void main(String [] args){
    int x=1534236469;
            reverse(x);
    }

    public static int reverse(int x) {
        int rev=0; //2147483647
                   //1056389759
        while(x!=0){
            int rem=x%10;
            if(rev>(Integer.MAX_VALUE/10) || rev<(Integer.MIN_VALUE/10)){
                return 0;
            }
            rev=rev*10+rem;
            x=x/10;
        }
        return rev;
    }
}
