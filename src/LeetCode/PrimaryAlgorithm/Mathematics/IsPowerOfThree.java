package LeetCode.PrimaryAlgorithm.Mathematics;

/**
 * 给定一个整数，写一个函数来判断它是否是 3 的幂次方。
 */
public class IsPowerOfThree {
    class Solution {
        public boolean isPowerOfThree(int n) {
            if (n == 0) {
                return false;
            }
            if (n == 1) {
                return true;
            }
            if (n < 0) {
                return false;
            }
            while (Math.abs(n) > 1) {
                if (n % 3 != 0) {
                    return false;
                }
                n = n / 3;
            }
            return true;
        }
    }

    // 可以求出int下最大的3的幂，然后用这个值对n取余必为0，以此来判断
    class Solution2 {
        public boolean isPowerOfThree(int n) {
            return n > 0 && (1162261467 % n) == 0;
        }
    }
}
