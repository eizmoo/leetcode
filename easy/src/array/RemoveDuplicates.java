package array;

public class RemoveDuplicates {
    /**
     * 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
     * <p>
     * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
     * <p>
     * 示例 1:
     * <p>
     * 给定数组 nums = [1,1,2],
     * <p>
     * 函数应该返回新的长度 2, 并且原数组 nums 的前两个元素被修改为 1, 2。
     * <p>
     * 你不需要考虑数组中超出新长度后面的元素。
     * 示例 2:
     * <p>
     * 给定 nums = [0,0,1,1,1,2,2,3,3,4],
     * <p>
     * 函数应该返回新的长度 5, 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4。
     * <p>
     * 你不需要考虑数组中超出新长度后面的元素。
     */

    public int removeDuplicates(int[] nums) {
        //快慢指针
        int slow = 0, fast = 1;
        //只要fast没有到数组的末尾
        while (fast < nums.length) {
            //如果两个指针指向的数字不同
            if (nums[slow] != nums[fast]) {
                //慢指针+1
                slow++;
                //将不同的数字复制到slow的下一个位置上
                nums[slow] = nums[fast];
            }
            //不管数字是否相同，快指针都要+1
            fast++;
        }
        return slow + 1;
    }
}
