package LeetCode.PrimaryAlgorithm.String;

/**
 * 报数序列是指一个整照其中的整数的顺序进数序列，按行报数，得到下一个数。其前五项如下：
 * <p>
 * 1.     1
 * 2.     11
 * 3.     21
 * 4.     1211
 * 5.     111221
 * 1 被读作  "one 1"  ("一个一") , 即 11。
 * 11 被读作 "two 1s" ("两个一"）, 即 21。
 * 21 被读作 "one 2",  "one 1" （"一个二" ,  "一个一") , 即 1211。
 * <p>
 * 给定一个正整数 n（1 ≤ n ≤ 30），输出报数序列的第 n 项。
 * <p>
 * 注意：整数顺序将表示为一个字符串。
 */
public class CountAndSay {
    static class Solution {
        public String countAndSay(int n) {
            String str = "11";
            if (n == 1) {
                return "1";
            }
            if (n == 2) {
                return str;
            }
            for (int i = 2; i < n; i++) {
                int length = str.length();
                int count = 1;
                String res = "";
                for (int j = 0; j < length - 1; j++) {
                    if (str.charAt(j) != str.charAt(j + 1)) {
                        res += "" + count + str.charAt(j);
                        count = 1;
                        continue;
                    }
                    count++;
                }
                res += "" + count + str.charAt(str.length() - 1);
                str = res;
            }
            return str;
        }
    }
}
