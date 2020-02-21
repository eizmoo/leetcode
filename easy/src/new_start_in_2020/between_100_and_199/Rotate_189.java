package new_start_in_2020.between_100_and_199;

import java.util.Arrays;

/**
 * Rotate_189
 *
 * @author liuwei06
 * @date 2020/02/19
 */
public class Rotate_189 {

    /**
     * https://leetcode-cn.com/problems/rotate-array/
     * 旋转数组
     * in  : [1,2,3] 1
     * out : [3,1,2]
     *
     * @param nums
     * @param k
     */
    // 环装替代
    public static void rotate1(int[] nums, int k) {
        k = k % nums.length;
        int count = 0;
        for (int start = 0; count < nums.length; start++) {
            int current = start;
            int prev = nums[start];
            do {
                int next = (current + k) % nums.length;
                int temp = nums[next];
                nums[next] = prev;
                prev = temp;
                current = next;
                count++;
            } while (start != current);
        }
    }

    // 使用反转
    public static void rotate2(int[] nums, int k) {
        k = k % nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    private static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        int k = 1;
        rotate1(nums, k);
        Arrays.stream(nums).forEach(System.out::println);
    }

}
