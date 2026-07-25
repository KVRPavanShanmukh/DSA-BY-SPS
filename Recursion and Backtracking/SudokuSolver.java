
import java.util.Scanner;

public class SudokuSolver {

    public boolean isValidPlace(char[][] board, int row, int col, char c) {
        for (int i = 0; i < 9; i++) {
            if (board[i][col] == c) {
                return false;
            }
        }

        for (int i = 0; i < 9; i++) {
            if (board[row][i] == c) {
                return false;
            }
        }

        int MatRowSt = 3 * (row / 3);
        int MatColSt = 3 * (col / 3);

        //matrix is 3x3 so 9 times in total...
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[MatRowSt + i][MatColSt + j] == c) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean Sudokuu(char[][] board) {
        //WKT it is an 9x9 matrix
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    for (char c = '1'; c <= '9'; c++) {
                        if (isValidPlace(board, i, j, c)) {
                            board[i][j] = c;
                            if (Sudokuu(board)) {
                                return true;
                            }
                            board[i][j] = '.';
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int n = 9;
        char[][] board = {
            {'9', '5', '7', '.', '1', '3', '.', '8', '4'},
            {'4', '8', '3', '.', '5', '7', '1', '.', '6'},
            {'.', '1', '2', '.', '4', '9', '5', '3', '7'},
            {'1', '7', '.', '3', '.', '4', '9', '.', '2'},
            {'5', '.', '4', '9', '7', '.', '3', '6', '.'},
            {'3', '.', '9', '5', '.', '8', '7', '.', '1'},
            {'8', '4', '5', '7', '9', '.', '6', '1', '3'},
            {'.', '9', '1', '.', '3', '6', '.', '7', '5'},
            {'7', '.', '6', '1', '8', '5', '4', '.', '9'}
        };

        SudokuSolver ss = new SudokuSolver();
        System.out.println("The Solved Sudoku Problem(one out of may ways) : " + ss.Sudokuu(board));
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        s.close();
    }
}
