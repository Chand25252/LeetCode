package solutions;

/*
    给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现 的数字。
*/

/**
 * @author Chand
 * @date 2019-04-03 16:13:29
 */
public class Q082_Remove_Duplicates_from_Sorted_List_II {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode result = null;
        ListNode temp = null;
        int value = head.val;
        boolean first = true;
        boolean valid = true;
        while (head != null) {
            if (head.next != null && head.next.val == value) {
                head = head.next;
                valid = false;
                continue;
            }
            if (!valid) {
                if (head.next == null) {
                    return result;
                }
                head = head.next;
                value = head.val;
                valid = true;
                continue;
            } else {
                if (first) {
                    result = new ListNode(head.val);
                    temp = result;
                    first = false;
                } else {
                    temp.next = new ListNode(head.val);
                    temp = temp.next;
                }
                head = head.next;
                value = head != null ? head.val : value;
            }
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
