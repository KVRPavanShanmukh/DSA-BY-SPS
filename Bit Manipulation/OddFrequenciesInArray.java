import java.util.*;

public class OddFrequenciesInArray {
    /* Function to get the single 
    numbers in the given array */
    public int[] singleNumber(int[] nums) {
        int n = nums.length;
        long XOR = 0;
        for(int i=0; i < n; i++) {
            XOR = XOR ^ nums[i];
        }
        /* Variable to get the rightmost set bit in overall XOR */
        int rightmost = (int)(XOR & (XOR - 1)) ^ (int)XOR;
        /* Variables to stores XOR of elements in bucket 1 and 2 */
        int XOR1 = 0, XOR2 = 0;
        for(int i=0; i < n; i++) {
            /* Divide the numbers among bucket 1 and 2 based on rightmost set bit */
            if((nums[i] & rightmost) != 0) {
                XOR1 = XOR1 ^ nums[i];
            }
            else {
                XOR2 = XOR2 ^ nums[i];
            }
        }
        // Return the result in sorted order
        if(XOR1 < XOR2) return new int[]{XOR1, XOR2};
        return new int[]{XOR2, XOR1};
    }
    public static void main(String[] args) {
        int[] nums = {1, 2, 1, 3, 5, 2};
        OddFrequenciesInArray sol = new OddFrequenciesInArray();
        int[] ans = sol.singleNumber(nums);
        System.out.println("The single numbers in given array are: " + ans[0] + " and " + ans[1]);
    }
}