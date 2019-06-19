package string;

/**
 * 二进制求和
 */
public class AddBinary {
    /**
     * 给定两个二进制字符串，返回他们的和（用二进制表示）。
     * <p>
     * 输入为非空字符串且只包含数字 1 和 0。
     * 示例 1:
     * <p>
     * 输入: a = "11", b = "1"
     * 输出: "100"
     */
    public String addBinary(String a, String b) {
        StringBuilder result = new StringBuilder();
        int aIndex = a.length() - 1;
        int bIndex = b.length() - 1;
        int sum = 0;

        while (aIndex >= 0 || bIndex >= 0) {
            if (aIndex >= 0) {
                sum += Integer.valueOf(String.valueOf(a.charAt(aIndex)));
                aIndex--;
            }
            if (bIndex >= 0) {
                sum += Integer.valueOf(String.valueOf(b.charAt(bIndex)));
                bIndex--;
            }
            // 进位
            if (sum == 2) {
                result.append(0);
                sum = 1;
            } else if (sum < 2) {
                result.append(sum);
                sum = 0;
            } else if (sum == 3) {
                result.append(1);
                sum = 1;
            }
        }
        if (sum == 1) {
            result.append(1);
        }
        return result.reverse().toString();
    }

    public static void main(String[] args) {
        String a = "1010";
        String b = "1011";
        System.out.println(new AddBinary().addBinary(a, b));
    }

}
