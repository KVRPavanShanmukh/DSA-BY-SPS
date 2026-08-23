/*
You are given an array prices where prices[i] is the price of a given stock on the ith day.
You want to maximize your profit by choosing a single day to buy one stock and choosing a different
day in the future to sell that stock.
Return the maximum profit you can achieve from this transaction.
If you cannot achieve any profit, return 0.

Example 1:
Input: prices = [7,1,5,3,6,4]
Output: 5
Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.
 */

public class BuySellStocks {

    public int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1) {
            return 0;
        }

        int maxProfit = 0;
        int minPrice = prices[0];
        for (int i = 1; i < prices.length; i++) {
            //find and update the min price possible before array's exhaustion.
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            } else {
                //if no minimum price is found
                int ans = prices[i] - minPrice; //get max diff.
                maxProfit = Math.max(maxProfit, ans);
            }
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        int a[] = {7, 1, 5, 3, 6, 4};
        BuySellStocks bss = new BuySellStocks();
        System.out.println(bss.maxProfit(a));
    }
}
