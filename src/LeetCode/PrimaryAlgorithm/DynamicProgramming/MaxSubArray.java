package LeetCode.PrimaryAlgorithm.DynamicProgramming;

/**
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 */
public class MaxSubArray {
    class Solution {
        public int maxSubArray(int[] nums) {
            int max = Integer.MIN_VALUE;
            int sum = 0;
            if (nums[0] < 0) {
                sum = nums[0];
            }
            boolean flag = false;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] > 0) {
                    flag = true;
                }
                if (flag) {
                    sum = Math.max(0, sum);
                    sum += nums[i];
                }
                if (!flag) {
                    sum = Math.max(sum, nums[i]);
                }
                max = Math.max(sum, max);
            }
            return max;
        }
    }

    class Solution2 {
        public int maxSubArray(int[] nums) {
            int sum = nums[0];
            int tmp = sum;
            for (int i = 1; i < nums.length; i++) {
                tmp = tmp < 0 ? nums[i] : tmp + nums[i];
                sum = Math.max(sum, tmp);
            }
            return sum;
        }
    }
}
