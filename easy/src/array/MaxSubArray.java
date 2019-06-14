package array;

/**
 * 最大子序和
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 */
public class MaxSubArray {

    /**
     * 判断sum[i-1] + a[i]是否大于a[i]来做选择
     *
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {

        int sum = nums[0];
        int n = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (n > 0) {
                // 当前数不小于0，累加，因为会对下面造成积极影响
                n += nums[i];
            } else {
                // 当前数小于0，直接舍弃
                n = nums[i];
            }
            // 如果负数，返回最大
            if (sum < n) {
                sum = n;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(new MaxSubArray().maxSubArray(nums));
    }
}
