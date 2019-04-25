package array;

public class PlusOne {

    /**
     * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
     * <p>
     * 最高位数字存放在数组的首位， 数组中每个元素只存储一个数字。
     * <p>
     * 你可以假设除了整数 0 之外，这个整数不会以零开头。
     */

    public int[] plusOne(int[] digits) {
        int n = digits.length;
        for (int i = digits.length - 1; i >= 0; --i) {
            if (digits[i] < 9) {
                ++digits[i];
                return digits;
            }
            digits[i] = 0;
        }
        int[] res = new int[n + 1];
        res[0] = 1;
        return res;
    }

    public static void main(String[] args) {
        int[] a = {1, 9};

        int[] b = new PlusOne().plusOne(a);

        for (int i : b) {
            System.out.println(i);
        }

    }

}
