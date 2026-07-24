
// import java.util.Scanner;

// public class Strong_Weak_Connections {

//     public static String Connections(int[][] graph, int V) {
//         int c = 0;
//         int oc = 0;
//         for (int i = 0; i < V; i++) {
//             for (int j = 0; j < V; j++) {
//                 if (graph[i][j] == 1) {
//                     oc++;
//                 }
//                 c++;
//             }
//         }
//         if (oc == c) {
//             return "Strongly Connected";
//         }
//         if (oc < c / 2) {
//             return "Unilaterally Connected";
//         }
//         return "Weakly Connected";
//     }

//     public static void main(String[] args) {
//         Scanner s = new Scanner(System.in);
//         int v = s.nextInt();
//         int e = s.nextInt();

//         int graph[][] = new int[v][v];
//         for (int i = 0; i < e; i++) {
//             int U = s.nextInt(i);
//             int V = s.nextInt(i);

//             graph[U][V] = 1;
//         }

//     }
// }
