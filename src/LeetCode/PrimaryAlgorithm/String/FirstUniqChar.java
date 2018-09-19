package LeetCode.PrimaryAlgorithm.String;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
 * <p>
 * 可以假定该字符串只包含小写字母。
 */
public class FirstUniqChar {
    class Solution {
        public int firstUniqChar(String s) {
            Map<Character, Integer> charMap = new HashMap<>();
            char[] sArray = s.toCharArray();
            for (char c : sArray) {
                Integer value = charMap.get(c);
                charMap.put(c, (value == null ? 0 : value) + 1);
            }
            int size = charMap.size();
            int i = 0;
            for (char c : sArray) {
                if (charMap.get(c) == 1) {
                    return i;
                }
                i++;
            }
            return -1;
        }
    }

    // 更优的解法
    public class Solution2 {
        public int firstUniqChar(String s) {
            int min = Integer.MAX_VALUE;
            if (s == null) {
                return -1;
            }
            if (s.length() == 1) {
                return 0;
            }
            for (char c = 'a'; c <= 'z'; c++) {
                int ind = s.indexOf(c);
                if (ind >= 0 && ind == s.lastIndexOf(c) && ind <= min) {
                    min = ind;
                }
            }
            if (min != Integer.MAX_VALUE) {
                return min;
            }
            return -1;
        }
    }
}
