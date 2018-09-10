package LeetCode.PrimaryAlgorithm.Array;

/**
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 * 设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
 */

public class MaxProfit {
    class Solution {
        public int maxProfit(int[] prices) {
            int profit = 0;
            if (prices.length == 0) {
                return 0;
            }
            for (int i = 1; i < prices.length; i++) {
                int profitTemp = prices[i] - prices[i - 1];
                if (profitTemp >= 0) {
                    profit += profitTemp;
                }
            }
            return profit;
        }
    }
}