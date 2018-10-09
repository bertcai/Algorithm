package LeetCode.PrimaryAlgorithm.Tree;

import java.util.Arrays;

/**
 * 将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。
 * <p>
 * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
 */
public class SortedArrayToBST {
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
        public TreeNode sortedArrayToBST(int[] nums) {
            if (nums.length == 0) {
                return null;
            }
            TreeNode root = new TreeNode(0);
            int length = nums.length;
            root.val = nums[length / 2];
            root.left = sortedArrayToBST(Arrays.copyOfRange(nums, 0, length / 2));
            root.right = sortedArrayToBST(Arrays.copyOfRange(nums, length / 2 + 1, length));
            return root;
        }
    }
}
