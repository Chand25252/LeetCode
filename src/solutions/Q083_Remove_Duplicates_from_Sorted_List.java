package solutions;

/*
    给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
*/

/**
 * @author Chand
 * @date 2019-04-03 16:21:46
 */
public class Q083_Remove_Duplicates_from_Sorted_List {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode result = new ListNode(head.val);
        ListNode temp = result;
        int value = head.val;
        while (head != null) {
            if (head.next != null && head.next.val == value) {
                head = head.next;
                continue;
            }
            if (head.val != value) {
                value = head.val;
                temp.next = new ListNode(head.val);
                temp = temp.next;
            }
            head = head.next;
        }
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
