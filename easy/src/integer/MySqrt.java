package integer;

/**
 * x 的平方根
 */
public class MySqrt {

    /**
     * 实现 int sqrt(int x) 函数。
     * <p>
     * 计算并返回 x 的平方根，其中 x 是非负整数。
     * <p>
     * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
     * <p>
     * 示例 1:
     * <p>
     * 输入: 4
     * 输出: 2
     *
     * @param x
     * @return
     */

    /**
     * 二分
     *
     * @param x
     * @return
     */
    public int mySqrt0(int x) {
        if (x <= 1) {
            return 0;
        }
        // 二分的左右值
        int low = 0, high = x;
        // 最终的结果
        int ans = 0;

        // 左右值合理
        while (low <= high) {
            // 中位值
            int mid = (low + high) / 2;

            if (mid <= x / mid) {
                // 平方根小于期望值，跳右区间
                // 记录结果值
                ans = mid;
                low = mid + 1;
            } else if (mid > x / mid) {
                // 平方根大于期望值，跳左区间
                high = mid - 1;
            }
        }
        return ans;
    }

    int target;

    /**
     * 牛顿迭代法
     *
     * @param x
     * @return
     */
    public int mySqrt(int x) {
        target = x;
        if (x == 0) {
            return x;
        }
        return (int) sqrts(x);
    }

    private double sqrts(double x) {
        double res = (x + target / x) / 2;
        if (res == x) {
            return res;
        } else {
            return sqrts(res);
        }
    }

    public static void main(String[] args) {
        System.out.println(new MySqrt().mySqrt(4));
    }
}
