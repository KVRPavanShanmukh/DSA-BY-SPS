
import java.util.Scanner;

public class Read_Graph_As_AdjMat {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter number of Nodes in Graph : ");
        int n = s.nextInt();
        System.out.println("Enter number of Edges in Graph : ");
        int m = s.nextInt();

        //Adjacency Matrix:
        int a[][] = new int[n + 1][n + 1];
        for (int i = 0; i < m; i++) {
            int u = s.nextInt();
            int v = s.nextInt();

            a[u][v] = 1;
            a[v][u] = 1;
        }
        s.close();
    }
}
