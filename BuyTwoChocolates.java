public class BuyTwoChocolates {

    public static void main(String[] args) {
        int[] prices = {69, 91, 78, 19, 40, 13};
        int money = 94;
        int k=buyChoco(prices, money);

    }


    public static int buyChoco(int[] prices, int money) {
        int n=prices.length;
        int min=Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                int sum=0;
                sum=sum+prices[i]+prices[j];
                if(sum<min){
                    min=sum;
                }
            }
        }
        if(min<=money){
            return money-min;
        }

        return money;
        }
    }
