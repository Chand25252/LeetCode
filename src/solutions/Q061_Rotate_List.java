package solutions;

/*
    给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。
*/

/**
 * @author Chand
 * @date 2019-03-27 16:57:54
 */
public class Q061_Rotate_List {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        ListNode temp = head;
        int i = 1;
        while (temp.next != null) {
            temp = temp.next;
            i++;
        }
        k = k % i;
        if (k == 0) {
            return head;
        }
        temp = head;
        ListNode newHead = new ListNode(0);
        partition(temp, newHead, k);
        temp = newHead;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = head;
        return newHead;
    }

    private int partition(ListNode node, ListNode newHead, int k) {
        if (node == null) {
            return 0;
        }
        int position = partition(node.next, newHead, k);
        if (position == k) {
            newHead.val = node.next.val;
            newHead.next = node.next.next;
            node.next = null;
        }
        return ++position;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
