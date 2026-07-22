
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class TopogicalSortUsingDFS {

    public void DFS(int node, ArrayList<ArrayList<Integer>> als, boolean[] visited, Stack<Integer> st) {
        visited[node] = true;

        System.out.println(node + " ");
        for (int i : als.get(node)) {
            if (!visited[i]) {
                DFS(i, als, visited, st);
            }
        }
        st.push(node);

    }

    public List<Integer> TopologicalSort(int V, ArrayList<ArrayList<Integer>> als) {
        boolean visited[] = new boolean[V];
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                DFS(i, als, visited, st);
            }
        }
        List<Integer> ls = new ArrayList<>();
        while (!st.empty()) {
            ls.add(st.pop());
        }
        return ls;
    }

    public static void main(String[] args) {
        int V = 6;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        adj.get(5).add(0);
        adj.get(5).add(2);
        adj.get(4).add(0);
        adj.get(4).add(1);
        adj.get(2).add(3);
        adj.get(3).add(1);

        TopogicalSortUsingDFS tsdfs = new TopogicalSortUsingDFS();

        List<Integer> res = tsdfs.TopologicalSort(V, adj);

        System.out.print("Topological Sort: ");
        for (int node : res) {
            System.out.print(node + " ");
        }
    }
}

/*
Analogy:
Think of it like this!
Imagine a school.

Principal:
Go to every classroom.
If students haven't been checked,
Call a teacher.

Teacher:
Go inside classroom.
Check every student.
If student has friends,
Check them too.

So,
Principal=TopologicalSort()
Teacher= DFS()

 */
