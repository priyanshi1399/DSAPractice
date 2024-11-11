public class LongestMountainArray {

    public static void main(String [] args){
        int [] arr = {2,1,4,7,3,2,5};
        int k=longestMountain(arr);

    }

    public static int longestMountain(int[] arr) {

       int maxlength=0;
        int n=arr.length;
        int left=0;
        int right=0;
        int index=1;
        while(index<n){
            while(index<n && arr[index-1]==arr[index]){
                ++index;
            }
            left=0;
            while(index<n && arr[index-1]<arr[index]){
                ++left;
                ++index;
            }
            right=0;
            while(index<n && arr[index-1]>arr[index]){
                ++right;
                ++index;
            }
            if(left>0 && right>0){
                maxlength=Math.max(maxlength,left+right+1);
            }
        }
        return maxlength;
}

}
