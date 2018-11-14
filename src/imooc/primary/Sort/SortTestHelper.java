package imooc.primary.Sort;

import java.lang.reflect.Method;
import java.util.Date;

public class SortTestHelper {
    /**
     * 生成随机数组
     *
     * @param n      数组长度
     * @param rangeL 数组范围
     * @param rangeR 数组范围 [rangeL,rangeR]
     * @return 数组
     */
    public Integer[] generateRandomArray(int n, int rangeL, int rangeR) {
        assert (rangeL < rangeR);
        Integer[] arr = new Integer[n];
        for (int i = 0; i < n; i++) {
            arr[i] = (int) (Math.random() * (rangeR - rangeL));
        }
        return arr;
    }

    public <E> void printArray(E[] inputArray) {
        // 输出数组元素
        for (E element : inputArray) {
            System.out.printf("%s ", element);
        }
        System.out.println();
    }

    public void printArray(int[] inputArray) {
        // 输出数组元素
        for (int element : inputArray) {
            System.out.printf("%s ", element);
        }
        System.out.println();
    }

    // 测试sortClassName所对应的排序算法排序arr数组所得到结果的正确性和算法运行时间
    public void testSort(String sortClassName, Comparable[] arr) {

        // 通过Java的反射机制，通过排序的类名，运行排序函数
        // * 依然是，使用反射机制并不是这个课程的重点, 大家也完全可以使用自己的方式书写代码, 最终只要能够测试出自己书写的算法的效率即可
        // * 推荐大家阅读我在问答区向大家分享的一个学习心得: 【学习心得分享】请大家抓大放小，不要纠结于C++语言的语法细节
        // * 链接: http://coding.imooc.com/learn/questiondetail/4100.html
        try {
            // 通过sortClassName获得排序函数的Class对象
            Class sortClass = Class.forName(sortClassName);
            // 通过排序函数的Class对象获得排序方法
            Method sortMethod = sortClass.getMethod("sort", new Class[]{Comparable[].class});
            // 排序参数只有一个，是可比较数组arr
            Object[] params = new Object[]{arr};

            long startTime = System.currentTimeMillis();
            // 调用排序函数
            sortMethod.invoke(null, params);
            long endTime = System.currentTimeMillis();

            assert isSorted(arr);

            System.out.println(sortClass.getSimpleName() + " : " + (endTime - startTime) + "ms");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean isSorted(Comparable[] arr) {
        for (int i = 0; i < arr.length - 1; i++)
            if (arr[i].compareTo(arr[i + 1]) > 0)
                return false;
        return true;
    }

    public Integer[] copyIntArray(Integer a[]) {
        Integer[] res = new Integer[a.length];
        System.arraycopy(a, 0, res, 0, a.length);
        return res;
    }

}
