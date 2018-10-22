package LeetCode.PrimaryAlgorithm.Orthers;

/**
 * 颠倒给定的 32 位无符号整数的二进制位。
 */
public class ReverseBits {
    public class Solution {
        // you need treat n as an unsigned value
        // 把n的低位一次放入m的高位就行了，移位运算。
        public int reverseBits(int n) {
            int res = 0;
            for (int i = 0; i < 32; i++) {
                res <<= 1;
                res += n & 1;
                n >>= 1;
            }
            return res;
        }

        // 块变换
        public int reverseBits2(int n) {
            n = (n << 16) | (n >>> 16);
            n = ((n & 0x00ff00ff) << 8) | ((n & 0xff00ff00) >>> 8);
            n = ((n & 0x0f0f0f0f) << 4) | ((n & 0xf0f0f0f0) >>> 4);
            n = ((n & 0x33333333) << 2) | ((n & 0xcccccccc) >>> 2);
            n = ((n & 0x55555555) << 1) | ((n & 0xaaaaaaaa) >>> 1);
            return n;
        }
    }
}
