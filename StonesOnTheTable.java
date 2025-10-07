import java.util.Scanner;

public class StonesOnTheTable {

    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        String s=sc.next();

        int ans=solve(s);

        System.out.println(ans);

    }
    public static int solve(String str){
        int i=0;
        int count=0;
        int j=1;
        while(j<str.length()) {
            if (j < str.length() && str.charAt(i) == str.charAt(j)) {
                count++;
            }
            i++;
            j++;
        }
        return count;
    }
}
