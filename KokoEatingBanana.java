import java.util.*;
public class KokoEatingBanana {

    public static void main(String [] args){
        int [] piles = {3,6,7,11};
        int h = 8;
        minEatingSpeed(piles,h);
    }

    private static boolean isPossibleToEat(int [] piles,int mid,int h){
        int n=piles.length;
        int sum=0;
        for(int pile:piles){
            sum+=pile/mid;
            if((pile%mid)!=0){
                sum++;
            }
        }
        return sum<=h;

    }
    public static int minEatingSpeed(int[] piles, int h) {
        int l=1;
        int r=Arrays.stream(piles).max().getAsInt();
        int result=-1;
        while(l<=r){
            int mid=l+(r-l)/2;
            if(isPossibleToEat(piles,mid,h)){
                result=mid;
                r=mid-1;
            }
            else{
                l=mid+1;
            }
        }
        System.out.println(isPossibleToEat(piles,2,h));
        return result;
    }
}
