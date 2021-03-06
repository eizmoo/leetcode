package array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * 46. 全排列
 */
public class Permute {
    /**
     * 给定一个没有重复数字的序列，返回其所有可能的全排列。
     * <p>
     * 示例:
     * <p>
     * 输入: [1,2,3]
     * 输出:
     * [
     * [1,2,3],
     * [1,3,2],
     * [2,1,3],
     * [2,3,1],
     * [3,1,2],
     * [3,2,1]
     * ]
     */


    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> output = new LinkedList<>();

        ArrayList<Integer> nums_lst = new ArrayList<>();
        for (int num : nums) {
            nums_lst.add(num);
        }

        int n = nums.length;
        backtrack(n, nums_lst, output, 0);
        return output;
    }

    public void backtrack(int n, ArrayList<Integer> nums, List<List<Integer>> output, int first) {
        if (first == n) {
            output.add(new ArrayList<>(nums));
        }

        for (int i = first; i < n; i++) {
            Collections.swap(nums, first, i);
            backtrack(n, nums, output, first + 1);
            Collections.swap(nums, first, i);
        }
    }
}
