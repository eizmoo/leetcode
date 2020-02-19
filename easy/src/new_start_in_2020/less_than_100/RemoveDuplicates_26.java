package new_start_in_2020.less_than_100;

import java.util.Arrays;

/**
 * RemoveDuplicates_26
 *
 * @author liuwei06
 * @date 2020/02/18
 */
public class RemoveDuplicates_26 {

    /**
     * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/
     * 删除排序数组中的重复项
     * in  : [1,1,2]
     * out : 2
     *
     * @param nums 有序数组
     * @return
     */
    // 快慢指针
    public static int removeDuplicates(int[] nums) {
        int slow = 0, fast = 1;
        // 快指针达到最后一格时停止
        while (fast < nums.length) {
            // 快慢指针的两个值不相等时，慢指针移动一格
            if (nums[slow] != nums[fast]) {
                slow++;
                // 当快慢指针不是同一格子时，交换数字
                if (slow != fast) {
                    nums[slow] = nums[fast];
                }
            }
            // 每次循环快指针移动一格
            fast++;
        }
        return slow + 1;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 2};
        System.out.println(removeDuplicates(nums));
        Arrays.stream(nums).forEach(System.out::println);
    }

}
