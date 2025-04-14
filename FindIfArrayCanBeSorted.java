public class FindIfArrayCanBeSorted {

    public static void main(String[] args) {
        int[] nums = {3, 16, 8, 4, 2};
        canSortArray(nums);
    }


    public static boolean canSortArray(int[] nums) {
        int n = nums.length;
        boolean flag = true;
        for (int i = 0; i < n; i++) {

            flag = false;
            for (int j = 0; j < n - i - 1; j++) {

                if (nums[j] < nums[j + 1]) {
                    continue;
                } else {
                    if (Integer.bitCount(nums[j]) == Integer.bitCount(nums[j + 1])) {
                        int temp = nums[j];
                        nums[j] = nums[j + 1];
                        nums[j + 1] = temp;
                        flag = true;
                    } else {
                        return false;
                    }
                }
            }
            if (flag == false) {//array is sorted
                break;
            }

        }

        return true;
    }
}
