package solutions;


/*
    给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
    你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
*/

/**
 * @author Chand
 * @date 2019-03-18 15:50:12
 */
public class Q024_Swap_Nodes_in_Pairs {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode result = head.next;
        ListNode preNode = null;
        while(head != null && head.next != null) {
            ListNode temp = head.next;
            head.next = head.next.next;
            temp.next = head;
            if(preNode != null) {
                preNode.next = temp;
            }
            preNode = temp.next;
            head = head.next;
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
