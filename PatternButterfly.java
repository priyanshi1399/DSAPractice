public class PatternButterfly {

    public static  void main(String [] args){
        int n=6;
        printpattern(n);
    }

    public static void printpattern(int n){

        for(int i=1;i<=n;i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }

            for (int j = 1; j <= 2 * (n - i); j++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        for(int i=n;i>=1;i--) {
            for (int j = 1; j<=i; j++) {
                System.out.print("*");
            }
//2*(n-i) 6-6 2*(6-5) //2*1=2
            for (int j =1; j<=2*(n-i) ; j++) {
                System.out.print(" ");
            }
            for (int j = 1; j<=i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }


    }

}
