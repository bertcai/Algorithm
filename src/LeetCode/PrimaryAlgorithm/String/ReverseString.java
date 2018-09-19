package LeetCode.PrimaryAlgorithm.String;

/**
 * 编写一个函数，其作用是将输入的字符串反转过来
 */
public class ReverseString {
    class Solution {
        public String reverseString(String s) {
            int length = s.length();
            StringBuilder result = new StringBuilder();
            for (int i = length - 1; i >= 0; i--) {
                result.append(s.charAt(i));
            }
            return result.toString();
        }
    }
}
