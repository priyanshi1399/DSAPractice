public class MergeSortedArray {


    public static void main(String [] args) {

        int [] nums1 = {1,2,3,0,0,0};
        int m = 3;
        int []nums2 = {2,5,6};
        int n = 3;
        merge(nums1,m,nums2,m);
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int [] arr=new int[n+m];
        int left=0;
        int right=0;
        int index=0;
        while(left<m && right<n){
            if (nums1[left]<=nums2[right]){
                arr[index]=nums1[left];
                left++;
                index++;
            }
            else{
                arr[index]=nums2[right];
                right++;
                index++;
            }
        }
        while(left<m){
            arr[index]=nums1[left];
            index++;
            left++;
        }
        while(right<n){
            arr[index]=nums2[right];
            index++;
            right++;
        }

        for(int i=0;i<m+n;i++){
            nums1[i]=arr[i];
        }

    }
}


