package LeetCode.PrimaryAlgorithm.Array;


import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
 * <p>
 * 最高位数字存放在数组的首位， 数组中每个元素只存储一个数字。
 * <p>
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 */
public class PlusOne {
    static class Solution {
        public int[] plusOne(int[] digits) {
            List<Integer> resultList = new ArrayList<>();
            if (digits[0] == 0) {
                return new int[]{1};
            }
            digits[digits.length - 1] += 1;
            for (int i = digits.length - 1; i >= 0; i--) {
                if (i == 0) {
                    break;
                }
                if (digits[i] > 9) {
                    digits[i] = 0;
                    digits[i - 1] += 1;
                }
            }
            for (int i = 0; i < digits.length; i++) {
                resultList.add(digits[i]);
            }
            int i = 0;
            int size = resultList.size();
            if (resultList.get(0) > 9) {
                size += 1;
                int[] result = new int[size];
                result[0] = 1;
                result[1] = 0;
                i = 2;
                resultList.remove(0);
                for (Integer e : resultList) {
                    result[i++] = e;
                }
                return result;
            } else {
                int[] result = new int[size];
                for (Integer e : resultList) {
                    result[i++] = e;
                }
                return result;
            }
        }
    }
}
