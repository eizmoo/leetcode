package linkedlist;

/**
 * 合并两个有序链表
 */
public class MergeTwoLists {

    /**
     * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
     * 示例：
     * 输入：1->2->4, 1->3->4
     * 输出：1->1->2->3->4->4
     */

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // 结果node，返回时会跳过第一个无效值
        ListNode result = new ListNode(0);
        ListNode head = result;

        // 只有当l1和l2都不为空时才比对
        while (l1 != null && l2 != null) {
            // result加上val小的node
            if (l1.val > l2.val) {
                result.next = new ListNode(l2.val);
                l2 = l2.next;
            } else {
                result.next = new ListNode(l1.val);
                l1 = l1.next;
            }
            result = result.next;
        }

        if (l1 != null) {
            result.next = l1;
        } else {
            result.next = l2;
        }

        return head.next;
    }
}
