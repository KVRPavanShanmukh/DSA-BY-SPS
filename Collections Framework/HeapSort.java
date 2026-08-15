
import java.util.PriorityQueue;

public class HeapSort {

    public static void main(String[] args) {
        int[] nums = {10, 5, 20, 15, 30, 25};

        // Min-Heap PriorityQueue
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        // Add all elements to the priority queue (Min-Heap)
        for (int num : nums) {
            pq.add(num);
        }

        // Extract elements in sorted order
        while (!pq.isEmpty()) {
            System.out.print(pq.poll() + " ");  // 5 10 15 20 25 30
        }
    }
}
