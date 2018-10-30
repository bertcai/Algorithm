package LeetCode.IntermediateAlgorithm.ArrayAndString;

/**
 * 给定一个未排序的数组，判断这个数组中是否存在长度为 3 的递增子序列。
 * <p>
 * 数学表达式如下:
 * <p>
 * 如果存在这样的 i, j, k,  且满足 0 ≤ i < j < k ≤ n-1，
 * 使得 arr[i] < arr[j] < arr[k] ，返回 true ; 否则返回 false 。
 * 说明: 要求算法的时间复杂度为 O(n)，空间复杂度为 O(1) 。
 */
public class IncreasingTriplet {
    class Solution {
        public boolean increasingTriplet(int[] nums) {
            int min = Integer.MAX_VALUE;
            int middle = Integer.MAX_VALUE;
            for (int num : nums) {
                if (num <= min) {
                    min = num;
                } else if (num <= middle) {
                    middle = num;
                } else {
                    return true;
                }
            }
            return false;
        }
    }
}
