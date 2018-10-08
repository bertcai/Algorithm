package LeetCode.PrimaryAlgorithm.Tree;

import java.util.Stack;

/**
 * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 * <p>
 * 假设一个二叉搜索树具有如下特征：
 * <p>
 * 节点的左子树只包含小于当前节点的数。
 * 节点的右子树只包含大于当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 */
public class IsValidBST {
    class Solution {
        public boolean isValidBST(TreeNode root) {
            if (root == null) {
                return true;
            }
            Stack<TreeNode> s = new Stack<>();
            TreeNode cur = root;
            TreeNode pre = null;
            while (true) {
                while (cur != null) {
                    s.push(cur);
                    cur = cur.left;
                }
                if (s.isEmpty()) {
                    break;
                }
                cur = s.pop();
                if (pre != null && pre.val >= cur.val) {
                    return false;
                }

                pre = cur;
                cur = cur.right;
            }
            return true;
        }
    }
}
