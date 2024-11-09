public class MinMaxGame {

    public static void main(String [] args){
        int [] nums={999,939,892,175,114,464,850,107};
        minMaxGame(nums);
    }

    public static int [] minMaxModification(int [] nums){
        int n=nums.length;
        int [] nums2=new int[n/2];
        int k=0;
        int i=0;
        int j=1;
        while(k<nums2.length ){
            nums2[k++]=Math.min(nums[2*i],nums[(2*i)+1]);
            nums2[k++]=Math.max(nums[2*j],nums[(2*j)+1]);
            i=i+2;
            j=j+2;
        }
        return nums2;
    }

    public static int minMaxGame(int[] nums) {
        int n=nums.length;
        if(n==1){
            return nums[0];
        }
        else if(n==2){
            return (Math.min(nums[0],nums[1]));
        }

            while(nums.length!=2){
                nums=minMaxModification(nums);
            }

        return Math.min(nums[0],nums[1]);
    }
}
