package imooc.primary.Sort;

public class ShellSort {
    public static void sort(Comparable arr[]) {
        int number = arr.length / 2; // 步长
        int i, j;
        Comparable temp;
        while (number >= 1) {
            for (i = number; i < arr.length; i++) {
                temp = arr[i];
                j = i - number;
                while (j >= 0 && (arr[j].compareTo(temp) > 0)) {
                    arr[j + number] = arr[j];
                    j = j - number;
                }
                arr[j + number] = temp;
            }
            number = number / 2;
        }
    }

    public static void main(String[] args) {
        SortTestHelper sortTestHelper = new SortTestHelper();
        int n = 10000;
        Integer[] arr = sortTestHelper.generateRandomArray(n, 0, n);
        Integer[] arr2 = sortTestHelper.copyIntArray(arr);
        Integer[] arr3 = sortTestHelper.copyIntArray(arr);
        sortTestHelper.testSort("imooc.primary.Sort.SelectSort", arr);
        sortTestHelper.testSort("imooc.primary.Sort.InsertionSort", arr2);
        sortTestHelper.testSort("imooc.primary.Sort.ShellSort", arr3);
    }
}
