package new_start_in_2020.between_300_and_399;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Intersect_350
 *
 * @author liuwei06
 * @date 2020/02/21
 */
public class Intersect_350 {

    /**
     * https://leetcode-cn.com/problems/intersection-of-two-arrays-ii/
     * 给定两个数组，编写一个函数来计算它们的交集。
     * in  : [1,2,2,3] [2,2]
     * out : [2,2]
     */
    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1.length < nums2.length) {
            return intersect(nums2, nums1);
        }
        HashMap<Integer, Integer> nums1Map = new HashMap<>(nums1.length);
        for (Integer currentNum : nums1) {
            nums1Map.put(currentNum, nums1Map.getOrDefault(currentNum, 0) + 1);
        }

        List<Integer> result = new ArrayList<>();
        for (int currentNum : nums2) {
            if (nums1Map.containsKey(currentNum)) {
                result.add(currentNum);
                Integer sum = nums1Map.get(currentNum);
                if (sum == 1) {
                    nums1Map.remove(currentNum);
                } else {
                    nums1Map.put(currentNum, sum - 1);
                }
            }
        }
        return list2Array(result);
    }

    private int[] list2Array(List<Integer> result) {
        int[] resArray = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            resArray[i] = result.get(i);
        }
        return resArray;
    }
}
