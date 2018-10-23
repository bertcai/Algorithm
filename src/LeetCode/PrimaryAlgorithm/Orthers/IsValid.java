package LeetCode.PrimaryAlgorithm.Orthers;

import java.util.Stack;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * <p>
 * 有效字符串需满足：
 * <p>
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串
 */
public class IsValid {
    class Solution {
        public boolean isValid(String s) {
            if (s.length() == 0) {
                return true;
            }
            Stack<Character> leftStack = new Stack<>();
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (c == '(' || c == '{' || c == '[') {
                    leftStack.push(c);
                } else if (c == ')' || c == '}' || c == ']') {
                    if (leftStack.isEmpty()) {
                        return false;
                    }
                    char t = leftStack.pop();
                    if (t == '(' && c == ')') {
                        continue;
                    }
                    if (t == '[' && c == ']') {
                        continue;
                    }
                    if (t == '{' && c == '}') {
                        continue;
                    }
                    return false;
                }
            }
            return leftStack.isEmpty();
        }
    }
}
