package slidingWindow;

/*
You are given an array prices where prices[i] is the price of a given stock on the ith day.
You want to maximize your profit by choosing a single day to buy one stock
and choosing a different day in the future to sell that stock.
Return the maximum profit you can achieve from this transaction.
If you cannot achieve any profit, return 0.
https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
 */
public class MaxProfit {

    public static void main(String[] args) {
        maxProfit(new int[]{1,2,1,1,5,9,2});
    }

    //This implementation has a time complexity of O(n) and a space complexity of O(1)
    public static void maxProfit(int[] prices) {
        int left = 0;
        int right = 1;
        int maxProfit = 0;
        while (right < prices.length) {
            if (prices[left] < prices[right]) {
                maxProfit = Math.max(maxProfit, prices[right] - prices[left]);
                right++;
            } else {
                left = right;
                right++;
            }
        }
        System.out.println(maxProfit);
    }


}

