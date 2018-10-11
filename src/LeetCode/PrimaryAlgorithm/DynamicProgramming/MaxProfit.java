package LeetCode.PrimaryAlgorithm.DynamicProgramming;

/**
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 * <p>
 * 如果你最多只允许完成一笔交易（即买入和卖出一支股票），设计一个算法来计算你所能获取的最大利润。
 * <p>
 * 注意你不能在买入股票前卖出股票。
 *
 *
 * 换一个角度来思考这个问题，最大利润实际上就是每天的交易价格，减去上一天的价格所构成的这个数组的最大子数组。
 */
public class MaxProfit {
    class Solution {
        public int maxProfit(int[] prices) {
            int max = 0;
            int sum = 0;
            for (int i = 0; i < prices.length - 1; i++) {
                sum += prices[i + 1] - prices[i];
                max = Math.max(max, sum);
                if (sum < 0) {
                    sum = 0;
                }
            }
            return max;
        }
    }
}
