package LeetCode.PrimaryAlgorithm.Array;

public class Test {
    public static void main(String[] args) {
        PlusOne plusOne = new PlusOne();
        Boolean ret = new IsValidSudoku.Solution().isValidSudoku(new
                char[][]{{'1'}});
        System.out.println(ret);
    }
}
