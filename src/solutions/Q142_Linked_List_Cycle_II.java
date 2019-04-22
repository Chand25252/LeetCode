package solutions;

/*
    给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
    为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。
    说明：
        不允许修改给定的链表。
    进阶：
        你是否可以不用额外空间解决此题？
*/

/**
 * @author Chand
 * @date 2019-04-22 16:21:16
 */
public class Q142_Linked_List_Cycle_II {
    public ListNode detectCycle(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == head) {
            return head;
        }
        ListNode i = head;
        ListNode j = head.next;
        while (true) {
            if (j == null || j.next == null || i == null) {
                return null;
            }
            if (i == j) {
                break;
            }
            i = i.next;
            j = j.next.next;
        }
        while (true) {
            i = i.next;
            if (i == j) {
                return i;
            }
            while (i != j) {
                if (head == i) {
                    return head;
                }
                i = i.next;
            }
            head = head.next;
        }
    }

    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

}
