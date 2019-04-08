package solutions;

/*
    反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。
    说明:
        1 ≤ m ≤ n ≤ 链表长度。
*/

/**
 * @author Chand
 * @date 2019-04-08 11:24:07
 */
public class Q092_Reverse_Linked_List_II {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null || head.next == null || m == n) {
            return head;
        }
        return partition(head, new ListNode(0), m, n, 1);
    }

    private ListNode partition(ListNode currentNode, ListNode newNode, int m, int n, int i) {
        if (i == n) {
            return currentNode;
        }
        ListNode temp = partition(currentNode.next, newNode, m, n, i + 1);
        if (i >= m) {
            currentNode.next = temp.next;
            temp.next = currentNode;
            if (i == n - 1) {
                newNode.val = temp.val;
                newNode.next = temp.next;
            }
            if (i == 1) {
                return newNode;
            }
            return currentNode;
        }
        if (i == m - 1) {
            currentNode.next = newNode;
        }
        return currentNode;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }
}
