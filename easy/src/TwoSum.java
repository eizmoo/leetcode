import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    /**
     * 给定一个整数数组和一个目标值，找出数组中和为目标值的两个数。
     * <p>
     * 你可以假设每个输入只对应一种答案，且同样的元素不能被重复利用。
     * <p>
     * 示例:
     * <p>
     * 给定 nums = [2, 7, 11, 15], target = 9
     * <p>
     * 因为 nums[0] + nums[1] = 2 + 7 = 9
     * 所以返回 [0, 1]
     */

    public static void main(String[] args) {

    }

    public int[] twoSum(int[] nums, int target) {

        int[] result = new int[2];

        //余数map，key是每个数字与target相差的数值，value是这个数字的下标
        Map<Integer, Integer> remainder = new HashMap<>(16);

        for (int i = 0; i < nums.length; i++) {
            //如果key有匹配的值，证明找到
            if (remainder.containsKey(nums[i])) {
                result[0] = i;
                result[1] = remainder.get(nums[i]);
                return result;
            }
            //不存在，将这个值存入余数map中
            remainder.put(target - nums[i], i);
        }

        return null;
    }
}
