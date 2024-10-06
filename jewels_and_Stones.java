public class jewels_and_Stones {


    private static int numJewelsInStones(String jewels, String stones) {
        int count=0;
        for(int i=0;i<stones.length();i++) {
            if (jewels.contains(String.valueOf(stones.charAt(i)))) {
                count++; //contains takes String Argument so we have to take valueOf
            }
        }
        return count;

    }


    public static void main(String[] args){
        String jewels = "aA";
        String stones = "aAAbbbb";
        int k=numJewelsInStones(jewels,stones);
        System.out.println(k);

        //o/p=3
    }


}
