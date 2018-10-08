package LeetCode.PrimaryAlgorithm.Tree;

/**
 * 给定一个二叉树，检查它是否是镜像对称的。
 * <p>
 * 如果你可以运用递归和迭代两种方法解决这个问题，会很加分。
 */
public class IsSymmetric {
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
        public boolean isSymmetric(TreeNode root) {
            if (root == null) {
                return true;
            }
            return check(root.left, root.right);
        }

        private boolean check(TreeNode l, TreeNode r) {
            if (l == null && r == null) {
                return true;
            } else if (l != null && r != null) {
                if (l.val != r.val) {
                    return false;
                } else {
                    return check(l.left, r.right) && check(l.right, r.left);
                }
            } else {
                return false;
            }
        }
    }
}
