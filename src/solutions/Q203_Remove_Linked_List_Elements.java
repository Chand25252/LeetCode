package solutions;


/*删除链表中等于给定值 val 的所有节点。*/

/**
 * @author Chand
 * @Date: 2019-07-04 14:15:28
 */
public class Q203_Remove_Linked_List_Elements {
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return head;
        }
        while (head != null && head.val == val) {
            head = head.next;
        }
        ListNode result = head;
        while (head != null && head.next != null) {
            if(head.next.val == val) {
                head.next = head.next.next;
            } else {
                head = head.next;
            }
        }
        return result;
    }

    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }
}
