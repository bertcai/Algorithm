package LeetCode.IntermediateAlgorithm.TreeAndMap;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个二叉树，返回其节点值的锯齿形层次遍历。
 * （即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 */
public class ZigzagLevelOrder {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */

    // 在层次遍历的基础上加入一个标志位，根据标志位判断是正序还是逆序插入链表
    class Solution {
        public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
            List<List<Integer>> res = new ArrayList<>();
            if (root == null) {
                return res;
            }
            LinkedList<TreeNode> nodelist = new LinkedList<>();
            boolean order = true;
            nodelist.offer(root);
            while (!nodelist.isEmpty()) {
                int size = nodelist.size();
                List<Integer> al = new ArrayList<>();
                for (int i = 0; i < size; i++) {
                    TreeNode node = nodelist.poll();
                    if (order) {
                        al.add(node.val);
                    } else {
                        al.add(0, node.val);
                    }
                    if (node.left != null) {
                        nodelist.offer(node.left);
                    }
                    if (node.right != null) {
                        nodelist.offer(node.right);
                    }
                }
                order = !order;
                res.add(al);
            }
            return res;
        }
    }
}
