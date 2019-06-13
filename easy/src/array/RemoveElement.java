package array;

/**
 * 移除元素
 */
public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        // 双指针 慢指针指向有效数组，快指针移动数字
        int i = 0, j = 0;

        for (; j < nums.length; j++) {
            // 判断数组快指针下标的元素是否是要被删除的
            if (nums[j] != val) {
                // 如果i小于j，证明中间有需要移除的数
                if (i < j) {
                    nums[i] = nums[j];
                }
                // 不是要删除，i自增
                i++;
            }
        }

        return i;
    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 2, 2, 3, 0, 4, 2};
        int val = 3;

        System.out.println(new RemoveElement().removeElement(nums, val));
        for (int num : nums) {
            System.out.println(num);
        }
    }
}
