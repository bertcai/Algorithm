package LeetCode.PrimaryAlgorithm.LinkList;

/**
 * 给定一个链表，判断链表中是否有环。
 * <p>
 * 你能否不使用额外空间解决此题？
 *
 * 如果有环，定义快慢两个节点对链表进行遍历时必然会相遇
 */
public class HasCycle {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public class Solution {
        public boolean hasCycle(ListNode head) {
            if (head == null || head.next == null) {
                return false;
            }
            ListNode fast = head;
            ListNode slow = head;
            while (fast.next != null && fast.next.next != null) {
                slow = slow.next;
                fast = fast.next.next;
                if (slow == fast) {
                    return true;
                }
            }
            return false;
        }
    }
}
