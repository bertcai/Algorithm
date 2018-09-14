package LeetCode.PrimaryAlgorithm.Array;

/**
 * 判断一个 9x9 的数独是否有效。只需要根据以下规则，验证已经填入的数字是否有效即可。
 * <p>
 * 数字 1-9 在每一行只能出现一次。
 * 数字 1-9 在每一列只能出现一次。
 * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
 * <p>
 * 数独部分空格内已填入了数字，空白格用 '.' 表示。
 */

/**
 * 解题思路
 * <p>
 * 使用3个二维数组，rows、cols、boxs分别用来存储行、列、子九宫格的情况
 * 其中一维下标 n 对于3个二维数组分别表示：第 n 行，第 n 列，第 n 个子九宫格
 * 其中二维下标 m 对于3个二维数组分别表示：在当前行、列、子九宫格的数字m
 * 二维数组中的值则表示：该数字出现的次数（在本题中次数超过 1 次即代表重复）
 * 举例：rows[2][5] = 1，第 2 行中数字 5 出现了 1 次
 */
public class IsValidSudoku {
    static class Solution {
        public boolean isValidSudoku(char[][] board) {
            int[][] rows = new int[9][9];
            int[][] cols = new int[9][9];
            int[][] boxs = new int[9][9];

            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board.length; j++) {
                    if (board[i][j] != '.') {
                        int num = board[i][j] - '0' - 1;
                        int k = i / 3 * 3 + j / 3;
                        if (rows[i][num] == 1 || cols[j][num] == 1 ||
                                boxs[k][num] == 1) {
                            return false;
                        }
                        rows[i][num] = cols[j][num] = boxs[k][num] = 1;
                    }
                }
            }
            return true;
        }
    }
}
