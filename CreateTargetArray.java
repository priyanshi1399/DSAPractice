public class CreateTargetArray {

    public static void main(String[] args) {
        int [] nums = {0,1,2,3,4};
        int [] index = {0,1,2,2,1};
        createTargetArray(nums,index);
    }

    public  static int shiftTargetArrayValues(int[] target, int value, int index) {
        int t = target.length;
        for (int i = t - 1; i > index; i--) {
            target[i] = target[i - 1];
        }
        target[index] = value;
        return target[index];
    }

    public static int[] createTargetArray(int[] nums, int[] index) {
        int n = nums.length;
        int[] target = new int[n];

        for (int i = 0; i < n; i++) {
            target[index[i]] = shiftTargetArrayValues(target, nums[i], index[i]);
        }
        return target;


    }
}