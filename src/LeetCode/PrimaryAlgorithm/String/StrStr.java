package LeetCode.PrimaryAlgorithm.String;

/**
 * 实现 strStr() 函数。
 * <p>
 * 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
 * <p>
 * needle 是空字符串时我们应当返回 0
 */
public class StrStr {
    class Solution {
        public int strStr(String haystack, String needle) {
            if ("".equals((needle))) {
                return 0;
            }
            String temp;
            int length = needle.length();
            for (int i = 0; i < haystack.length() - length + 1; i++) {
                temp = haystack.substring(i, i + length);
                if (temp.equals(needle)) {
                    return i;
                }
            }
            return -1;
        }
    }
}
