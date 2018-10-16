package LeetCode.PrimaryAlgorithm.Design;

import java.util.Stack;

/**
 * 设计一个支持 push，pop，top 操作，并能在常数时间内检索到最小元素的栈。
 * <p>
 * push(x) -- 将元素 x 推入栈中。
 * pop() -- 删除栈顶的元素。
 * top() -- 获取栈顶元素。
 * getMin() -- 检索栈中的最小元素。
 */
public class MinStack {
    /**
     * initialize your data structure here.
     */
    private Stack<Integer> s1 = new Stack<>();
    private Stack<Integer> s2 = new Stack<>();

    public MinStack() {
    }

    public void push(int x) {
        s1.push(x);
        if (s2.isEmpty() || s2.peek() >= x) s2.push(x);
    }

    public void pop() {
        int x = s1.pop();
        if (x == s2.peek()) {
            s2.pop();
        }
    }

    public int top() {
        return s1.peek();
    }

    public int getMin() {
        return s2.peek();
    }

    class MinStack2 {
        private int min_val = Integer.MAX_VALUE;
        private Stack<Integer> s = new Stack<>();

        /**
         * initialize your data structure here.
         */
        public MinStack2() {
        }

        public void push(int x) {
            if (x <= min_val) {
                s.push(min_val);
                min_val = x;
            }
            s.push(x);
        }

        public void pop() {
            if (s.pop() == min_val) min_val = s.pop();
        }

        public int top() {
            return s.peek();
        }

        public int getMin() {
            return min_val;
        }
    }
}
