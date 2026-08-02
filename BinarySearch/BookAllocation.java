
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class BookAllocation {

    public static int CanWeGive(ArrayList<Integer> arr, int k) {
        int n = arr.size();
        int students = 1;
        long pages = 0;
        for (int i = 0; i < n; i++) {
            if (pages + arr.get(i) <= k) {
                pages += arr.get(i);
            } else {
                // add pages to next student
                students++;
                pages = arr.get(i);
            }
        }
        return students;
    }

    public static int findPages(ArrayList<Integer> arr, int n, int m) {
        if (m > n) {
            return -1;
        }

        int low = Collections.max(arr);
        int high = arr.stream().mapToInt(Integer::intValue).sum();
        while (low <= high) {
            int mid = (low + high) / 2;
            int students = CanWeGive(arr, mid);
            if (students > m) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }

    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(25, 46, 28, 49, 24));
        int n = 5;
        int m = 4;
        int ans = findPages(arr, n, m);
        System.out.println("The answer is: " + ans);
    }
}
