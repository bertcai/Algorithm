package LeetCode.IntermediateAlgorithm.ArrayAndString;

/**
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为1000。
 */
public class LongestPalindrome {
    // 暴力求解
    class Solution {
        public String longestPalindrome(String s) {
            if (s.length() == 0) {
                return "";
            }
            for (int size = s.length(); size > 0; size--) {
                for (int low = 0, high = low + size - 1; high < s.length(); low++, high++) {
                    if (shrinkCheckPalindrome(s, low, high)) {
                        return s.substring(low, high + 1);
                    }
                }
            }
            return s.substring(0, 1);
        }

        boolean shrinkCheckPalindrome(String s, int low, int high) {
            while (low <= high) {
                if (s.charAt(low) == s.charAt(high)) {
                    low++;
                    high--;
                } else {
                    return false;
                }
            }
            return true;
        }
    }

    // 中心扩展法
    class Solution2 {
        private int max = 0;
        private String res = "";

        public String longestPalindrome(String s) {
            if (s.length() <= 1) {
                return s;
            }
            for (int i = 0; i < s.length() - 1; i++) {
                checkPalindromeExpand(s, i, i);
                checkPalindromeExpand(s, i, i + 1);
            }
            return res;
        }

        void checkPalindromeExpand(String s, int low, int high) {
            while (low >= 0 && high < s.length()) {
                if (s.charAt(low) == s.charAt(high)) {
                    if (high - low + 1 > max) {
                        max = high - low + 1;
                        res = s.substring(low, high + 1);
                    }
                    low--;
                    high++;
                } else {
                    return;
                }
            }
        }
    }

    // 动态规划
    class Solution3 {
        private int[] p;
        private String res;
        private char[] t;

        public String longestPalindrome(String s) {
            res = s;
            preprocess();
            p = new int[t.length];
            int mid = 0, right = 0;
            for (int i = 1; i < t.length - 1; i++) {
                int mirror = 2 * mid - i;
                if (right > i) {
                    p[i] = Math.min(right - i, p[mirror]);
                }
                while (t[i + (1 + p[i])] == t[i - (1 + p[i])]) {
                    p[i]++;
                }
                if (i + p[i] > right) {
                    mid = i;
                    right = i + p[i];
                }
            }
            int length = 0;
            int center = 0;
            for (int i = 1; i < p.length - 1; i++) {
                if (p[i] > length) {
                    length = p[i];
                    center = i;
                }
            }
            return res.substring((center - 1 - length) / 2, (center - 1 + length) / 2);
        }

        void preprocess() {
            t = new char[res.length() * 2 + 3];
            t[0] = '$';
            t[res.length() * 2 + 2] = '@';
            for (int i = 0; i < res.length(); i++) {
                t[2 * i + 1] = '#';
                t[2 * i + 2] = res.charAt(i);
            }
            t[res.length() * 2 + 1] = '#';

        }
    }
}
