package imooc.primary.Sort;

/**
 * 冒泡排序算法的原理如下：
 * 比较相邻的元素。如果第一个比第二个大，就交换他们两个。
 * 对每一对相邻元素做同样的工作，从开始第一对到结尾的最后一对。在这一点，最后的元素应该会是最大的数。
 * 针对所有的元素重复以上的步骤，除了最后一个。
 * 持续每次对越来越少的元素重复上面的步骤，直到没有任何一对数字需要比较。
 */
public class BubbleSort {
    public static void sort(Comparable arr[]) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j].compareTo(arr[j + 1]) > 0) {
                    Comparable temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        SortTestHelper sortTestHelper = new SortTestHelper();
        int n = 10000;
        Integer[] arr = sortTestHelper.generateRandomArray(n, 0, 3);
        Integer[] arr2 = sortTestHelper.copyIntArray(arr);
        Integer[] arr3 = sortTestHelper.copyIntArray(arr);
        sortTestHelper.testSort("imooc.primary.Sort.SelectSort", arr);
        sortTestHelper.testSort("imooc.primary.Sort.InsertionSort", arr2);
        sortTestHelper.testSort("imooc.primary.Sort.BubbleSort", arr3);

    }
}
