package LeetCode.PrimaryAlgorithm.DynamicProgramming;

/**
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * <p>
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * <p>
 * 注意：给定 n 是一个正整数。
 */
public class ClimbStairs {
    class Solution {
        public int climbStairs(int n) {
            if(n==1){
                return 1;
            }
            if(n==2){
                return 2;
            }
            int f1 = 1;
            int f2 = 2;
            int result = 0;
            for(int i=3;i<=n;i++){
                result = f1+f2;
                f1 = f2 ;
                f2 = result;
            }
            return result;
        }
    }
}
