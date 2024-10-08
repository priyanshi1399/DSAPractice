public class addDigits {


    int num1=0;
    public  int countNumberOfDigit(int num){
        int sum=0;
        int count=0;
        while(num!=0){
            int rem=num%10;
            sum=sum+rem;
            num=num/10;
            count++;
        }
        num1=sum;
        return count;
    }


    public int addSumDigits(int num) {
        while(countNumberOfDigit(num)>1){
            num=num1; //again assigning value for sum
        }
        return num1;

    }


   public static void main(String args[]){
       int num=38;
       addDigits ad=new addDigits();
       ad.addSumDigits(num);
      // System.out.println(k);

    }
}
