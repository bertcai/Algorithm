package LeetCode.PrimaryAlgorithm.Array;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个整数数组和一个目标值，找出数组中和为目标值的两个数。
 * <p>
 * 你可以假设每个输入只对应一种答案，且同样的元素不能被重复利用。
 */
public class TwoSum {
    static class Solution {
        public int[] twoSum(int[] nums, int target) {
            for (int i = 0; i < nums.length; i++) {
                    for (int j = i + 1; j < nums.length; j++) {
                        if ((nums[j] + nums[i]) == target) {
                            return new int[]{i, j};
                        }
                    }
                }
            return new int[]{0, 0};
        }
    }

    /**
     * 使用Map解决
     */
    class Solution2 {
        public int[] twoSum(int[] nums, int target) {
            Map<Integer,Integer> map = new HashMap<Integer,Integer>();
            int i=0;

            for(int num : nums){
                Integer r = map.get(target - num);
                if(r!=null){
                    int[] result = new int[2];
                    result[0] = r;
                    result[1] = i;
                    return result;
                }else{
                    map.put(num,i);
                }
                i++;
            }
            return null;
        }
    }
}
