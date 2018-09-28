package LeetCode.PrimaryAlgorithm.LinkList;

/**
 * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 */

public class MergeTwoLists {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    class Solution {
        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            if (l1 == null) {
                return l2;
            }
            if (l2 == null) {
                return l1;
            }
            ListNode head;
            if (l1.val <= l2.val) {
                head = l1;
                l1 = l1.next;
            } else {
                head = l2;
                l2 = l2.next;
            }
            ListNode first = head;
            while (l1 != null && l2 != null) {
                if (l1.val > l2.val) {
                    head.next = l2;
                    l2 = l2.next;
                } else {
                    head.next = l1;
                    l1 = l1.next;
                }
                head = head.next;
            }
            if (l1 == null) {
                head.next = l2;
            }
            if (l2 == null) {
                head.next = l1;
            }
            return first;
        }
    }
}
