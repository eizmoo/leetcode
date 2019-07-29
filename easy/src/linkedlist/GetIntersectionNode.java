package linkedlist;

/**
 * 160. 相交链表
 */
public class GetIntersectionNode {
    /**
     * 编写一个程序，找到两个单链表相交的起始节点。
     * 注意：
     * <p>
     * 如果两个链表没有交点，返回 null.
     * 在返回结果后，两个链表仍须保持原有的结构。
     * 可假定整个链表结构中没有循环。
     * 程序尽量满足 O(n) 时间复杂度，且仅用 O(1) 内存。
     */

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }

        ListNode a = headA;
        ListNode b = headB;

        // 判断相交
        int aLength = 0, bLength = 0;

        // 走到倒数第一个节点位置
        while (headA != null && headA.next != null) {
            aLength++;
            headA = headA.next;
        }

        // 走到倒数第一个节点位置
        while (headB != null && headB.next != null) {
            bLength++;
            headB = headB.next;
        }

        // 如果最后一个节点不相同，证明不相交
        if (headA != headB) {
            return null;
        }

        // 相交，判断交点
        int differLength = 0;
        boolean isAMax = aLength > bLength;

        // a的长度更长，a向前走
        if (isAMax) {
            for (int i = 0; i < aLength - bLength; i++) {
                a = a.next;
            }
        } else {
            for (int i = 0; i < bLength - aLength; i++) {
                b = b.next;
            }
        }

        // 两个指针同时前进，遇到的第一个相同的节点即为交点
        while (a != b) {
            a = a.next;
            b = b.next;
        }
        return a;
    }
}
