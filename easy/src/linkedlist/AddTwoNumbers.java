package linkedlist;

import com.sun.org.apache.bcel.internal.generic.LNEG;

public class AddTwoNumbers {

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) { val = x; }
     * }
     */
    /**
     * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
     * <p>
     * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
     * <p>
     * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode head = new ListNode(-1);
        ListNode cur = head;

        int carry = 0;

        // 循环，直到两个链表都到了末尾
        while (l1 != null || l2 != null) {
            // 如果为null，则赋值0
            // 因为有可能存在l1为空但l2不为空
            int d1 = l1 == null ? 0 : l1.val;
            int d2 = l2 == null ? 0 : l2.val;

            // 计算总和，如果总和大于10，将进位置为1
            int sum = d1 + d2 + carry;
            carry = sum >= 10 ? 1 : 0;

            // 将sum赋值给cur.next，并向前走一步
            cur.next = new ListNode(sum % 10);
            cur = cur.next;

            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }

            System.out.println(cur.toString());
        }
        // 如果两个循环结束了而进位为1，则增加一位
        if (carry > 0) {
            cur.next = new ListNode(1);
        }
        // 返回开始的节点
        return head.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        System.out.println(new AddTwoNumbers().addTwoNumbers(l1, l2));
    }
}
