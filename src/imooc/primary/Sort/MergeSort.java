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

        if (right - left <= 15) {
            InsertionSort.sort2(arr, left, right); // 当数量级比较小的时候，插入排序要比归并更优，所以可以优化
            return;
        }

        int mid = (left + right) / 2;
        mergeSort(arr, left, mid);
        mergeSort(arr, mid + 1, right);
        if (arr[mid].compareTo(arr[mid + 1]) > 0) { // 当需要归并的数组不是有序的才进行归并操作
            merge(arr, left, mid, right);
        }
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
        Integer[] arr1 = sortTestHelper.generatoNearlyOrderedArray(n, 10);
        Integer[] arr2 = sortTestHelper.copyIntArray(arr1);
        sortTestHelper.testSort("imooc.primary.Sort.InsertionSort", arr1);
        sortTestHelper.testSort("imooc.primary.Sort.MergeSort", arr2);
    }
}
