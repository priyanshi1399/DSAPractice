import java.util.Scanner;

public class BePositive {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        for(int i=0;i<t;i++){
            int n=sc.nextInt();
            int [] arr=new int[n];
            for(int j=0;j<n;j++){
                arr[j]=sc.nextInt();
            }
            int  ans=calculateMinimumOp(arr);
            System.out.println(ans);
        }
    }

    public static int calculateMinimumOp(int [] arr){


        int countOfMinus1=0;
        int countOfOne=0;
        int countZero=0;
        int res=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]==-1){
                countOfMinus1++;
            }
            else if(arr[i]==1){
                countOfOne++;
            }
            else{
                countZero++;
            }
        }
        if(countOfMinus1%2!=0){
            res+=2;
        }
        return countZero+res;
    }
}
