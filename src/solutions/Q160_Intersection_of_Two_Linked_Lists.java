package solutions;

/*
    编写一个程序，找到两个单链表相交的起始节点。
    注意：
        如果两个链表没有交点，返回 null.
        在返回结果后，两个链表仍须保持原有的结构。
        可假定整个链表结构中没有循环。
        程序尽量满足 O(n) 时间复杂度，且仅用 O(1) 内存。
*/

/**
 * @author Chand
 * @date 2019-04-28 16:25:14
 */
public class Q160_Intersection_of_Two_Linked_Lists {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode tempA = headA;
        ListNode tempB = headB;
        boolean flagA = true;
        boolean flagB = true;
        while (tempA != null) {
            if (tempA == tempB) {
                return tempA;
            }
            tempA = tempA.next;
            tempB = tempB.next;
            if (tempA == null && flagA) {
                tempA = headB;
                flagA = false;
            }
            if (tempB == null && flagB) {
                tempB = headA;
                flagB = false;
            }
        }
        return null;
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
