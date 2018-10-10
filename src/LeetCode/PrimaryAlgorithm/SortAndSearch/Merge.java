package LeetCode.PrimaryAlgorithm.SortAndSearch;

/**
 * 给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。
 * <p>
 * 说明:
 * <p>
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n。
 * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
 */

/**
 * 由于合并后A数组的大小必定是m+n，所以从最后面开始往前赋值，先比较A和B中最后一个元素的大小，把较大的那个插入到m+n-1
 * 的位置上，再依次向前推。如果A中所有的元素都比B小，那么前m个还是A原来的内容，没有改变。如果A中的数组比B大的，当A循
 * 环完了，B中还有元素没加入A，直接用个循环把B中所有的元素覆盖到A剩下的位置。
 */
public class Merge {
    class Solution {
        public void merge(int[] nums1, int m, int[] nums2, int n) {
            int count = m + n - 1;
            --m;
            --n;
            while (m >= 0 && n >= 0) {
                nums1[count--] = nums1[m] > nums2[n] ? nums1[m--] : nums2[n--];
            }
            while (n >= 0) {
                nums1[count--] = nums2[n--];
            }
        }
    }
}
