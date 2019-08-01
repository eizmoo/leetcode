package array;

/**
 * 34. 在排序数组中查找元素的第一个和最后一个位置
 */
public class SearchRange {
    /**
     * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
     *
     * 你的算法时间复杂度必须是 O(log n) 级别。
     *
     * 如果数组中不存在目标值，返回 [-1, -1]。
     *
     * 示例 1:
     *
     * 输入: nums = [5,7,7,8,8,10], target = 8
     * 输出: [3,4]
     */

    public int[] searchRange(int[] nums, int target) {
        int[] result = {-1, -1};

        if (nums == null || nums.length == 0) {
            return result;
        }

        int start = 0, end = nums.length - 1;
        int targetIndex = -1;

        while (start <= end) {
            if (nums[start] == target) {
                targetIndex = start;
                break;
            }
            if (nums[end] == target) {
                targetIndex = end;
                break;
            }

            int middle = end + (start - end) / 2;
            if (nums[middle] == target) {
                targetIndex = middle;
                break;
            } else if (nums[middle] > target) {
                end = middle - 1;
            } else if (nums[middle] < target) {
                start = middle + 1;
            }
        }

        if (targetIndex >= 0) {
            int s = targetIndex;
            while (s >= 0 && nums[s] == target) {
                s--;
            }

            int e = targetIndex;
            while (e < nums.length && nums[e] == target) {
                e++;
            }

            result[0] = s + 1;
            result[1] = e - 1;
        }
        return result;
    }
}
