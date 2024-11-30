public class RotateArray {

    public static void main(String [] args){
    int [] nums={1,2,3,4,5,6,7};
    int k=3;
    rotate(nums,3);
    }

    public static void rotate(int[] nums, int k) {

        int n=nums.length;
        k=k%n;
        if(k==0){
            return;
        }
        reverse(0,n-1,nums);
        reverse(0,k-1,nums);
        reverse(k,n-1,nums);
    }

    public static  void reverse(int l,int h,int [] nums){
        while(l<h){
            int temp=nums[l];
            nums[l]=nums[h];
            nums[h]=temp;
            l++;
            h--;

        }
    }
}
