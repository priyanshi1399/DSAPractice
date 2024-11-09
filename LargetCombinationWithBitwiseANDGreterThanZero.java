public class LargetCombinationWithBitwiseANDGreterThanZero {

    public static void main(String [] args){
        int [] candidates ={16,17,71,62,12,24,14};
        largestCombination(candidates);

    }
    public static int largestCombination(int[] candidates) {
        int result=Integer.MIN_VALUE;
        for(int i=0;i<24;i++){
            int count_ithpos=0;
            for(int j=0;j<candidates.length;j++){
                if((candidates[j] & (1<<i))!=0) {//doing left shift of 1 at ith position and then doing and with number
                    //tells if at the ith position bit is set bit or not.
                    count_ithpos++;
                }
            }
            result=Math.max(result,count_ithpos);

        }
        return result;
    }
}
