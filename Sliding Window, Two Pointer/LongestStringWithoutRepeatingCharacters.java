
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class LongestStringWithoutRepeatingCharacters {

    public int lengthOfLongestSubstring(String s) {
        int n = s.length();

        int l = 0;
        int h = 0;
        int maxLen = 0;

        Map<Character, Integer> hm = new HashMap<>();

        while (h < n) {
            char ch = s.charAt(h);
            while (hm.containsKey(ch)) {
                char leftChar = s.charAt(l);

                hm.remove(leftChar);
                l++;
            }
            hm.put(ch, 1);
            maxLen = Math.max(maxLen, h - l + 1);
            h++;
        }
        return maxLen;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter the String :");
        String str = s.next();
        LongestStringWithoutRepeatingCharacters lswk = new LongestStringWithoutRepeatingCharacters();
        System.out.println("Total Nice Subarrays are : ");
        System.out.println(lswk.lengthOfLongestSubstring(str));
    }
}
