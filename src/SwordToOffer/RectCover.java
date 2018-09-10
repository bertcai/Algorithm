package SwordToOffer;

// 依旧是斐波那契数列，这种类型的问题，都是从小往大分解，找规律。
// js写法同最初
public class Solution {
    public int RectCover(int target) {
        if (target == 0) {
            return 0;
        }
        if (target == 1) {
            return 1;
        }
        if (target == 2) {
            return 2;
        }
        int fibMin = 1;
        int fibMax = 2;
        int fibN = 0;
        for (int i = 2; i < target; i++) {
            fibN = fibMin + fibMax;
            fibMin = fibMax;
            fibMax = fibN;
        }
        return fibN;
    }
}