import java.util.*;
public class FairCandySwap {

    public static void main(String [] args){
        int [] aliceSizes = {1,1};
        int [] bobSizes = {2,2};
        fairCandySwap(aliceSizes,bobSizes);

    }

    private static int search(int [] arr,int target){
        int start=0;
        int end=arr.length-1;

        while(start<=end){
            int mid=start+(end-start)/2;
            if(arr[mid]==target){
                return mid;
            }
            else if(arr[mid]<target){
                start=mid+1;
            }
            else{
                end=mid-1;
            }
        }
        return -1;

    }
    public static  int[] fairCandySwap(int[] a, int[] b) {
        int sum1=0;
        int sum2=0;
        for(int j=0;j<a.length;j++){
            sum1= sum1+a[j];
        }
        for(int j=0;j<b.length;j++){
            sum2= sum2+b[j];
        }

        int diff=(sum1-sum2)/2;

        Arrays.sort(a);

        for(int i : b){
            if(search(a,i+diff)!=-1){
                return new int[]{i+diff,i};
            }
        }
        return null;
    }


}
