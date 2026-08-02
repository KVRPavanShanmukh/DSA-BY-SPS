import java.util.Arrays;

public class AggressiveCows {

    public static boolean CanWePlaceACow(int a[], int k, int d) {
        int cowsPlaced = 1;
        int lastPlacedCowPosition = a[0];

        for (int i = 1; i < a.length; i++) {
            if (a[i] - lastPlacedCowPosition >= d) {
                cowsPlaced++;
                lastPlacedCowPosition = a[i];

                if (cowsPlaced >= k) {
                    return true;
                }
            }
        }
        return false;
    }

    public static int AggressiveCows(int a[], int k) {
        Arrays.sort(a);

        int maxDist = a[a.length - 1] - a[0];
        int ans = 0;

        for (int i = 1; i <= maxDist; i++) {
            if (CanWePlaceACow(a, k, i)) {
                ans = i;
            }
        }
        return ans;
    }

    public static int AggressiveCowsBS(int a[], int k) {
        Arrays.sort(a);

        int l = 1;
        int h = a.length - 1;
        int ans = 0;

        while (l <= h) {
            int mid = (l + h) / 2;
            if (CanWePlaceACow(a, k, mid)) {
                l = mid + 1;
                ans = mid;
            } else {
                h = mid - 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int k = 4;
        int a[] = {0, 3, 4, 7, 10, 9};

        System.err.println("BruteForce Approach: " + AggressiveCows(a, k) + " \nTime Complexity : O(N)*(A[MAX]-A[MIN]) + O(n logn)");
        System.err.println("BS Approach : " + AggressiveCowsBS(a, k) + " \nTime Complexity : O(log n) + O(n logn)");
    }
}
