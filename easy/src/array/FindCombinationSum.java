package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * 39. 组合总和
 */
public class FindCombinationSum {

    List<List<Integer>> res = new ArrayList<>();
    private int[] candidates;
    int len;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates.length == 0) {
            return res;
        }

        Arrays.sort(candidates);
        this.len = candidates.length;
        this.candidates = candidates;
        findCombinationSum(target, 0, new Stack<>());

        return res;
    }

    /**
     * 回溯法
     *
     * @param residue
     * @param start
     * @param pre
     */
    private void findCombinationSum(int residue, int start, Stack<Integer> pre) {
        if (residue == 0) {
            res.add(new ArrayList<>(pre));
            return;
        }

        // 剪枝
        for (int i = start; i < len && residue - candidates[i] >= 0; i++) {
            pre.add(candidates[i]);
            findCombinationSum(residue - candidates[i], i, pre);
            pre.pop();
        }
    }

    public static void main(String[] args) {
        int[] canditates = {3, 2, 5, 7};
        int target = 7;
        System.out.println(new FindCombinationSum().combinationSum(canditates, target));
    }

}
