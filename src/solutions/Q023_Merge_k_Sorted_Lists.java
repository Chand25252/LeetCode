package solutions;

/*
    合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度
*/

/**
 * @author Chand
 * @date 2019-03-15 17:14:40
 */
public class Q023_Merge_k_Sorted_Lists {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode result = null;
        for (int i = 0; i < lists.length; i++) {
            result = mergeTwoLists(lists[i], result);
        }
        return result;
    }


    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
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
