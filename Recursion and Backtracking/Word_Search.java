
/*
Given an m x n grid of characters board and a string word, return true if word exists in the grid.
The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are
horizontally or vertically neighboring. The same letter cell may not be used more than once.
Example 1:
Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
Output: true
 */
import java.util.Scanner;

public class Word_Search {

    public static boolean DFS_Modified(char a[][], String word,
            int i, int j, int k) {

        int n = a.length;
        int m = a[0].length;

        // Boundary + character check
        if (i < 0 || i >= n || j < 0 || j >= m
                || a[i][j] != word.charAt(k)) {
            return false;
        }

        // Entire word matched
        if (k == word.length() - 1) {
            return true;
        }

        // Mark current cell as visited
        char temporary = a[i][j];
        a[i][j] = '$';

        // Search next character in all 4 directions
        boolean found
                = DFS_Modified(a, word, i + 1, j, k + 1)
                || DFS_Modified(a, word, i - 1, j, k + 1)
                || DFS_Modified(a, word, i, j + 1, k + 1)
                || DFS_Modified(a, word, i, j - 1, k + 1);

        // Backtrack
        a[i][j] = temporary;

        return found;
    }

    public static boolean Check_If_Exists(char a[][], String word) {
        int n = a.length;
        int m = a[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (DFS_Modified(a, word, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        try (Scanner s = new Scanner(System.in)) {
            System.out.println("Enter m and n : ");
            int n = s.nextInt();
            int m = s.nextInt();

            System.out.println("Enter Array ele's : ");
            char a[][] = new char[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    a[i][j] = s.next().charAt(0);
                }
            }
            System.out.println("Enter String : ");
            String str = s.next();
            Word_Search ws = new Word_Search();
            System.out.println(ws.Check_If_Exists(a, str));
        } catch (Exception e) {
            System.err.println("No i/p");
        }
    }
}
