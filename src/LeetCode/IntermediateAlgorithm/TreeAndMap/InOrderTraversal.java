package LeetCode.IntermediateAlgorithm.TreeAndMap;

import LeetCode.IntermediateAlgorithm.LinkList.ListNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class InOrderTraversal {
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
        public List<Integer> inorderTraversal(TreeNode root) {
            Stack<TreeNode> s = new Stack<>();
            List<Integer> res = new ArrayList<>();
            TreeNode p = root;
            while (!s.isEmpty() || p != null) {
                while (p != null) {
                    s.push(p);
                    p = p.left;
                }
                if (!s.isEmpty()) {
                    p = s.pop();
                    res.add(p.val);
                    p = p.right;
                }
            }
            return res;
        }
    }
}
