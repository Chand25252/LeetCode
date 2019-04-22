package solutions;

/*
    给定一个单链表 L：L0→L1→…→Ln-1→Ln ，
    将其重新排列后变为： L0→Ln→L1→Ln-1→L2→Ln-2→…
    你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
*/
/**
 * @author Chand
 * @date 2019-04-22 17:25:45
 */

public class Q143_Reorder_List {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return;
        }
        ListNode temp = head;
        ListNode nextHead = head;
        ListNode nextTail = null;
        while (nextHead.next != null && nextHead.next.next != null && nextHead != nextTail) {
            nextHead = nextHead.next;
            nextTail = getTailNode(nextHead);
            temp.next = nextTail;
            temp.next.next = nextHead;
            temp = temp.next.next;
        }
        System.out.println(head.val);
    }

    private ListNode getTailNode(ListNode node) {
        ListNode temp = node;
        while (temp.next.next != null) {
            temp = temp.next;
        }
        ListNode tail = temp.next;
        temp.next = null;
        return tail;
    }

    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

}
