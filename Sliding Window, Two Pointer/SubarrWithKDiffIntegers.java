
import java.util.HashSet;
import java.util.Scanner;

public class SubarrWithKDiffIntegers {

    public static int BF_SWKDE(int a[], int n, int k) {
        int ans = 0;
        for (int i = 0; i < n; i++) {
            HashSet<Integer> hs = new HashSet<>();
            for (int j = i; j < n; j++) {
                hs.add(a[j]);
                if (hs.size() == k) {
                    ans++;
                }
            }
        }
        return ans;
    }

    public static int Optimized_SWKDE(int a[], int n, int k) {
        int ans = 0;
        int l = 0;

        HashSet<Integer> hs = new HashSet<>();
        for (int r = 0; r < n; r++) {
            
        }

        return ans;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter the Array size :");
        int n = s.nextInt();
        System.out.println("Enter the #Diff ele :");
        int k = s.nextInt();
        int a[] = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = s.nextInt();
        }
        System.out.println("Total Subarrays having all K Diff Integers are : ");
        System.out.println(BF_SWKDE(a, n, k));
    }
}
