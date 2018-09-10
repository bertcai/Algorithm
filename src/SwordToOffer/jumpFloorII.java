package SwordToOffer;// fn = fn-1 + fn-2 + ... f1+f0
// f0 = 1,f1 = 1,f2 = 1 + 1 = 2, f3 = 1 + 1 + 2
// f4 = f3 + 1 + 1 + 2 = 2f3
// f5 = f4 + f3 + 1 + 1 + 2 = 4f3
// fn = 2^(n-3)*f3

public class Solution {
    public int JumpFloorII(int target) {
        if (target == 0) {
            return 0;
        }
        if (target == 1) {
            return 1;
        }
        if (target == 2) {
            return 2;
        }
        if (target == 3) {
            return 4;
        }
        int factor = 1;
        for (int i = 4; i <= target; i++) {
            factor *= 2;
        }
        return (1 + 1 + 2) * factor;
    }
}

// js写法同理
// 思考思路同上一题，假设跳一级还剩n-1级，跳2级还剩n-2级...,跳n级还剩0级
// 故 fn = fn-1 + fn-2 + ... f1+f0