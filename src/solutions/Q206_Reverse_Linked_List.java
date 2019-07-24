package solutions;

/*
    反转一个单链表。
    示例:
        输入: 1->2->3->4->5->NULL
        输出: 5->4->3->2->1->NULL
*/

/**
 * @author Chand
 * @Date: 2019-07-18 15:02:55
 */
public class Q206_Reverse_Linked_List {
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode node = head;
        ListNode result = partition(head);
        node.next = null;
        return result;
    }

    private ListNode partition(ListNode node) {
        if (node.next == null) {
            return node;
        }
        ListNode head = partition(node.next);
        ListNode temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        node.next = null;
        temp.next = node;
        return head;
    }

    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }
}
