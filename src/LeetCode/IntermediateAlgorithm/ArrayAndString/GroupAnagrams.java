package LeetCode.IntermediateAlgorithm.ArrayAndString;

import java.util.*;

/**
 * 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
 */
public class GroupAnagrams {
    class Solution {
        public List<List<String>> groupAnagrams(String[] strs) {
            Map<String, List<String>> resultMap = new HashMap<>();
            for (String str : strs) {
                char[] temp = str.toCharArray();
                Arrays.sort(temp);
                String key = String.valueOf(temp);
                if (resultMap.containsKey(key)) {
                    resultMap.get(key).add(str);
                } else {
                    resultMap.put(key, new ArrayList<>());
                    resultMap.get(key).add(str);
                }
            }
            return new ArrayList<>(resultMap.values());
        }
    }
}
