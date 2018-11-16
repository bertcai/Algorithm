package imooc.primary.Sort;

/**
 * 归并排序自底向上的实现
 */
public class MergeSortB2T {
    public static void sort(Comparable[] arr) {
        int n = arr.length;
        for (int sz = 1; sz < n; sz += sz) {
            for (int i = 0; i + sz < n; i += sz + sz) {
                MergeSort.merge(arr, i, i + sz - 1, Math.min(i + 2 * sz - 1, n - 1));
            }
        }
    }

    public static void main(String[] args) {
        SortTestHelper sortTestHelper = new SortTestHelper();
        int n = 50000;
        Integer[] arr1 = sortTestHelper.generatoNearlyOrderedArray(n, 10);
        Integer[] arr2 = sortTestHelper.copyIntArray(arr1);
        sortTestHelper.testSort("imooc.primary.Sort.InsertionSort", arr1);
        sortTestHelper.testSort("imooc.primary.Sort.MergeSortB2T", arr2);
    }
}
