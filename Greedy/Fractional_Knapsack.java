
import java.util.*;

public class Fractional_Knapsack {

    public static void main(String[] args) {
        int n = 7;
        int m = 15;
        // int object[] = {1, 2, 3, 4, 5, 6, 7}; commented as this is common input!
        int profit[] = {10, 5, 15, 7, 6, 18, 3};
        int weight[] = {2, 3, 5, 7, 1, 4, 1};

        int profitPerWeight[] = new int[n];
        for (int i = 0; i < n; i++) {
            profitPerWeight[i] = (profit[i] / weight[i]);
        }

        Arrays.sort(profitPerWeight);
        int ans = 0;
        for (int i = n - 1; i >= 0; i--) {
            if(weight[i] <= m){
                ans++;
                m -= profitPerWeight[i];
            }
            if (m <= 0) {
                break;
            }
        }

    }
}
