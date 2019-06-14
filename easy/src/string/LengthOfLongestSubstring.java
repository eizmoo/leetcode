package string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 无重复字符的最长子串 -medium
 */
public class LengthOfLongestSubstring {
    /**
     * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
     * <p>
     * 示例 1:
     * <p>
     * 输入: "abcabcbb"
     * 输出: 3
     * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
     */

    /**
     * 暴力循环
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstringSlow(String s) {
        // 定义快慢指针
        int fastIndex = 0, slowIndex = 0;
        // 用来循环的数组
        char[] sArray = s.toCharArray();

        int max = 0;

        List<Character> characterList = new ArrayList<>();
        // 循环慢指针
        for (; slowIndex < sArray.length; slowIndex++) {
            int length = 0;
            for (; fastIndex < sArray.length; fastIndex++) {
                char c = sArray[fastIndex];
                // 如果重复字符
                if (characterList.contains(c)) {
                    // 快指针置为慢指针前一位
                    fastIndex = slowIndex + 1;
                    characterList.clear();
                    // 退出当前快指针循环
                    break;
                } else {
                    // 不重复字符
                    characterList.add(c);
                    length++;
                }
            }
            if (length > max) {
                max = length;
            }
        }
        return max;
    }


    /**
     * 滑动窗口
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        // 字典
        Map<Character, Integer> map = new HashMap<>(s.length());

        char[] sarray = s.toCharArray();

        // 最大值、窗口左边界
        int max = 0, left = 0;

        // 循环，每次移动的i为窗口的右边界，保留left为窗口左边界
        // 每次右边界移动一格，计算新格中的字符是否在当前窗口中，如果已出现，将左边界移动到此字符上出出现的位置+1
        //                [abcde]c --> (右边界移动)[abcdec] --> (左边接移动)abc[dec]
        // windowsLength     5                                              3
        //      max          5                                              5
        for (int i = 0; i < sarray.length; i++) {
            char c = sarray[i];
            if (map.containsKey(c)) {
                // 此字符上次出现的下标
                int index = map.get(c);
                // 如果left大于字符出现的下标，则此字符不在窗口内，不需要移动窗口左边界
                // index + 1 表示跳过此字符
                left = Math.max(left, index + 1);
            }
            // i - left + 1  为滑动窗口大小
            max = Math.max(max, i - left + 1);

            // 设置此字符的最近一次出现位置
            map.put(c, i);
        }
        return max;
    }

    public int l(String s) {
        int[] m = new int[256];

        int res = 0, left = 0;

        for (int i = 0; i < s.length(); i++) {
            left = Math.max(left, m[s.charAt(i)]);

            res = Math.max(res, i - left + 1);

            m[s.charAt(i)] = i + 1;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new LengthOfLongestSubstring().lengthOfLongestSubstring("aaaa"));
    }
}
