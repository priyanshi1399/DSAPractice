import java.util.*;
public class SpiralMatrix_Optimal {

    public static void main(String[] args) {
    int [][] matrix={{1,2,3},{4,5,6},{7,8,9}};
    spiralOrder(matrix);

    }

    public static List<Integer> spiralOrder(int[][] matrix) {

        int top = 0;
        int bottom = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length - 1;

        Integer[] arr = new Integer[matrix.length * matrix[0].length];
        int index = 0;
        while (index != arr.length) {
            for (int i = left; i <= right && index != arr.length; i++) {
                arr[index] = matrix[top][i];
                index++;
            }
            top++;
            for (int i = top; i <= bottom && index != arr.length; i++) {
                  arr[index] = matrix[i][right];
                index++;
            }
            right--;
            for (int i = right ; i >= left && index != arr.length; i--) {
                arr[index] = matrix[bottom][i];
                index++;
            }
            bottom--;
            for (int i = bottom ; i >= top  && index != arr.length; i--) {
                arr[index] = matrix[i][left];
                index++;
            }
            left++;
        }
        return Arrays.asList(arr);
    }
}
