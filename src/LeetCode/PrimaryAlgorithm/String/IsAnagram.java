package LeetCode.PrimaryAlgorithm.String;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的一个字母异位词
 * <p>
 * 你可以假设字符串只包含小写字母。
 * <p>
 * 如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？
 */
public class IsAnagram {
    class Solution {
        public boolean isAnagram(String s, String t) {
            if (s.length() != t.length()) {
                return false;
            }
            Map<Character, Integer> sMap = new HashMap<>();
            Map<Character, Integer> tMap = new HashMap<>();
            char[] sArray = s.toCharArray();
            char[] tArray = t.toCharArray();
            for (char c : sArray) {
                Integer value = sMap.get(c);
                sMap.put(c, (value == null ? 0 : value) + 1);
            }
            for (char c : tArray) {
                Integer value = tMap.get(c);
                tMap.put(c, (value == null ? 0 : value) + 1);
            }
            return sMap.equals(tMap);
        }
    }

    // 更优解
    class Solution2 {
        public boolean isAnagram(String s, String t) {
            if (s == null || t == null) {
                return false;
            }
            int[] countS = new int[256], countT = new int[256];
            for (char ch : s.toCharArray()) {
                countS[ch]++;
            }
            for (char ch : t.toCharArray()) {
                countT[ch]++;
            }
            for (int i = 0; i < 256; ++i) {
                if (countS[i] != countT[i]) {
                    return false;
                }
            }
            return true;
        }
    }
}
