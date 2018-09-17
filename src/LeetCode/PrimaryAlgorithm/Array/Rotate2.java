package LeetCode.PrimaryAlgorithm.Array;

/**
 * 给定一个 n × n 的二维矩阵表示一个图像。
 * <p>
 * 将图像顺时针旋转 90 度。
 * <p>
 * 你必须在原地旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要使用另一个矩阵来旋转图像。
 */
public class Rotate2 {
    class Solution {
        public void rotate(int[][] matrix) {
            int length = matrix.length;

            // 调换对角元素
            for (int i = 0; i < length; i++) {
                for (int j = 0; j < length - i; j++) {
                    int tmp = matrix[i][j];
                    matrix[i][j] = matrix[length - j - 1][length - i - 1];
                    matrix[length - j - 1][length - i - 1] = tmp;
                }
            }

            // 调换列元素
            for (int i = 0; i < length; i++) {
                for (int j = 0; j < length / 2; j++) {
                    int tmp = matrix[j][i];
                    matrix[j][i] = matrix[length - j - 1][i];
                    matrix[length - j - 1][i] = tmp;
                }
            }
        }
    }
}
