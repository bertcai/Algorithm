package LeetCode.PrimaryAlgorithm.String;

/**
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * <p>
 * 如果不存在公共前缀，返回空字符串 ""。
 */

public class LongestCommonPrefix {
    class Solution {
        public String longestCommonPrefix(String[] strs) {
            if (strs.length == 0) {
                return "";
            }
            int count = 0;
            for (int i = 0; i < strs[0].length(); i++) {
                char temp = strs[0].charAt(count);
                boolean flag = true;
                for (int j = 1; j < strs.length; j++) {
                    if (count >= strs[j].length()) {
                        flag = false;
                        break;
                    }
                    if (temp != strs[j].charAt(count)) {
                        flag = false;
                        break;
                    }
                }
                if (!flag) {
                    break;
                }
                count++;
            }
            return strs[0].substring(0, count);
        }
    }

    // 解法二
    class Solution2 {
        public String longestCommonPrefix(String[] strs) {
            if (strs.length == 0) {
                return "";
            }
            String prefix = strs[0];
            for (int i = 1; i < strs.length; i++) {
                while (strs[i].indexOf(prefix) != 0) {
                    prefix = prefix.substring(0, prefix.length() - 1);
                    if (prefix.length() == 0) {
                        return "";
                    }
                }
            }
            return prefix;
        }
    }
}
