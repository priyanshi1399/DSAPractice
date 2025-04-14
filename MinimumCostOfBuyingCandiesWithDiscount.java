import java.util.Arrays;

public class MinimumCostOfBuyingCandiesWithDiscount {

    public static void main(String [] args) {
    int [] cost={6,5,7,9,2,2};
    int k=minimumCost(cost);

    }
        public static int minimumCost(int[] cost) {
            Arrays.sort(cost);
            int sum = 0;
            for (int i = cost.length - 1; i >= 0; i--) {
                if (i % 3 != 0) {
                    sum += cost[i];
                }
            }
            return sum;
        }
}
