
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class NumSubStrContaining3Chars {

    public int BruteForce3Chars(char a[]) {
        int n = a.length;
        int c = 0;

        for (int i = 0; i < n; i++) {
            Map<Character, Integer> hm = new HashMap<>();

            for (int j = i; j < n; j++) {
                hm.put(a[j], hm.getOrDefault(a[j], 0) + 1);

                if (hm.size() == 3) {
                    c++;
                }
            }
        }
        return c;
    }

    public int numberOfSubstrings(String s) {
        int[] freq = new int[3];
        int left = 0;
        int res = 0;

        for (int right = 0; right < s.length(); right++) {
            freq[s.charAt(right) - 'a']++;
            while (freq[0] > 0 && freq[1] > 0 && freq[2] > 0) {
                res += (s.length() - right);
                freq[s.charAt(left) - 'a']--;
                left++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter the String :");
        String a = s.next();

        NumSubStrContaining3Chars c3 = new NumSubStrContaining3Chars();
        
        System.out.println("Total Subarrays having all 3 characters are : ");
        System.out.println(c3.numberOfSubstrings(a));
    }
}
