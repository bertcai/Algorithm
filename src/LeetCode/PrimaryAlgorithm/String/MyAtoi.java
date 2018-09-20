package LeetCode.PrimaryAlgorithm.String;

/**
 * 实现 atoi，将字符串转为整数。
 * <p>
 * 该函数首先根据需要丢弃任意多的空格字符，直到找到第一个非空格字符为止。如果第一个非空字符是正号或负号，选取该符号，并将其与后面尽可能多的连续的数字组合起来，这部分字符即为整数的值。如果第一个非空字符是数字，则直接将其与之后连续的数字字符组合起来，形成整数。
 * <p>
 * 字符串可以在形成整数的字符后面包括多余的字符，这些字符可以被忽略，它们对于函数没有影响。
 * <p>
 * 当字符串中的第一个非空字符序列不是个有效的整数；或字符串为空；或字符串仅包含空白字符时，则不进行转换。
 * <p>
 * 若函数不能执行有效的转换，返回 0。
 * <p>
 * 假设我们的环境只能存储 32 位有符号整数，其数值范围是 [−231,  231 − 1]。如果数值超过可表示的范围，则返回  INT_MAX (231 − 1) 或 INT_MIN (−231) 。
 */
public class MyAtoi {
    class Solution {
        public int myAtoi(String str) {
            String s = str.trim();
            if ("".equals(s)) {
                return 0;
            }

            boolean operator = true;
            String numString;
            if (!isNumber(s.charAt(0))) {
                if (s.charAt(0) != '+' && s.charAt(0) != '-') {
                    return 0;
                }
                if (s.charAt(0) == '-') {
                    operator = false;
                }
                numString = getNumStr(s.substring(1, s.length()));
            } else {
                numString = getNumStr(s);
            }
            if ("".equals(numString)) {
                return 0;
            }
            if (numString.length() > 10) {
                if (operator) {
                    return Integer.MAX_VALUE;
                } else {
                    return Integer.MIN_VALUE;
                }
            }

            //转化数值
            long num = Long.parseLong(numString);
            if (!operator) {
                num = -num;
            }

            //根据结果范围返回数值
            if (num < Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            }
            if (num > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }

            return (int) num;
        }

        private boolean isNumber(char c) {
            if (c >= '0' && c <= '9') {
                return true;
            } else {
                return false;
            }
        }

        private String getNumStr(String s) {
            StringBuilder num = new StringBuilder();
            boolean isStart = true;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                    if (isStart && s.charAt(i) == '0') {
                        continue;
                    }
                    isStart = false;
                    num.append(s.charAt(i));
                } else {
                    break;
                }
            }

            return num.toString();
        }
    }
}
