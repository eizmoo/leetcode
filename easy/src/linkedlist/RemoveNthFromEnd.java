package linkedlist;

/**
 * 19. 删除链表的倒数第N个节点
 */
public class RemoveNthFromEnd {
    // 双指针

    /**
     * 慢
     *
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || head.next == null) {
            return null;
        }

        ListNode fast = head;
        ListNode slow = head;

        // 快指针先移动n次
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }

        // 删除头指针
        if (fast == null) {
            return head.next;
        }

        // fast和slow同步前进，fast走到尽头时，slow就是要删除的值
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        // 删除slow节点的下一节点
        deleteNode(slow);
        return head;
    }

    private void deleteNode(ListNode node) {
        if (node.next.next == null) {
            node.next = null;
        } else {
            node.next.val = node.next.next.val;
            node.next.next = node.next.next.next;
        }
    }


    /**
     * 快了一倍
     *
     * @param head
     * @param n
     * @return
     */

    public ListNode removeNthFromEnd1(ListNode head, int n) {
        ListNode fast = head;
        ListNode slow = head;

        // 快指针先移动n次
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }

        // 删除头指针
        if (fast == null) {
            return head.next;
        }

        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;

        return head;
    }
}
