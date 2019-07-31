package array;

/**
 * 33. 搜索旋转排序数组
 */
public class Search {

    /**
     * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
     * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
     * 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
     * 你可以假设数组中不存在重复的元素。
     * <p>
     * 你的算法时间复杂度必须是 O(log n) 级别。
     * <p>
     * 示例 1:
     * 输入: nums = [4,5,6,7,0,1,2], target = 0
     * 输出: 4
     * <p>
     * 示例 2:
     * 输入: nums = [4,5,6,7,0,1,2], target = 3
     * 输出: -1
     */

    public int search(int[] nums, int target) {
        int start = 0, end = nums.length - 1;

        while (start <= end) {
            if (nums[start] == target) {
                return start;
            }
            if (nums[end] == target) {
                return end;
            }

            int middle = (start + end) / 2;
            if (nums[middle] == target) {
                return middle;
            }

            // 判断旋转点位置在中值前还是中值后
            if (nums[start] > nums[middle]) {
                // 旋转点在中值前
                // 判断目标值在哪个区间
                if (target > nums[middle] && target < nums[start]) {
                    // 目标值大于中值，小于起始值，在右区间。移动start
                    start = middle + 1;
                } else {
                    end = middle - 1;
                }
            } else {
                // 旋转点在中值后
                // 判断目标值在哪个区间
                if (target > nums[start] && target < nums[middle]) {
                    end = middle - 1;
                } else {
                    start = middle + 1;
                }
            }
        }

        return -1;
    }
}
