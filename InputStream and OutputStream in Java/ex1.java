
import java.io.*;
import java.util.StringTokenizer;

public class ex1 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter size of array : ");
        int size = Integer.parseInt(br.readLine());
        int a[] = new int[size];
        
        System.out.println("Enter ele's of array : ");
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < size; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println("Elements of the array : ");
        for (int i : a) {
            System.out.print(i + " ");
        }

    }
}
