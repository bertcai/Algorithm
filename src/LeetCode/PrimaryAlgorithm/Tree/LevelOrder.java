package LeetCode.PrimaryAlgorithm.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 给定一个二叉树，返回其按层次遍历的节点值。 （即逐层地，从左到右访问所有节点）。
 */
public class LevelOrder {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */
    class Solution {
        public List<List<Integer>> levelOrder(TreeNode root) {
            List<List<Integer>> tree = new ArrayList<>();
            if (root == null) {
                return tree;
            }
            Queue<TreeNode> q = new LinkedList<>();
            q.offer(root);
            while (!q.isEmpty()) {
                ArrayList<Integer> list = new ArrayList<>();
                int size = q.size();
                for (int i = 0; i < size; i++) {
                    TreeNode head = q.poll();
                    list.add(head.val);
                    if (head.left != null) {
                        q.offer(head.left);
                    }
                    if (head.right != null) {
                        q.offer(head.right);
                    }
                }
                tree.add(list);
            }
            return tree;
        }
    }
}
