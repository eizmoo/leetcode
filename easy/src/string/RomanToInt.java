package string;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/**
 * 罗马数字转整数
 */
public class RomanToInt {

    /**
     * 字典
     */
    private static Map<Character, Integer> dictionaries = new LinkedHashMap<>();

    static {
        dictionaries.put('I', 1);
        dictionaries.put('V', 5);
        dictionaries.put('X', 10);
        dictionaries.put('L', 50);
        dictionaries.put('C', 100);
        dictionaries.put('D', 500);
        dictionaries.put('M', 1000);
    }

    public int romanToInt(String s) {
        if (s == null || s.length() == 0) {
            return -1;
        }

        char[] c = s.toCharArray();

        int len = s.length();
        int result = dictionaries.get(c[len - 1]);

        for (int i = len - 2; i >= 0; i--) {
            if (dictionaries.get(c[i]) >= dictionaries.get(c[i + 1])) {
                result += dictionaries.get(c[i]);
            } else {
                result -= dictionaries.get(c[i]);
            }
        }
        return result;
    }


}
