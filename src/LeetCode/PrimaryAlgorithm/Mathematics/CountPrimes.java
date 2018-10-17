package LeetCode.PrimaryAlgorithm.Mathematics;

/**
 * 统计所有小于非负整数 n 的质数的数量。
 */
public class CountPrimes {
    class Solution {
        public int countPrimes(int n) {
            int count = 0;
            if (n < 2) {
                return 0;
            }
            for (int i = 2; i < n; i++) {
                if (isPrime(i)) {
                    count++;
                }
            }
            return count;
        }

        private boolean isPrime(int n) {
            if (n == 2 || n == 3) {
                return true;
            }
            for (int i = 2; i <= n / 2; i++) {
                if (n % i == 0) {
                    return false;
                }
            }
            return true;
        }
    }

    /**
     * 这道题给定一个非负数n，让我们求小于n的质数的个数，题目中给了充足的提示，解题方法就在第二个提示埃拉托斯特尼筛法
     * Sieve of Eratosthenes中，这个算法的过程如下图所示，我们从2开始遍历到根号n，先找到第一个质数2，然后将其所有的倍
     * 数全部标记出来，然后到下一个质数3，标记其所有倍数，一次类推，直到根号n，此时数组中未被标记的数字就是质数。我们
     * 需要一个n-1长度的bool型数组来记录每个数字是否被标记，长度为n-1的原因是题目说是小于n的质数个数，并不包括n。 然后
     * 我们用两个for循环来实现埃拉托斯特尼筛法
     */
    class Solution2 {
        public int countPrimes(int n) {
            if (n < 2) {
                return 0;
            }
            boolean[] notPrime = new boolean[n - 1];
            for (int i = 0; i < n-1; i++) {
                notPrime[i] = true;
            }
            notPrime[0] = false;
            int count = 0;
            int limit = (int) Math.sqrt(n);
            for (int i = 2; i <= limit; i++) {
                if (notPrime[i - 1]) {
                    for (int j = i * i; j < n; j += i) {
                        notPrime[j - 1] = false;
                    }
                }
            }
            for (int j = 0; j < n - 1; j++) {
                if (notPrime[j]) {
                    count++;
                }
            }
            return count;
        }
    }
}
