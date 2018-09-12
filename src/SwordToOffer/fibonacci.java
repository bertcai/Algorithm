package SwordToOffer;

public class fibonacci {
    class Solution {
        public int Fibonacci(int n) {
            if (n == 0) {
                return 0;
            }
            if (n == 1) {
                return 1;
            }
            return Fibonacci(n - 1) + Fibonacci(n - 2);
        }
    }

// 非递归算法

    class Solution2 {
        public int Fibonacci(int n) {
            if (n == 0) {
                return 0;
            }
            if (n == 1) {
                return 1;
            }
            int fibMin = 0;
            int fibMax = 1;
            int fibN = 0;
            for (int i = 2; i <= n; i++) {
                fibN = fibMin + fibMax;
                fibMin = fibMax;
                fibMax = fibN;
            }
            return fibN;
        }
    }
}