package string;

import java.util.ArrayList;
import java.util.List;

/**
 * 22. 括号生成
 */
public class GenerateParenthesis {

    /**
     * 给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
     * <p>
     * 例如，给出 n = 3，生成结果为：
     * <p>
     * [
     * "((()))",
     * "(()())",
     * "(())()",
     * "()(())",
     * "()()()"
     * ]
     */


    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backtrack(result, "", 0, 0, n);
        return result;
    }

    private void backtrack(List<String> result, String cur, int open, int close, int max) {

        if (open + close == max * 2) {
            result.add(cur);
            return;
        }

        if (open < max) {
            backtrack(result, cur + "(", open + 1, close, max);
        }
        if (close < open) {
            backtrack(result, cur + ")", open, close + 1, max);
        }
    }

    public static void main(String[] args) {
        System.out.println(new GenerateParenthesis().generateParenthesis(3));
    }
}
