
import java.util.*;

/*
Sort K sorted array:
Problem Statement: Given an array arr[] and a number k . The array is sorted in a way that every
element is at max k distance away from it sorted position. It means if we completely sort the
array, then the index of the element can go from i - k to i + k where i is index in the
given array. Our task is to completely sort the array.
 */
public class SortKSortedArray {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        while (t-- > 0) {
            System.err.println("Enter n and k : ");
            int n = s.nextInt();
            int k = s.nextInt();

            System.err.println("Enter array elements : ");
            int a[] = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = s.nextInt();
            }

            PriorityQueue<Integer> pq = new PriorityQueue<>();
            ArrayList<Integer> ls = new ArrayList<>();
            for (int i = 0; i <= k && i < a.length; i++) {
                pq.add(a[i]);
            }

            for (int i = k + 1; i < a.length; i++) {
                ls.add(pq.poll());
                pq.add(a[i]);
            }

            while (!pq.isEmpty()) {
                ls.add(pq.poll());
            }

            System.out.println("Sorted array is: ");
            for (int i : ls) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
        s.close();
    }
}
