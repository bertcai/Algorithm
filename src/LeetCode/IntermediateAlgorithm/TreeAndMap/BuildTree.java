package LeetCode.IntermediateAlgorithm.TreeAndMap;

import java.util.Arrays;

/**
 * 根据一棵树的前序遍历与中序遍历构造二叉树。
 */
public class BuildTree {
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
        public TreeNode buildTree(int[] preorder, int[] inorder) {
            if (preorder.length != inorder.length) {
                return null;
            }
            return constructorTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
        }

        private int findRoot(int[] array, int start, int end, int key) {
            for (int i = start; i <= end; i++) {
                if (array[i] == key) {
                    return i;
                }
            }
            return -1;
        }

        private TreeNode constructorTree(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
            if (inStart > inEnd) {
                return null;
            }
            TreeNode root = new TreeNode(preorder[preStart]);
            int positon = findRoot(inorder, inStart, inEnd, preorder[preStart]);
            root.left = constructorTree(preorder, preStart + 1, preStart + (positon - inStart), inorder, inStart, positon - 1);
            root.right = constructorTree(preorder, preStart + (positon - inStart) + 1, preEnd, inorder, positon + 1, inEnd);
            return root;
        }
    }
}
