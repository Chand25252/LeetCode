package solutions;

/*给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。

        如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。

        您可以假设除了数字 0 之外，这两个数都不会以 0 开头。*/

/**
 * @author Chand
 * @date 2019-02-14 15:51:08
 */
public class Q2_Add_Two_Numbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int i = l1.val;
        int j = l2.val;
        int temp = (i + j) >= 10 ? (i + j) - 10 : (i + j);
        int plus = (i + j) >= 10 ? 1 : 0;
        ListNode sum = new ListNode(temp);
        ListNode head = sum;
        l1 = l1.next;
        l2 = l2.next;
        while(l1 != null || l2 != null) {
            i = 0;
            j = 0;
            if(l1 != null) {
                i = l1.val;
                l1 = l1.next;
            }
            if(l2 != null) {
                j = l2.val;
                l2 = l2.next;
            }
            temp = (i + j + plus) >= 10 ? (i + j + plus) - 10 : (i + j + plus);
            plus = (i + j + plus) >= 10 ? 1 : 0;
            ListNode newSum = new ListNode(temp);
            sum.next = newSum;
            sum = newSum;
        }
        if(plus == 1) {
            ListNode extra = new ListNode(plus);
            sum.next = extra;
        }
        return head;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
