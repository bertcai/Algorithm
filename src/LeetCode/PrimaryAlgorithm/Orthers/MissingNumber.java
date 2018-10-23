package LeetCode.PrimaryAlgorithm.Orthers;

/**
 * 给定一个包含 0, 1, 2, ..., n 中 n 个数的序列，找出 0 .. n 中没有出现在序列中的那个数。
 */
public class MissingNumber {
    class Solution {
        public int missingNumber(int[] nums) {
            int length = nums.length;
            boolean[] res = new boolean[length + 1];
            for (int num : nums) {
                res[num] = true;
            }
            for (int i = 0; i < res.length; i++) {
                if (!res[i]) {
                    return i;
                }
            }
            return 0;
        }
    }

    // 0 到 n 的和是固定的，只要求出和这个固定和，减去给定序列和，差值即为所需值
    class Solution2 {
        public int missingNumber(int[] nums) {
            int N = nums.length;
            int allSum = N * (N + 1) / 2;
            int sum = 0;
            for (int i = 0; i < nums.length; i++) {
                sum += nums[i];
            }
            return allSum - sum;
        }
    }
}
