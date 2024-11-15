public class MergeSortedArraywithPointerApproach {

    public static  void main(String [] args){
        int [] nums1={4,5,6,0,0,0};
        int [] nums2={1,2,3};
        int m=3;
        int n=3;
        int i=m-1;
        int j=n-1;
        int k=m+n-1;
        while(i>=0 && j>=0){
            if(nums1[i]<nums2[j]){
                nums1[k]=nums2[j];
                k--;
                j--;
            }
            else{
                nums1[k]=nums1[i];
                k--;
                i--;
            }
        }
//        while(j>=0){
//            nums1[k]=nums2[j];
//            k--;
//            j--;
//        }
    }
}
