
import java.util.Arrays;

/*
There are n children standing in a line.
Each child is assigned a rating value given in the integer array a.

You are giving candies to these children subjected to the following requirements:
Each child must have at least one candy.
Children with a higher rating get more candies than their neighbors.
Return the minimum number of candies you need to have to distribute the candies to the children.

Example 1:
Input: a = [1,0,2]
Output: 5
Explanation: You can allocate to the first, second and third child with 2, 1, 2 candies respectively.
 */
public class Candy {

    public static int candy(int[] a) {
        int n = a.length;

        // Array to store candies given to each child, initialized to 1
        int[] candies = new int[n];
        Arrays.fill(candies, 1);

        boolean updated = true;

        // Loop until no changes are made in one full pass
        while (updated) {
            updated = false;

            // Left to right pass
            for (int i = 1; i < n; i++) {
                if (a[i] > a[i - 1] && candies[i] <= candies[i - 1]) {
                    candies[i] = candies[i - 1] + 1;
                    updated = true;
                }
            }

            // Right to left pass
            for (int i = n - 2; i >= 0; i--) {
                if (a[i] > a[i + 1] && candies[i] <= candies[i + 1]) {
                    candies[i] = candies[i + 1] + 1;
                    updated = true;
                }
            }
        }

        // Sum up the total candies
        int total = 0;
        for (int candy : candies) {
            total += candy;
        }
        return total;
    }

    public static void main(String[] args) {
        int[] a = {1, 0, 5};
        System.out.println("Minimum candies required: " + candy(a));
    }
}
