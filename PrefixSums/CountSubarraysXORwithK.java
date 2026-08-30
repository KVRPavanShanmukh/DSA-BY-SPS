
import java.util.HashMap;

public class CountSubarraysXORwithK {

    public static int CountSubarraysK_BF(int a[], int n, int k) {
        int c = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if ((a[i] ^ a[j]) == k) {
                    c++;
                }
            }
        }
        return c;
    }

    /*
The brute force approach checks all possible subarrays and computes their XOR, but this quickly
becomes inefficient for large arrays because it requires checking every pair of indices. Instead,
we can make use of prefix XORs. A prefix XOR at index i represents the XOR of all elements from
the start up to i.
Using this, the XOR of any subarray can be derived by taking the XOR of two prefix XOR values.
     */
    public static int CountSubarrays_K(int a[], int n, int k) {
        int c = 0;
        HashMap<Integer, Integer> hm = new HashMap<>();
        hm.put(0, 1);
        int cnt = 0;
        int prefix = 0;

        for (int i : a) {
            prefix ^= i;    //xor with ele
            int target = prefix ^ k;    //target value to find.

            if (hm.containsKey(target)) {
                c += hm.get(target);
            }

            hm.put(prefix, hm.getOrDefault(prefix, 0) + 1);
        }
        return c;
    }

    public static void main(String[] args) {
        int n = 5;
        int a[] = {4, 2, 2, 6, 4};
        int k = 6;
        System.out.println(CountSubarrays_K(a, n, k));
    }
}
