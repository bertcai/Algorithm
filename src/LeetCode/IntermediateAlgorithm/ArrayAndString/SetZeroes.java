package LeetCode.IntermediateAlgorithm.ArrayAndString;

import java.util.Arrays;

/**
 * 给定一个 m x n 的矩阵，如果一个元素为 0，则将其所在行和列的所有元素都设为 0。请使用原地算法。
 * <p>
 * 在计算机科学中，一个原地算法（in-place algorithm）是一种使用小的，固定数量的额外之空间来转换资料的算法。当算法执行
 * 时，输入的资料通常会被要输出的部份覆盖掉。不是原地算法有时候称为非原地（not-in-place）或不得其所（out-of-place）。
 */
public class SetZeroes {
    // o[m*n]
    class Solution {
        public void setZeroes(int[][] matrix) {
            int[][] res = new int[matrix.length][matrix[0].length];
            int m = matrix.length;
            int n = matrix[0].length;
            for (int i = 0; i < m; i++) {
                System.arraycopy(matrix[i], 0, res[i], 0, n);
            }
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (matrix[i][j] == 0) {
                        Arrays.fill(res[i], 0);
                        for (int k = 0; k < m; k++) {
                            res[k][j] = 0;
                        }
                    }
                }
            }
            for (int i = 0; i < m; i++) {
                System.arraycopy(res[i], 0, matrix[i], 0, n);
            }
        }
    }

    // o[m+n]
    class Solution2 {
        public void setZeroes(int[][] matrix) {
            if (matrix.length <= 0) return;
            boolean[] m = new boolean[matrix.length];
            boolean[] n = new boolean[matrix[0].length];

            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[0].length; j++) {
                    if (matrix[i][j] == 0) {
                        m[i] = true;
                        n[j] = true;
                    }
                }
            }

            for (int i = 0; i < matrix.length; i++) {
                if (m[i]) {
                    Arrays.fill(matrix[i], 0);
                }
            }

            for (int j = 0; j < n.length; j++) {
                if (n[j]) {
                    for (int i = 0; i < matrix.length; i++) {
                        matrix[i][j] = 0;
                    }
                }
            }
        }
    }

    // o(1)
    // 首先遍历出第一个需要置0的行列，记录行列值，然后继续往下遍历，将需要置0的行列值保存在初始行列中
    class Solution3 {
        public void setZeroes(int[][] matrix) {
            if (matrix.length <= 0) return;
            int row = -1;
            int col = -1;

            int i = 0;
            label:
            for (i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[0].length; j++) {
                    if (matrix[i][j] == 0) {
                        row = i;
                        col = j;
                        break label;
                    }
                }
            }
            if (i == matrix.length) {
                return;
            }

            for (int k = i + 1; k < matrix.length; k++) {
                for (int j = 0; j < matrix[0].length; j++) {
                    if (matrix[k][j] == 0) {
                        matrix[row][j] = 0;
                        matrix[k][col] = 0;
                    }
                }
            }
            //遍历记录行列中的行，将列置为0
            for (i = 0; i < matrix[0].length; i++) {
                if (i == col) {
                    continue;//注意
                }
                if (matrix[row][i] == 0) {
                    for (int j = 0; j < matrix.length; j++) {
                        matrix[j][i] = 0;
                    }
                }
            }
            //遍历记录行列中的列，将行置为0
            for (i = 0; i < matrix.length; i++) {
                if (i == row) {
                    continue;//注意
                }
                if (matrix[i][col] == 0) {
                    for (int j = 0; j < matrix[0].length; j++) {
                        matrix[i][j] = 0;
                    }
                }
            }
            //将记录行列的行和列置为0
            for (i = 0; i < matrix.length; i++) {
                matrix[i][col] = 0;
            }
            for (i = 0; i < matrix[0].length; i++) {
                matrix[row][i] = 0;
            }
        }
    }
}
