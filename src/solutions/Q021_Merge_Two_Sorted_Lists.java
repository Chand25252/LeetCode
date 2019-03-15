package solutions;


/*
    将两个有序链表合并为一个新的有序链表并返回。
    新链表是通过拼接给定的两个链表的所有节点组成的。
*/

/**
 * @author Chand
 * @date 2019-03-15 15:13:34
 */
public class Q021_Merge_Two_Sorted_Lists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode temp = null;
        if (l1.val <= l2.val) {
            temp = new ListNode(l1.val);
            l1 = l1.next;
        } else {
            temp = new ListNode(l2.val);
            l2 = l2.next;
        }
        ListNode header = temp;
        while (l1 != null || l2 != null) {
            if (l1 == null) {
                temp.next = l2;
                l2 = l2.next;
                temp = temp.next;
                continue;
            }
            if (l2 == null) {
                temp.next = l1;
                l1 = l1.next;
                temp = temp.next;
                continue;
            }
            if (l1.val <= l2.val) {
                temp.next = l1;
                l1 = l1.next;
            } else {
                temp.next = l2;
                l2 = l2.next;
            }
            temp = temp.next;
        }
        return header;
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

}
