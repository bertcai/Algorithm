package LeetCode.PrimaryAlgorithm.LinkList;

import java.util.Stack;

/**
 * 反转一个单链表。
 */

public class ReverseList {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    class Solution {
        public ListNode reverseList(ListNode head) {
            if (head == null) {
                return head;
            }
            Stack<ListNode> listNodeStack = new Stack<>();
            while (head != null) {
                listNodeStack.add(head);
                head = head.next;
            }
            head = listNodeStack.pop();
            ListNode temp = head;
            while (!listNodeStack.empty()) {
                temp.next = listNodeStack.pop();
                temp = temp.next;
            }
            temp.next = null;
            return head;
        }
    }

    class Solution2 {
        public ListNode reverseList(ListNode head) {
            if(head == null || head.next == null){
                return head;
            }
            ListNode tmp;
            ListNode res = null;
            while (head!=null){
                tmp = head.next;
                head.next = res;
                res = head;
                head  = tmp;

            }
            return res;
        }
    }
}
