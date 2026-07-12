
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class LongestRepeatingCharacterReplacement {

    public int LRCP(char a[], int n, int k) {
        int maxLen = 0;
        int l = 0;

        Map<Character, Integer> hm = new HashMap<>();
        int maxFreq = 0;

        for (int r = 0; r < n; r++) {
            hm.put(a[r], hm.getOrDefault(a[r], 0) + 1);
            maxFreq = Math.max(maxFreq, hm.get(a[r]));
            while ((r - l + 1) - maxFreq > k) {
                hm.put(a[l], hm.get(a[l]) - 1);
                l++;
            }
            maxLen = Math.max(r - l + 1, maxLen);
        }
        return maxLen;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int k = s.nextInt();
        char a[] = s.next().toCharArray();
        LongestRepeatingCharacterReplacement lrcp = new LongestRepeatingCharacterReplacement();
        System.out.println(lrcp.LRCP(a, n, k));
    }
}
