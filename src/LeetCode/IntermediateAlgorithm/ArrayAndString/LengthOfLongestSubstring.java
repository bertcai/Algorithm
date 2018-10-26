package LeetCode.IntermediateAlgorithm.ArrayAndString;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 给定一个字符串，找出不含有重复字符的最长子串的长度。
 */
public class LengthOfLongestSubstring {
    // O(n^2)
    class Solution {
        public int lengthOfLongestSubstring(String s) {
            char[] temp = s.toCharArray();
            int max = 0;
            Set<Character> result = new HashSet<>();
            for (int i = 0; i < temp.length; i++) {
                for (int j = i; j < temp.length; j++) {
                    if (result.contains(temp[j])) {
                        max = Math.max(result.size(), max);
                        result.clear();
                        break;
                    } else {
                        result.add(temp[j]);
                    }
                }
            }
            return Math.max(result.size(), max);
        }
    }

    // O(n)
    class Solution2 {
        /**
         * 从前往后依次扫描字符串，初始化最长字符串长度是length_max = 0。不含重复元素的子串初始坐标是start = 0
         * 如果扫描到第j个字符 c, mark[c] = -1，那么继续往后扫描，并且更新mark[c] = j
         * 如果扫描到第j个字符c，mark[c] != -1,这个时候分两种情况，
         * 第一种情况是这个字符之前虽然出现过了，但是它在此次子串的起始位置之前，也就是说mark[c] < start。那么更新mark[c] = j
         * 第二种情况是mark[c] >= start，那么就代表c之前出现了，并且出现的位置在当前子串中。
         * 那么我们会得到一个新的长度length = j - mark[c], 比较length与length_max，如果length > length_max, 那么更新length_max = length。
         * 并且更新start = mark[c] + 1
         * 更新mark[c] = j
         *
         * @param s 输入字符串
         * @return 无重复最长子串长度
         */
        public int lengthOfLongestSubstring(String s) {
            if (s.length() <= 1) return s.length();
            int start = 0, length_max = 0, length = 0, j = 0;
            int[] mark = new int[256];
            Arrays.fill(mark, -1);
            for (; j < s.length(); j++) {
                if (mark[s.charAt(j)] != -1 && mark[s.charAt(j)] >= start) {
                    length_max = Math.max(length_max, j - start);
                    start = mark[s.charAt(j)] + 1;
                }
                mark[s.charAt(j)] = j;
            }
            length_max = Math.max(length_max, j - start);
            return length_max;
        }
    }
}
