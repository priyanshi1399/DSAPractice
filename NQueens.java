import java.util.*;
import java.util.ArrayList;
public class NQueens {
    public static void main(String[] args) {
        int n = 4;
        solveNQueens(n);

    }

    private static boolean isSafe(int row, int col, List<String> board, int n) {
        //upward safe

        for (int i = row; i >= 0; i--) {
            if (board.get(i).charAt(col) == 'Q') {
                return false;
            }
        }

        //for left diagonal check
        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board.get(i).charAt(j) == 'Q') {
                return false;
            }
        }

        //for right diagonal
        for (int i = row, j = col; i >= 0 && j < n; i--, j++) {
            if (board.get(i).charAt(j) == 'Q') {
                return false;
            }
        }
        return true;

    }

    private static void solve(int row, List<String> board, List<List<String>> result, int n) {
        if (row == n) {
            result.add(board);
            return;
        }

        for (int col = 0; col < n; col++) {
            if (isSafe(row, col, board, n)) {
                StringBuilder newRow = new StringBuilder(board.get(row)); //first row getting
                newRow.setCharAt(col, 'Q');
                board.set(row, newRow.toString());
                solve(row + 1, board, result, n);
                newRow.setCharAt(col, '.');
                board.set(row, newRow.toString());
            }
        }
    }

    public static List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        //making a board
        List<String> board = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringBuilder curr = new StringBuilder();
            for (int j = 0; j < n; j++) {
                curr.append('.');
            }
            board.add(curr.toString()); //[. . . .][. . . .][. . . .][. . . .]
        }

        solve(0, board, result,n);
        return result;

    }
}
