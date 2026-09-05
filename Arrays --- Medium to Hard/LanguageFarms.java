
import java.util.*;

/*
Farmer John wants to build schools in the United Cows of Farmer John (UCFJ).
There are n fields, and every k consecutive fields form one farm. Since n is a multiple of k, there are n/k farms.
Each farm must have at least one school.

Some fields belong to Farmer Nhoj. Farmer John has to pay extra if he builds a school on those fields.
You are given a binary string s of length n:
If s[i] = 1, field i belongs to Farmer Nhoj.
If s[i] = 0, field i does not belong to Farmer Nhoj.

For each farm, Farmer John needs to build at least one school. He wants to minimize the number of schools built on Farmer Nhoj's fields.

Input:
The first line contains t, the number of test cases.
For each test case:
The first line contains n and k.
The second line contains a binary string s of length n.

Constraints:
1 <= t <= 10^4
1 <= k <= n <= 20
n is divisible by k

Output:
For each test case, print the minimum number of schools that must be built on Farmer Nhoj's land.
 */
public class LanguageFarms {

    public static int MinFields(int a[], int n, int k) {
        int ans = 0;
        int i = 0;

        while (i < n) {
            boolean foundZero = false;
            for (int j = 0; j < k; j++) {
                if (a[i + j] == 0) {
                    foundZero = true;
                    break;
                }
            }
            if (!foundZero) {
                ans++;
            }
            i += k;
            // foundZero = false;
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        while (t-- > 0) {
            int n = s.nextInt();
            int a[] = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = s.nextInt();
            }
            int k = s.nextInt();
            System.out.println(MinFields(a, n, k));
        }
    }
}
