package array;

import javafx.util.Pair;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * 求众数
 */
public class MajorityElement {

    /**
     * 给定一个大小为 n 的数组，找到其中的众数。众数是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
     * <p>
     * 你可以假设数组是非空的，并且给定的数组总是存在众数。
     */
    public int majorityElement1(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int length = nums.length;
        int majority = length / 2;
        Map<Integer, Integer> resultSum = new HashMap<>(length);

        for (int i : nums) {
            if (resultSum.containsKey(i)) {
                resultSum.put(i, resultSum.get(i) + 1);
            } else {
                resultSum.put(i, 1);
            }
        }


//        Pair<Integer, Integer> max = new Pair<>();
        resultSum.forEach((k, v) -> {
//            if ()
        });
        return 0;
    }

    public static void main(String[] args) {
        int[] nums = {2, 2, 1, 1, 1, 2, 2};
        System.out.println(new MajorityElement().majorityElement2(nums));
    }

    public int majorityElement2(int[] nums) {
        int res = 0, cnt = 0;
        for (int num : nums) {
            if (cnt == 0) {
                res = num;
                ++cnt;
            } else if (num == res) {
                ++cnt;
            } else {
                --cnt;
            }
        }
        return res;
    }
}
