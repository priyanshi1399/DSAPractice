public class AddDigit {
    public static void main(String[] args) {
        int num = 199;
        AddDigit ad=new AddDigit();
        ad.addDigit(num);

    }
    public  int addDigit(int num) {
        while (calculateCount(num) > 1) {
            num = calculateSum(num);
        }
        return num;
    }

        public  int calculateSum(int num) {
            int sum=0;
            while(num!=0){
                int digit=num%10;
                sum=sum+digit;
                num=num/10;
            }
            return sum;
        }

        public  int calculateCount(int num){
        int count=0;
        while(num!=0){
            num=num/10;
            count++;
        }
        return count;
        }

    }

