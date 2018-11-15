package imooc.primary.Sort;

public class InsertionSort {
    public static void sort(Comparable arr[]) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int j;
            Comparable temp = arr[i];
            for (j = i; j > 0 && arr[j - 1].compareTo(temp) > 0; j--) {
                arr[j] = arr[j - 1];
            }
            arr[j] = temp;
        }
    }

    private static void swap(Object[] arr, int i, int j) {
        Object t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    public static void sort2(Comparable[] arr, int left, int right) {
        for (int i = left + 1; i <= right; i++) {
            int j;
            Comparable temp = arr[i];
            for (j = i; j > left && arr[j - 1].compareTo(temp) > 0; j--) {
                arr[j] = arr[j - 1];
            }
            arr[j] = temp;
        }
    }

    public static void main(String[] args) {
        SortTestHelper sortTestHelper = new SortTestHelper();
        int n = 10000;
        Integer[] arr = sortTestHelper.generateRandomArray(n, 0, 3);
        Integer[] arr2 = sortTestHelper.copyIntArray(arr);
        sortTestHelper.testSort("imooc.primary.Sort.SelectSort", arr);
        sortTestHelper.testSort("imooc.primary.Sort.InsertionSort", arr2);
    }

}
