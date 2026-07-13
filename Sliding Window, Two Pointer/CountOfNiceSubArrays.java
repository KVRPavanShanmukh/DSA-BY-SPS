
import java.util.Scanner;

public class CountOfNiceSubArrays {

    public int numberOfSubarrays(int[] nums, int k) {
        int n = nums.length;
        int gc = 0;
        for (int i = 0; i < n; i++) {
            int j = i;
            int c = 0;
            while (j < n) {
                if ((nums[j] & 1) == 1) {
                    c++;
                }
                if (c == k) {
                    gc++;
                }
                j++;
            }
        }
        return gc;
    }

    public int numberOfSubarraysOptimized(int[] nums, int k) {
        return numberOfSubarrays1(nums, k) - numberOfSubarrays1(nums, k - 1);
    }

    public int numberOfSubarrays1(int[] nums, int k) {
        int n = nums.length;
        int gc = 0;
        int oc = 0;
        int l = 0;
        int r = 0;
        while (r < n) {
            if ((nums[r] & 1) == 1) {
                oc++;
            }
            while (oc > k) {
                if ((nums[l] & 1) == 1) {
                    oc--;
                }
                l++;
            }
            gc += r - l + 1;
            r++;
        }
        return gc;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter size of Array :");
        int n = s.nextInt();
        System.out.println("Enter K value : ");
        int k = s.nextInt();
        System.out.println("Enter ele's of Array :");
        int a[] = new int[n];
        for (int idx = 0; idx < a.length; idx++) {
            a[idx] = s.nextInt();
        }
        CountOfNiceSubArrays cns = new CountOfNiceSubArrays();
        System.out.println("Total Nice Subarrays are : ");
        // System.out.println(cns.numberOfSubarrays(a, k));
        System.out.println(cns.numberOfSubarraysOptimized(a, k));
    }
}
