package solutions;

/*
    给定一个链表和一个特定值 x，对链表进行分隔，
    使得所有小于 x 的节点都在大于或等于 x 的节点之前。
    你应当保留两个分区中每个节点的初始相对位置。
*/

/**
 * @author Chand
 * @date 2019-04-03 17:16:43
 */
public class Q086_Partition_List {
    public ListNode partition(ListNode head, int x) {
        ListNode result = null;
        ListNode midTemp = null;
        ListNode maxNode = null;
        ListNode maxTemp = null;
        while (head != null) {
            if (head.val < x) {
                if (result == null) {
                    result = new ListNode(head.val);
                    midTemp = result;
                } else {
                    midTemp.next = new ListNode(head.val);
                    midTemp = midTemp.next;
                }
            } else {
                if (maxNode == null) {
                    maxNode = new ListNode(head.val);
                    maxTemp = maxNode;
                } else {
                    maxTemp.next = new ListNode(head.val);
                    maxTemp = maxTemp.next;
                }
            }
            head = head.next;
        }
        if (result == null) {
            return maxNode;
        }
        midTemp = result;
        while (midTemp.next != null) {
            midTemp = midTemp.next;
        }
        midTemp.next = maxNode;
        return result;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }
}
