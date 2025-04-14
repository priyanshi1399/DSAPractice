public class AlternateDigitSum {

private static int alternateDigitSum(int n){
    String s1=String.valueOf(n);
    s1.toString();
   StringBuilder s=new StringBuilder(s1);
    s.reverse();
    int n1=Integer.parseInt(s.toString());
    int sum=0;
    int count=0;
    while(n1!=0){
        int digit=n1%10;
        count++;
        if(count%2!=0){
            sum=sum+digit;
        }
        else{
            sum=sum-digit;
        }
        n1=n1/10;
    }
    return sum;
}


    public static void main(String[] args){
        int n=521;
        int res=alternateDigitSum(n);
        System.out.println(res);
    }
}
