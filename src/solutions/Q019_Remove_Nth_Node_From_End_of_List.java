package solutions;

/*
    给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
    说明：给定的 n 保证是有效的。
*/

/**
 * @author Chand
 * @date 2019-03-15 11:55:41
 */
public class Q019_Remove_Nth_Node_From_End_of_List {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int i = partition(head, n);
        if(i == n - 1) {
            return head.next;
        }
        return head;
    }

    private int partition(ListNode node, int n) {
        if(node.next == null) {
            return 0;
        }
        int i = partition(node.next, n);
        i++;
        if(i == n) {
            ListNode temp = node.next.next;
            node.next = temp;
        }
        return i;
    }

    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }
}
