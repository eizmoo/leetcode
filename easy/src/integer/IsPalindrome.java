package integer;

/**
 * 回文数
 */
public class IsPalindrome {

    // 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。

    public boolean isPalindromeOld(int x) {

        char[] c = String.valueOf(x).toCharArray();
        int length = c.length;

        for (int i = 0; i < length / 2; i++) {
            int j = length - i - 1;
            if (c[i] != c[j]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new IsPalindrome().isPalindrome(1222));
    }

    public boolean isPalindrome(int x) {
        // 所有的负数不为回文
        // 10的倍数只有0是回文
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        int revertedNumber = 0;
        while (x > revertedNumber) {
            revertedNumber = revertedNumber * 10 + x % 10;
            x /= 10;
        }

        return x == revertedNumber || x == revertedNumber / 10;
    }

}
