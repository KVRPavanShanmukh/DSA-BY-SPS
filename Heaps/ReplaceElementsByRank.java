
import java.util.*;

public class ReplaceElementsByRank {

    public static void BF_ReplaceEle(int a[], int n) {
        ArrayList<Integer> ls = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            HashSet<Integer> hs = new HashSet<>();
            for (int j = 0; j < n; j++) {
                if (a[i] > a[j]) {
                    hs.add(a[j]);
                }
            }
            ls.add(hs.size() + 1);
        }

        for (int i = 0; i < n; i++) {
            System.out.print(ls.get(i) + " ");
        }
    }

    public static void Optimized_Replace(int a[], int n) {
        int A[] = Arrays.copyOf(a, n);
        Arrays.sort(A);
        /*
            {20, 15, 26, 2, 98, 6}--->{2,6,15,20,26,98}
            A={2,6,15,20,26,98}
            Rank={1,2,3,4,5,6}
         */

        HashMap<Integer, Integer> hm = new HashMap<>();
        int rank = 1;
        for (int i = 0; i < n; i++) {
            hm.put(A[i], rank);
            rank++;
        }

        for (int i = 0; i < n; i++) {
            a[i] = hm.get(a[i]);
        }

        for (int i = 0; i < n; i++) {
            System.out.print(a[i] + " ");
        }
    }

    public static void main(String[] args) {
        int n = 6;
        int a[] = {20, 15, 26, 2, 98, 6};

        //BF
        System.out.println("Brute Force TC : O(N*N), SC : O(N)");
        BF_ReplaceEle(a, n);
        System.out.println();
        
        //Optimized
        System.out.println("Optimized TC : O(N+N+N+N), SC : O(N+N)");
        Optimized_Replace(a, n);
        System.out.println();
    }
}
