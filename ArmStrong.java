public class ArmStrong {


    public static int calculateCount(int n) {
        int count = (int) Math.log10(n) + 1;
        return count;
    }


    public static boolean armStrongCheck(int n) {
        int cnt = calculateCount(n);
        int dupliNum = n;
        int sum = 0;
        while (dupliNum > 0) {
            int digit = dupliNum % 10;
            sum = sum + (int)Math.pow(digit, cnt);
            dupliNum = dupliNum / 10;
        }
        if(sum==n){
            return true;
        }
        else{
            return false;
        }
    }
        public static void main (String[]args){
            int n = 153;
            boolean b=armStrongCheck(n);
            System.out.println(b);

        }

}
