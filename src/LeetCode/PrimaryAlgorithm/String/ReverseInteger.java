package LeetCode.PrimaryAlgorithm.String;

/**
 * 给定一个 32 位有符号整数，将整数中的数字进行反转。
 * <p>
 * 假设我们的环境只能存储 32 位有符号整数，其数值范围是 [−231,  231 − 1]。根据这个假设，如果反转后的整数溢出，则返回 0。
 */
public class ReverseInteger {
    class Solution {
        public int reverse(int x) {
            if (x == Integer.MIN_VALUE || x == 0) {
                return 0;
            }
            String s = "" + Math.abs(x);
            int length = s.length();
            StringBuilder result = new StringBuilder();
            for (int i = length - 1; i >= 0; i--) {
                result.append(s.charAt(i));
            }
            try {
                int resultInt = Integer.parseInt(result.toString());
                if (x > 0) {
                    return resultInt;
                } else {
                    return -resultInt;
                }
            } catch (NumberFormatException e) {
                return 0;
            }
        }
    }
}
