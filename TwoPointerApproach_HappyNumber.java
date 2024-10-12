public class TwoPointerApproach_HappyNumber {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        int n=19;
        boolean b=isHappy(n);
        System.out.println("The number is happy "+b);
    }

    private static int sumOfSquares(int n){
        int sum=0;
        while(n>0){
            int rem=n%10;
            sum=sum+rem*rem;
            n=n/10;
        }
        return sum;
    }


    private static boolean isHappy(int n){
        int slow=sumOfSquares(n);
        int fast=sumOfSquares(sumOfSquares(n));

        while(slow!=fast && fast!=1){
            slow=sumOfSquares(slow);
            fast=sumOfSquares(sumOfSquares(slow));
        }
        return fast==1;
    }
}
