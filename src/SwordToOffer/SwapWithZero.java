package SwordToOffer;

public class SwapWithZero {
    /**
     * 交换数组里n和0的位置
     *
     * @param array 数组
     * @param len   数组长度
     * @param n     和0交换的数
     */
    // 不要修改以下函数内容
    public void swapWithZero(int[] array, int len, int n) {
//        Main.SwapWithZero(array, len, n);
    }
    // 不要修改以上函数内容

    /**
     * 通过调用swapWithZero方法来排
     *
     * @param array 存储有[0,n)的数组
     * @param len   数组长度
     */
    public void sort(int[] array, int len) {
        // 完成这个函数
        swapWithZero(array, len, array[0]);
        for (int i = 1; i < len; i++) {
            for (int j = 1; j < len; j++) {
                if (array[i] > array[j]) {
                    swapWithZero(array, len, array[j]);
                    swapWithZero(array, len, array[i]);
                    swapWithZero(array, len, array[0]);
                }
            }
        }
    }
}