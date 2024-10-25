public class MergeSortedArray2 {
    public static void swapIfGreater(int[] nums1, int[] nums2, int idx1, int idx2) {
        if (nums1[idx1] > nums2[idx2]) {
            int temp = nums1[idx1];
            nums1[idx1] = nums2[idx2];
            nums2[idx2] = temp;
        }
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int len = n + m;
        int gap = (len / 2) + (len % 2);

        while (gap > 0) {
            int left = 0;
            int right = left + gap;

            while (right < len) {
                //when left in arr1 and right in arr2
                if (left < m && right >= m) {
                    swapIfGreater(nums1, nums2, left, right - m); //because right in on the other side of nums2 so there will be index 5,6 like that
                    //to make it 1, 2 like this we need to subtract right-length of first array
                }
               else if (left >= m) {
                    swapIfGreater(nums2, nums2, left - m, right - m);
                } else {
                    swapIfGreater(nums1, nums1, left, right);
                }
                left++;
                right++;
            }
            if (gap == 1) {
                break;
            }
            gap = (gap / 2) + (gap % 2);
        }

        //copy the elements of nums2 to nums1
        for (int i = m; i < m + n; i++) {
            nums1[m] = nums2[i - m]; //m=3 then 3-3 nums1[3]=0,....like this
        }
    }

    public static void main(String [] args){
        int [] nums1 = {1,2,3,0,0,0};
        int m = 3;
        int []nums2 = {2,5,6};
        int n = 3;
        merge(nums1,m,nums2,m);
    }
}
