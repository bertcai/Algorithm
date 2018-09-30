package LeetCode.PrimaryAlgorithm.Tree;

/**
 * 给定一个二叉树，找出其最大深度。
 * <p>
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 */
public class MaxDepth {
    class Solution {
        public int maxDepth(TreeNode root) {
            int depth = 0;
            if (root != null) {
                int ldepth = maxDepth(root.left);
                int rdepth = maxDepth(root.right);
                depth = (ldepth > rdepth ? ldepth : rdepth)+1;
            }
            return depth;
        }
    }
}
