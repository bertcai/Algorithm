package LeetCode.PrimaryAlgorithm.LinkList;

/**
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 * <p>
 * 给定的 n 保证是有效的。
 */
public class RemoveNthFromEnd {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    class Solution {
        public ListNode removeNthFromEnd(ListNode head, int n) {
            if (head.next == null) {
                return null;
            }
            ListNode temp = head;
            for (int i = 0; i < n; i++) {
                temp = temp.next;
            }
            if (temp == null) {
                head = head.next;
                return head;
            }
            ListNode delete = head;
            while (temp.next != null) {
                delete = delete.next;
                temp = temp.next;
            }
            delete.next = delete.next.next;
            return head;
        }
    }
}
