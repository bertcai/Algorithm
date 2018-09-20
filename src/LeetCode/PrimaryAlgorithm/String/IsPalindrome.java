package LeetCode.PrimaryAlgorithm.String;

/**
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 * <p>
 * 说明：本题中，我们将空字符串定义为有效的回文串
 */
public class IsPalindrome {
    static class Solution {
        public boolean isPalindrome(String s) {
            if (s == null) {
                return true;
            }
            String st = s.toLowerCase();
            int start = 0;
            int end = st.length() - 1;
            while (start < end && start < st.length() - 1) {
                char pre = st.charAt(start);
                char aft = st.charAt(end);
                if (!isValid(pre)) {
                    start++;
                    continue;
                }
                if (!isValid(aft)) {
                    end--;
                    continue;
                }
                if (pre != aft) {
                    return false;
                }
                start++;
                end--;
            }
            return true;
        }

        public boolean isValid(char c) {
            if ((c >= 'a' && c <= 'z') || (c >= '0' && c <= '9')) {
                return true;
            } else {
                return false;
            }
        }
    }
}
