package LeetCode.PrimaryAlgorithm.Array;

/**
 * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数
 */

public class Rotate {
    /**
     * 重点解释第一种解法，该解法的空间复杂度为O(1)
     * 这种解法利用(i+k)%n等于新i的思路，每次调换一个元素，
     * 后一个元素的调换基于上一个的位置，可能不是很好理解，
     * 可以通过假定k为1，数组为[1, 2, 3, 4, 5]在纸上运行
     * 一下，就明白了。
     * 运行序列
     * 1, 2, 3, 4, 5
     * 1, 1, 3, 4, 5 cur = 2
     * 1, 1, 2, 4, 5 cur = 3
     * 1, 1, 2, 3, 4 cur = 4
     * 5, 1, 2, 3, 4 cur = 5
     */
    class Solution {
        public void rotate(int[] nums, int k) {
            if (nums.length == 0 || (k %= nums.length) == 0) {
                return;
            }
            int length = nums.length;
            int start = 0;
            int i = 0;
            int cur = nums[i];
            int cnt = 0;
            while (cnt++ < length) {
                i = (i + k) % length;
                int t = nums[i];
                nums[i] = cur;
                if (i == start) {
                    start++;
                    i++;
                    cur = nums[i];
                } else {
                    cur = t;
                }
            }
        }
    }

    class Solution2 {
        public int[] rotate(int[] nums, int k) {
            k = k % nums.length;

            int[] result = new int[nums.length];

            for (int i = 0; i < nums.length; i++) {
                result[(i + k) % nums.length] = nums[i];
            }

            return result;
        }
    }

    class Solution3 {
        public int[] rotate1(int[] nums, int k) {
            reverse(nums, 0, nums.length - 1 - k);
            reverse(nums, nums.length - k, nums.length - 1);
            reverse(nums, 0, nums.length - 1);
            return nums;
        }

        private void reverse(int[] nums, int start, int end) {
            while (start < end) {
                int tmp = nums[start];
                nums[start++] = nums[end];
                nums[end--] = tmp;
            }
        }
    }
}