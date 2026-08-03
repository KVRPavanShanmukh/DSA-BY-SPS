
public class M_Coloring_Problem {

    public static boolean isSafeToColor(int node, int colored[], int n, boolean graph[][], int CurrColor) {
        for (int i = 0; i < n; i++) {
            /*
            True or False in Graph tells whether there is an edge b/w two nodes.
            Now, I am checking if the node exists,and is it colored with current color,
            also checking that they are not on same positions like 1,1 2,2 3,3 4,4. as they will
            be having same color all the time.
            If yes for all above conditions------->False-----> Cannot color 
             */
            if (i != node && graph[i][node] && colored[i] == CurrColor) {
                return false;
            }
        }
        return true;
    }

    public static boolean Coloring(int node, int colored[], int n, boolean graph[][], int totalCol) {
        if (node == n) {
            //I reached last vertex coloring all other vertices---->True
            return true;
        }

        for (int i = 1; i <= totalCol; i++) {
            //Check for safety!
            if (isSafeToColor(node, colored, n, graph, i)) {
                // color it
                colored[node] = i;

                //call for next node
                if (Coloring(node + 1, colored, n, graph, totalCol)) {
                    //found??? ---> Thoosey bayatakiii!
                    return true;
                }
                // uncolor it
                colored[node] = 0;
            }
        }
        return false;
    }

    public static boolean GraphColoring(boolean graph[][], int M, int N) {
        int colored[] = new int[N];
        if (Coloring(0, colored, N, graph, M)) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int N = 4;
        int m = 3;

        boolean[][] graph = new boolean[101][101];
        graph[0][1] = graph[1][0] = true;
        graph[1][2] = graph[2][1] = true;
        graph[2][3] = graph[3][2] = true;
        graph[3][0] = graph[0][3] = true;
        graph[0][2] = graph[2][0] = true;

        System.out.println("Is it possible to color? ");
        System.out.println(M_Coloring_Problem.GraphColoring(graph, m, N) ? "Yes" : "No");
    }
}
