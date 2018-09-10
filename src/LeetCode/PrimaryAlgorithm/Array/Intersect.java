package LeetCode.PrimaryAlgorithm.Array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * 给定两个数组，编写一个函数来计算它们的交集。
 * <p>
 * 输出结果中每个元素出现的次数，应与元素在两个数组中出现的次数一致。
 * <p>
 * 我们可以不考虑输出结果的顺序。
 * <p>
 * 如果给定的数组已经排好序呢？你将如何优化你的算法？
 * <p>
 * 如果 nums1 的大小比 nums2 小很多，哪种方法更优？
 * <p>
 * 如果 nums2 的元素存储在磁盘上，磁盘内存是有限的，并且你不能一次加载所有的元素到内存中，你该怎么办？
 */

public class Intersect {
    /**
     * 可以通过一个hashmap来解决，我们对第一个数组做一个hash映射，key为出现的数字值，value为该数字出现的次数
     * 然后遍历第二个数组，第二个数组存在这个hash中且value>0，就加到一个临时数组tmp中，同时将value减一，这个
     * 临时数组tmp即为我们要的结果
     */
    class Solution {
        public int[] intersect(int[] nums1, int[] nums2) {
            Map<Integer, Integer> map = new HashMap();
            List<Integer> tmp = new ArrayList();

            for (int i = 0; i < nums1.length; i++) {
                Integer value = map.get(nums1[i]);
                map.put(nums1[i], (value == null ? 0 : value) + 1);
            }
            for (int i = 0; i < nums2.length; i++) {
                if (map.containsKey(nums2[i]) && map.get(nums2[i]) != 0) {
                    tmp.add(nums2[i]);
                    map.put(nums2[i], map.get(nums2[i]) - 1);
                }
            }
            int[] result = new int[tmp.size()];
            int i = 0;
            for (Integer e : tmp)
                result[i++] = e;
            return result;
        }
    }


    /**
     * 给定数组已经排好序
     */
    class Solution2 {
        public int[] intersect(int[] nums1, int[] nums2) {
            List<Integer> tmp = new ArrayList();
            int i = 0, j = 0;
            while (i < nums1.length && j < nums2.length) {
                if (nums1[i] == nums2[j]) {
                    tmp.add(nums1[i]);
                } else if (nums1[i] > nums2[j]) {
                    j++;
                } else {
                    i++;
                }
            }
            int[] result = new int[tmp.size()];
            int k = 0;
            for (Integer e : tmp) {
                result[k++] = e;
            }
            return result;
        }
    }
}