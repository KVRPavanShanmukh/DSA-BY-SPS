import java.util.Scanner;

public class DeleteFromMaxHeap {

    static int size;

    public static int deleteMax(int a[]) {

        // Heap empty
        if (size == 0) {
            return -1;
        }

        // Store maximum element
        int eleToDelete = a[0];
        // Move last element to root
        a[0] = a[size - 1];
        // Reduce heap size
        size--;

        // Heapify Down
        int i = 0;
        while (true) {
            int leftChild = 2 * i + 1;
            int rightChild = 2 * i + 2;

            // Assume current node is largest
            int largestIndex = i;

            if (leftChild < size && a[leftChild] > a[largestIndex]) {
                largestIndex = leftChild;
            }
            if (rightChild < size && a[rightChild] > a[largestIndex]) {
                largestIndex = rightChild;
            }

            // Heap property satisfied
            if (largestIndex == i) {
                break;
            }

            int temp = a[i];
            a[i] = a[largestIndex];
            a[largestIndex] = temp;

            // Move downward
            i = largestIndex;
        }

        return eleToDelete;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int a[] = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = s.nextInt();
        }
        // Current heap size
        size = n;

        // Delete maximum
        int deleted = deleteMax(a);
        System.out.println("Deleted Element = " + deleted);
        System.out.print("Heap After Deletion: ");
        for (int i = 0; i < size; i++) {
            System.out.print(a[i] + " ");
        }
        s.close();
    }
}