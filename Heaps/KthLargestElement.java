
import java.util.PriorityQueue;
import java.util.Scanner;

public class KthLargestElement {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        while (t-- > 0) {
            System.err.println("Enter n and k : ");
            int n = s.nextInt();
            int k = s.nextInt();
            int a[] = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = s.nextInt();
            }
            PriorityQueue<Integer> pq = new PriorityQueue<>((o, p) -> p - o);
            for(int i : a){
                pq.add(i);
            }
            
            for(int i=0;i<=k;i++){
                pq.poll();
            }
            System.out.println("Kth Largest Element is: " + pq.peek());
        }
        s.close();
    }
}
