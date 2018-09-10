package LeetCode.PrimaryAlgorithm.Array;

import java.util.Arrays;

/**
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 */

public class SingleNumber {
    class Solution {
        public int singleNumber(int[] nums) {
            Arrays.sort(nums);
            for (int i = 0; i < nums.length; i += 2) {
                if (i == nums.length - 1) {
                    return nums[i];
                }
                if (nums[i] != nums[i + 1]) {
                    return nums[i];
                }
            }
            return 0;
        }
    }

    // 方法二 使用位运算
    class Solution2 {
        public int singleNumber(int[] nums) {
            if (nums == null || nums.length == 0) {
                return -1;
            }
            int res = 0;
            for (int t : nums) {
                res ^= t;
            }
            return res;
        }
    }
}