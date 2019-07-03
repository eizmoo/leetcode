package string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 17. 电话号码的字母组合
 */
public class LetterCombinations {

    /**
     * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
     * <p>
     * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
     * <p>
     * 输入："23"
     * 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
     */
    private final static Map<Character, String> PHONE = new HashMap<Character, String>() {{
        put('2', "abc");
        put('3', "def");
        put('4', "ghi");
        put('5', "jkl");
        put('6', "mno");
        put('7', "pqrs");
        put('8', "tuv");
        put('9', "wxyz");
    }};

    List<String> output = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        if (digits.length() != 0) {
            backtrack("", digits);
        }
        return output;
    }

    private void backtrack(String combination, String nextDigits) {
        if (nextDigits.length() == 0) {
            // 递归返回条件
            output.add(combination);
        } else {
            // 下一个数字对应的字母str
            String letters = PHONE.get(nextDigits.charAt(0));
            for (int i = 0; i < letters.length(); i++) {
                String letter = String.valueOf(letters.charAt(i));
                backtrack(combination + letter, nextDigits.substring(1));
            }
        }
    }

    public List<String> function(String digits) {
        List<String> str1 = new ArrayList<>();
        List<String> str2 = new ArrayList<>();

        if (digits.length() == 0) {
            return str1;
        }

        str1.add("");

        for (int i = 0; i < digits.length(); i++) {
            String letters = PHONE.get(digits.charAt(i));
            for (int k = 0; k < str1.size(); k++) {
                String s = str1.get(k);
                for (int j = 0; j < letters.length(); j++) {
                    str2.add(s + letters.charAt(j));
                }
            }
            str1 = str2;
            str2 = new ArrayList<>();
        }

        return str1;
    }

    public List<String> letterCombinations1(String digits) {
        List<String> arr1 = new ArrayList<>();
        List<String> arr2 = new ArrayList<>();
        // List<String> result;
        if(digits == null || digits.length() == 0) { return arr1;}
        arr1.add("");
        for(int i = 0; i<digits.length(); i++) {
            String tmpChar = PHONE.get(digits.charAt(i));
            for(int j=0; j<arr1.size(); j++) {
                for(int k=0; k<tmpChar.length(); k++) {
                    String str = arr1.get(j) + tmpChar.charAt(k);
                    arr2.add(str);
                }
            }
            arr1 = arr2;
            arr2 = new ArrayList<>();
        }
        return arr1;
    }

    private String getCharByNum(char ch) {
        String result;
        switch(ch) {
            case '2':
                result = "abc";
                break;
            case '3':
                result = "def";
                break;
            case '4':
                result = "ghi";
                break;
            case '5':
                result = "jkl";
                break;
            case '6':
                result = "mno";
                break;
            case '7':
                result = "pqrs";
                break;
            case '8':
                result = "tuv";
                break;
            case '9':
                result = "wxyz";
                break;
            default:
                result = "";
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new LetterCombinations().function("23"));
    }

}
