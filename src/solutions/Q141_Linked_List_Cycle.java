package solutions;

/*
    给定一个链表，判断链表中是否有环。
    为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。
    如果 pos 是 -1，则在该链表中没有环。
*/

/**
 * @author Chand
 * @date 2019-04-22 11:42:02
 */
public class Q141_Linked_List_Cycle {
    public boolean hasCycle(ListNode head) {
        while (head != null) {
            if (head.val == 25252) {
                return true;
            }
            head.val = 25252;
            head = head.next;
        }
        return false;
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
