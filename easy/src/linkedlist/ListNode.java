package linkedlist;

import java.util.Collection;

public class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }

    @Override
    public String toString() {
        ListNode node = this;
        StringBuilder builder = new StringBuilder();
        builder.append("_this:").append(node.val).append(" ");
        while (node.next != null) {
            node = node.next;
            builder.append("_next:").append(node.val).append(" ");
        }
        return builder.toString();
    }
}
