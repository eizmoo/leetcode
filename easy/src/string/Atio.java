package string;

/**
 * 字符串转换整数 (atoi)
 * https://leetcode-cn.com/problems/string-to-integer-atoi/
 */
public class Atio {


    public int myAtoi(String str) {
        // str长度为0直接返回0
        if (str.length() == 0) {
            return 0;
        }

        // 去除首部空格
        str = str.trim();
        char[] charArray = str.toCharArray();
        // 是否有字符
        if (charArray.length == 0) {
            return 0;
        }
        //　第一个字符
        char symbol = charArray[0];

        // 是否负数
        boolean isNegative = false;
        int start = 0;

        // 判断第一个字符
        if (symbol == '-') {
            // 字符等于负号，字符串有效，结果值为负值
            // 设置负数flag
            isNegative = true;
            // 统计开始值
            start++;
            // 如果没有后续值
            if (start >= str.length()) {
                return 0;
            }
        } else if (symbol == '+') {
            // 统计开始值
            start++;
            // 如果没有后续值
            if (start >= str.length()) {
                return 0;
            }
        } else if (!validNumber(symbol)) {
            // 第一个字符不是有效字符，此字符串无效
            return 0;
        }

        //　最终结果
        int result = 0;

        // 循环str，退出条件为下一个字符无效
        while (start < str.length() && validNumber(charArray[start])) {
            // 下一个字符的值int
            int v = charArray[start] - '0';

            // 结果值为上一轮结果×10+此字符int值
            int temp = result * 10 + v;
            // 如果溢出
            if (result > (Integer.MAX_VALUE - v) / 10) {
                return isNegative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            } else {
                result = temp;
            }
            start++;
        }

        return isNegative ? 0 - result : result;
    }

    /**
     * 　字符是否是有效数字
     */
    private boolean validNumber(char c) {
        return c >= 48 && c <= 57;
    }


    public static void main(String[] args) {
        System.out.println(new Atio().myAtoi("-6147483648"));
    }

    public int myAtoi1(String str) {
        str = str.trim();
        int result = 0;
        boolean isPos = true;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (i == 0 && (c == '-' || c == '+')) {
                isPos = c == '+' ? true : false;
            } else if (c >= '0' && c <= '9') {
                // 检查溢出情况
                if (result > (Integer.MAX_VALUE - (c - '0')) / 10) {
                    return isPos ? Integer.MAX_VALUE : Integer.MIN_VALUE;
                }
                result *= 10;
                result += c - '0';
            } else {
                return isPos ? result : -result;
            }
        }
        return isPos ? result : -result;
    }
}
