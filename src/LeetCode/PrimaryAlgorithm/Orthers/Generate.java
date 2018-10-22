package LeetCode.PrimaryAlgorithm.Orthers;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
 * <p>
 * 在杨辉三角中，每个数是它左上方和右上方的数的和
 */
public class Generate {
    class Solution {
        /**
         * 帕斯卡三角形
         *
         * @param numRows 行数
         * @return
         */
        public List<List<Integer>> generate(int numRows) {

            if (numRows < 0) {
                return null;
            }

            ArrayList<List<Integer>> resultList =
                    new ArrayList<List<Integer>>();

            if (numRows == 0) {
                return resultList;
            }

            //第一行
            ArrayList<Integer> firstList = new ArrayList<Integer>();
            firstList.add(1);
            resultList.add(firstList);

            //之后各行
            ArrayList<Integer> nextList = firstList;
            for (int i = 1; i < numRows; i++) {
                nextList = getNextArray(nextList);
                resultList.add(nextList);
            }

            return resultList;
        }

        /**
         * 给定帕斯卡三角形的一行数据，获取下一行数据
         *
         * @param array 帕斯卡三角形某一行
         * @return 帕斯卡三角形的下一行
         */
        public ArrayList<Integer> getNextArray(ArrayList<Integer> arrayList) {

            if (arrayList == null) {
                return null;
            }

            ArrayList<Integer> nextList = new ArrayList<Integer>();

            nextList.add(1);
            for (int i = 0; i + 1 < arrayList.size(); i++) {
                nextList.add(arrayList.get(i) + arrayList.get(i + 1));
            }
            nextList.add(1);

            return nextList;
        }
    }
}
