package LeetCode.IntermediateAlgorithm.LinkList;

/**
 * 给定两个非空链表来表示两个非负整数。位数按照逆序方式存储，它们的每个节点只存储单个数字。将两数相加返回一个新的链表。
 * <p>
 * 你可以假设除了数字 0 之外，这两个数字都不会以零开头。
 */
public class AddTwoNumbers {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) { val = x; }
     * }
     */
    class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode tmp = null;
            ListNode result = null;

            int carry = 0;
            while (l1 != null || l2 != null || carry != 0) {
                int sum = (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val) + carry;
                carry = sum / 10;

                ListNode node = new ListNode(sum % 10);
                if (tmp == null) {
                    tmp = node;
                    result = tmp;
                } else {
                    tmp.next = node;
                    tmp = tmp.next;
                }

                l1 = l1 == null ? null : l1.next;
                l2 = l2 == null ? null : l2.next;
            }

            return result;
        }
    }
}
