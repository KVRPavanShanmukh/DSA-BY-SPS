
public class FloodFill {
    public int[][] floodFill(int[][] a, int sr, int sc, int c) {
        int og = a[sr][sc];

        if (og != c) {
            dfs(a, sr, sc, og, c);
        }
        return a;

    }

    void dfs(int a[][], int r, int c, int og, int col) {
        int n = a.length;
        int m = a[0].length;

        if (r < 0 || r >= n || c < 0 || c >= m) {
            return;
        }

        if (a[r][c] != og) {
            return;
        }

        a[r][c] = col;

        dfs(a, r + 1, c, og, col);
        dfs(a, r - 1, c, og, col);
        dfs(a, r, c + 1, og, col);
        dfs(a, r, c - 1, og, col);
    }

    public static void main(String[] args) {
        //write yourself darlings!
    }
}
