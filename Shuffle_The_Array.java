public class Shuffle_The_Array {

    public static void main(String[] args) {
        int[] nums = {2, 5, 1, 3, 4, 7};
        int n = 3;
        shuffle(nums, n);

    }


    public static int[] shuffle(int[] nums, int n) {
        int len = nums.length;
        //store the pair
        //3*1024+(nums[0])
        // i=3-->nums[3]=nums[3]*1024+2
        //i==4->nums[4]=nums[4]*1024+5
       //i=5 nums[5]=nums[5]*1024+5  //7169
        for (int i = n; i < len; i++) {
            nums[i] = ((nums[i] * 1024) | (nums[i - n])); //3-3  //4-3//5-3
        }
        //to get those pairs
        int index = 0;
        for (int i = n; i < len; i++, index += 2) {
            nums[index] = nums[i] % 1024;
            nums[index + 1] = nums[i] / 1024;
        }

        return nums;

    }
}
