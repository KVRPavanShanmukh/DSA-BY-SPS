
import java.util.*;

/*
Problem Statement: Given a grid of dimensions n x n. A rat is placed at coordinates (0, 0) and
wants to reach at coordinates (n-1, n-1). Find all possible paths that rat can take to travel
from (0, 0) to (n-1, n-1). The directions in which rat can move are 'U' (up) , 'D' (down) ,
'L' (left) , 'R' (right).
The value 0 in grid denotes that the cell is blocked and rat cannot use that cell for travelling,
whereas value 1 represents that rat can travel through the cell. If the cell (0, 0) has 0 value,
then mouse cannot move to any other cell.

Examples
Input: n = 4 , grid = [ [1, 0, 0, 0] , [1, 1, 0, 1], [1, 1, 0, 0], [0, 1, 1, 1] ]
Output: ["DDRDRR" , "DRDDRR"]
Explanation: The rat has two different path to reach (3, 3).
The first path is (0, 0) => (1, 0) => (2, 0) => (2, 1) => (3, 1) => (3, 2) => (3, 3).
The second path is (0,0) => (1,0) => (1,1) => (2,1) => (3,1) => (3,2) => (3,3).
 */
public class RatInAMaze {

    public static boolean isSafeToGo(int x, int y, int a[][], boolean visited[][]) {
        int n = a.length;
        return (x >= 0 && x < n && y >= 0 && y < n && visited[x][y] == false && a[x][y] == 1);
    }

    public static void RAT__BRO(int x, int y, int n, int a[][], boolean visited[][],
            String path, List<String> ls) {

        //edge cases where we need to stop traversal.
        if (x == n - 1 && y == n - 1) {
            ls.add(path);
            return;
        }

        visited[x][y] = true;   //mark as visited

        /*
        Now, we Recurse!!
        MOVING IN D,L,R,U is to maintain the LEXICOGRAPHICAL Order! Strings will be concatinated with Strings-->D,L,R,U
        
        Now, MOVING DOWN
         */
        if (isSafeToGo(x + 1, y, a, visited)) {
            RAT__BRO(x + 1, y, n, a, visited, path + "D", ls);
        }

        //MOVING LEFT
        if (isSafeToGo(x, y - 1, a, visited)) {
            RAT__BRO(x, y - 1, n, a, visited, path + "L", ls);
        }

        //MOVING RIGHT
        if (isSafeToGo(x, y + 1, a, visited)) {
            RAT__BRO(x, y + 1, n, a, visited, path + "R", ls);
        }

        //MOVING UP
        if (isSafeToGo(x - 1, y, a, visited)) {
            RAT__BRO(x - 1, y, n, a, visited, path + "U", ls);
        }

        //Unmark Visited as we will be Backtracking to previous nodes, to find another possible path. 
        visited[x][y] = false;
    }

    public static List<String> FindPath(int a[][], int n) {
        List<String> ls = new ArrayList<>();
        if (a[0][0] == 1) {
            RAT__BRO(0, 0, n, a, new boolean[n][n], "", ls);
        }
        return ls;
    }

    public static void main(String[] args) {
        int n = 4;
        int a[][] = {
            {1, 1, 0, 1},
            {1, 1, 0, 0},
            {1, 1, 0, 0},
            {0, 1, 1, 1}
        };

        System.out.println("The Paths in which the RAT bro can travel is / are : " + FindPath(a, n));
    }
}
