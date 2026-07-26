
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TCS_Exam_Question {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter Vertices : ");
        int v = s.nextInt();
        System.out.println("Enter Edges : ");
        int e = s.nextInt();

        List<List<Integer>> als = new ArrayList<>();
        for (int i = 0; i <= v; i++) {
            als.add(new ArrayList<>());
        }

        for (int i = 0; i < e; i++) {
            int a = s.nextInt();
            int b = s.nextInt();

            als.get(a).add(b);
            als.get(b).add(a);
        }

        int maxDegree = -1;
        int vertex = -1;

        for (int i = 1; i <= v; i++) {
            int degree = als.get(i).size();

            if (degree > maxDegree) {
                maxDegree = degree;
                vertex = i;
            }
        }

        System.out.println("Vertex = " + vertex);
        System.out.println("Degree = " + maxDegree);
        s.close();
    }
}
