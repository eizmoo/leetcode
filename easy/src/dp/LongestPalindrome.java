package dp;

/**
 * 5. 最长回文子串
 */
public class LongestPalindrome {

    /**
     * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
     * <p>
     * 示例 1：
     * <p>
     * 输入: "babad"
     * 输出: "bab"
     * 注意: "aba" 也是一个有效答案。
     */
    public String longestPalindromeSlow(String s) {
        int length = s.length();

        if (s.length() <= 1) {
            return s;
        }

        int longestPalindrome = 1;
        String longestPalindromeStr = s.substring(0, 1);
        boolean[][] dp = new boolean[length][length];

        for (int r = 0; r < length; r++) {
            for (int l = 0; l < length; l++) {
                if (s.charAt(r) == s.charAt(l) && (r - l <= 2 || dp[l + 1][r - 1])) {
                    dp[l][r] = true;
                    if (r - l + 1 > longestPalindrome) {
                        longestPalindrome = r - l + 1;
                        longestPalindromeStr = s.substring(l, r + 1);
                    }
                }
            }
        }

        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                System.out.print(dp[i][j] ? "1  " : "0  ");
            }
            System.out.println();
        }

        return longestPalindromeStr;
    }

    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) return "";
        int max = 0, n = s.length();
        int left = 0, right = 0;
        //int len1 = 0, len2 = 0;
        for (int i = 0; i < n; i++) {
            int len1 = sol(s, i, i);
            int len2 = sol(s, i, i + 1);

            int len = Math.max(len1, len2);
            if (len > right - left) {
                left = i - (len - 1) / 2;
                right = i + len / 2;
            }

        }
        return s.substring(left, right + 1);
    }

    private int sol(String s, int left, int right) {
        int L = left, R = right;
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        return R - L - 1;
    }

    public static void main(String[] args) {
        String s = "abcbaa";
        System.out.println("result:" + new LongestPalindrome().longestPalindrome(s));
    }

}
