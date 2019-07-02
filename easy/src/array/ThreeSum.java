package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 15. 三数之和
 */
public class ThreeSum {

    /**
     * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
     * <p>
     * 注意：答案中不可以包含重复的三元组。
     * <p>
     * 例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
     * <p>
     * 满足要求的三元组集合为：
     * [
     * [-1, 0, 1],
     * [-1, -1, 2]
     * ]
     *
     * @param nums
     * @return
     */

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);

        List<List<Integer>> result = new ArrayList<>();

        if (nums.length == 0 || nums[0] > 0) {
            return result;
        }
        if (nums[0] == 0) {
            if (nums.length >= 3 && nums[nums.length - 1] == 0) {
                List<Integer> list = new ArrayList<>();
                list.add(0);
                list.add(0);
                list.add(0);
                result.add(list);
            }
            return result;
        }

        for (int i = 0; i < nums.length; i++) {
            // 如果本次和上次的值相同，结果集将会是同一组，跳过
            if (i != 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int num = nums[i];
            int left = i + 1;
            int right = nums.length - 1;

            int target = 0 - num;

            while (left < right) {
                if ((nums[left] + nums[right]) == target) {
                    List<Integer> list = new ArrayList<>(3);
                    list.add(num);
                    list.add(nums[left]);
                    list.add(nums[right]);
                    result.add(list);

                    while (right > left && nums[left + 1] == nums[left]) {
                        left++;
                    }
                    while (right > left && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    left++;
                    right--;
                } else if (nums[left] + nums[right] > target) {
                    right--;
                } else {
                    left++;
                }
            }

        }

        return result;
    }

    public static void main(String[] args) {
//        int[] nums = {-1, 0, 1, 2, -1, -4};
        int[] nums = {};
        System.out.println(new ThreeSum().threeSum(nums));
    }

    /**
     * 执行用时 :74 ms, 在所有 Java 提交中击败了70.31%的用户
     * 内存消耗 :55.5 MB, 在所有 Java 提交中击败了73.26%的用户
     */
}
