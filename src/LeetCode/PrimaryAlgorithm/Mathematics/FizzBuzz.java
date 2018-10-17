package LeetCode.PrimaryAlgorithm.Mathematics;

import java.util.ArrayList;
import java.util.List;

/**
 * 写一个程序，输出从 1 到 n 数字的字符串表示。
 * <p>
 * 1. 如果 n 是3的倍数，输出“Fizz”；
 * <p>
 * 2. 如果 n 是5的倍数，输出“Buzz”；
 * <p>
 * 3.如果 n 同时是3和5的倍数，输出 “FizzBuzz”。
 */
public class FizzBuzz {
    class Solution {
        public List<String> fizzBuzz(int n) {
            List<String> list = new ArrayList<>();
            for (int i = 1; i <= n; i++) {
                if (i % 3 == 0 && i % 5 == 0) {
                    list.add("FizzBuzz");
                } else if (i % 3 == 0) {
                    list.add("Fizz");
                } else if (i % 5 == 0) {
                    list.add("Buzz");
                } else {
                    list.add(i + "");
                }
            }
            return list;
        }
    }
}
