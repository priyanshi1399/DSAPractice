import java.util.*;
public class Spiral_Matrix {

    public static void main(String[] args) {
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        spiralOrder(matrix);
    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        int col = -1;
        int row = 0;
        int direction = 1;
        List<Integer> arr = new ArrayList<>();
        while (rows > 0 && cols > 0) {
            for (int i = 0; i < cols; i++) {
                col += direction;
                arr.add(matrix[row][col]);
            }
            rows--;
            for (int i = 0; i < rows; i++) {
                row = row + direction;
                arr.add(matrix[row][col]);
            }
            cols--;
            direction *= -1;
        }
        return arr;

    }
}
