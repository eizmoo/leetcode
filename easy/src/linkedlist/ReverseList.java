package linkedlist;

/**
 * 206. 反转链表
 */
public class ReverseList {

    /**
     * 递归实现
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        } else {
            ListNode newNode = reverseList(head.next);
            head.next.next = head;
            head.next = null;
            return newNode;
        }
    }

}
