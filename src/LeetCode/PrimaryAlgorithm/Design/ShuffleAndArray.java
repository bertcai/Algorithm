package LeetCode.PrimaryAlgorithm.Design;

import java.util.Random;

/**
 * 打乱一个没有重复元素的数组。
 */
public class ShuffleAndArray {
    class Solution {
        private int[] ori;
        private int[] cur;

        public Solution(int[] nums) {
            this.ori = nums;
        }

        /**
         * Resets the array to its original configuration and return it.
         */
        public int[] reset() {
            return ori;
        }

        /**
         * Returns a random shuffling of the array.
         */
        public int[] shuffle() {
            int len = ori.length;
            cur = new int[len];
            for (int i = 0; i < len; i++) {
                cur[i] = ori[i];
            }
            int pos, temp;
            Random ran = new Random();
            for (int i = len - 1; i >= 0; i--) {
                pos = ran.nextInt(i + 1);
                temp = cur[pos];
                cur[pos] = cur[i];
                cur[i] = temp;
            }
            return cur;
        }
    }
}
