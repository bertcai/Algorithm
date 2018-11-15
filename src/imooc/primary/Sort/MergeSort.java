package imooc.primary.Sort;

import java.util.Arrays;

public class MergeSort {
    public static void sort(Comparable[] arr) {
        mergeSort(arr, 0, arr.length - 1);
    }

    /**
     * 递归使用归并排序
     *
     * @param arr   数组
     * @param left  左
     * @param right 右
     */
    private static void mergeSort(Comparable[] arr, int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = (left + right) / 2;
        mergeSort(arr, left, mid);
        mergeSort(arr, mid + 1, right);
        merge(arr, left, mid, right);
    }

    private static void merge(Comparable[] arr, int left, int mid, int right) {
        Comparable[] res;
        res = Arrays.copyOfRange(arr, left, right + 1);
        int i = left;
        int j = mid + 1;
        for (int k = left; k <= right; k++) {
            if (i > mid) {
                arr[k] = arr[j - left];
                j++;
                continue;
            }
            if (j > right) {
                arr[k] = arr[i - left];
                i++;
                continue;
            }
            if (res[i - left].compareTo(res[j - left]) <= 0) {
                arr[k] = res[i - left];
                i++;
            } else {
                arr[k] = res[j - left];
                j++;
            }
        }
    }

    public static void main(String[] args) {
        SortTestHelper sortTestHelper = new SortTestHelper();
        int n = 50000;
        Integer[] arr1 = sortTestHelper.generateRandomArray(n, 0, n);
        Integer[] arr2 = sortTestHelper.copyIntArray(arr1);
        sortTestHelper.testSort("imooc.primary.Sort.SelectSort", arr1);
        sortTestHelper.testSort("imooc.primary.Sort.MergeSort", arr2);
    }
}
