package array;

/**
 * 11. 盛最多水的容器
 */
public class MaxArea {

    /**
     * 给定 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。
     * 在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
     * <p>
     * 说明：你不能倾斜容器，且 n 的值至少为 2。
     */
    public int maxArea(int[] height) {
        // 左右指针
        int i = 0, j = height.length - 1;

        int max = 0;

        while (i < j) {
            boolean isLeftLess = height[i] < height[j];
            // 最大值为 a.i 和 a.j 小值 * 区间
            max = Math.max(max, (isLeftLess ? height[i] : height[j]) * (j - i));

            if (isLeftLess) {
                i++;
            } else {
                j--;
            }
        }
        return max;
    }

    /**
     * 执行用时 :6 ms, 在所有 Java 提交中击败了75.33%的用户
     * 内存消耗 :44.4 MB, 在所有 Java 提交中击败了68.62%的用户
     */

}
