
import java.util.Scanner;

public class BinarySubarraysWithSum {

    public int numSubarraysWithSum(int[] nums, int n, int goal) {
        int c = 0;
        for (int i = 0; i < nums.length; i++) {
            int j = i;
            int sum = 0;
            while (j < n) {
                sum += nums[j];
                if (sum == goal) {
                    c++;
                }
                j++;
            }
        }
        return c;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter size of Array : ");
        int n = s.nextInt();
        System.out.println("Enter Goal Sum : ");
        int k = s.nextInt();
        
        int a[] = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = s.nextInt();
        }
        
        BinarySubarraysWithSum bss = new BinarySubarraysWithSum();
        System.out.println("Total Subarrays are : ");
        System.out.println(bss.numSubarraysWithSum(a, n, k));
    }
}
