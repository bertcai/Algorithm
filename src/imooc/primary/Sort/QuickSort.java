package imooc.primary.Sort;

public class QuickSort {
    public static void sort(Comparable[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    private static void quickSort(Comparable[] arr, int l, int r) {
        if (l >= r) {
            return;
        }
        if (r - l < 15) { //待排序数量比较小时使用插入排序优化
            InsertionSort.sort2(arr, l, r);
        }
        int p = partition(arr, l, r);
        quickSort(arr, l, p - 1);
        quickSort(arr, p + 1, r);
    }

    /**
     * 快速排序的递归子过程，将给定范围的数组分为[l,p-1] [p+1,r]两部分
     *
     * @param arr 待排序数组
     * @param l   排序区间
     * @param r   排序区间
     * @return 中间值得索引
     */
    private static int partition(Comparable[] arr, int l, int r) {
        int randomIndex = (int) (Math.random() * (r - l)); // 随机取一个数作为中间值索引
        Comparable temp1 = arr[randomIndex];
        arr[randomIndex] = arr[l];
        arr[l] = temp1;
        Comparable midValue = arr[l];
        int j = l;
        int i = l + 1;
        for (; i <= r && j <= r; i++) {
            if (arr[i].compareTo(midValue) < 0) {
                Comparable temp = arr[i];
                arr[i] = arr[j + 1];
                arr[j + 1] = temp;
                j++;
            }
        }
        Comparable temp = arr[j];
        arr[j] = midValue;
        arr[l] = temp;
        return j;
    }

    public static void main(String[] args) {
        SortTestHelper sortTestHelper = new SortTestHelper();
        int n = 30;
        Integer[] arr = sortTestHelper.generateRandomArray(n, 1, n);
        Integer[] arr2 = sortTestHelper.copyIntArray(arr);
        sortTestHelper.testSort("imooc.primary.Sort.QuickSort", arr);
        sortTestHelper.testSort("imooc.primary.Sort.MergeSort", arr2);
    }
}
