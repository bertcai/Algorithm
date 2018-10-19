package LeetCode.PrimaryAlgorithm.Orthers;

/**
 * 两个整数之间的汉明距离指的是这两个数字对应二进制位不同的位置的数目。
 * <p>
 * 给出两个整数 x 和 y，计算它们之间的汉明距离。
 * <p>
 * 注意：
 * 0 ≤ x, y < 231.
 */
public class HammingDistance {
    class Solution {
        public int hammingDistance(int x, int y) {
            int n = x ^ y;
            int count = 0;
            while (n != 0) {
                count++;
                n = n & (n - 1);
            }
            return count;
        }
    }
}
