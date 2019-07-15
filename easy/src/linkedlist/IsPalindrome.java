package linkedlist;

import java.util.Stack;

/**
 * 回文链表
 */
public class IsPalindrome {

    /**
     * 请判断一个链表是否为回文链表。
     *
     * 示例 1:
     *
     * 输入: 1->2
     * 输出: false
     * 示例 2:
     *
     * 输入: 1->2->2->1
     * 输出: true
     * 进阶：
     * 你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
     */

    public boolean isPalindrome(ListNode head) {
        Stack<Integer> stack = new Stack<>();

        ListNode slow = head;
        ListNode quick = head;
        while (quick != null && quick.next != null) {
            stack.push(slow.val);
            slow = slow.next;
            quick = quick.next.next;
        }
        if (quick != null) {
            slow = slow.next;
        }

        while (slow != null) {
            if (stack.pop() != slow.val) {
                return false;
            }
            slow = slow.next;
        }
        return true;
    }
}
