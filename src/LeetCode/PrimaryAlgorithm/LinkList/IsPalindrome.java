package LeetCode.PrimaryAlgorithm.LinkList;

import java.util.Stack;

/**
 * 请判断一个链表是否为回文链表。
 * <p>
 * 你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
 */

public class IsPalindrome {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    class Solution {
        public boolean isPalindrome(ListNode head) {
            ListNode temp = head;
            Stack<ListNode> listNodeStack = new Stack<>();
            while (temp != null) {
                listNodeStack.push(temp);
                temp = temp.next;
            }
            while (!listNodeStack.empty()) {
                temp = listNodeStack.pop();
                if (temp.val == head.val) {
                    head = head.next;
                } else {
                    return false;
                }
            }
            return true;
        }
    }

    // 用 O(n) 时间复杂度和 O(1) 空间复杂度解决
    class Solution2 {
        public boolean isPalindrome(ListNode head) {
            if (head == null || head.next == null) {
                return true;
            }
            ListNode fast = head;
            ListNode slow = head;
            while (fast.next != null && fast.next.next != null) {
                fast = fast.next.next;
                slow = slow.next;
            }
            int flag = 0; // 判断链表奇 偶
            if (fast.next == null) {
                flag = 1;
            }

            ListNode head2 = slow.next;
            ListNode pre = null;
            ListNode now = head;
            ListNode next = head;
            while (next != head2) {
                next = now.next;
                now.next = pre;

                pre = now;
                now = next;
            }
            if (flag == 1) {
                pre = pre.next;
            }
            while (head2 != null) {
                if (head2.val != pre.val) {
                    return false;
                }
                head2 = head2.next;
                pre = pre.next;
            }
            return true;
        }
    }
}
