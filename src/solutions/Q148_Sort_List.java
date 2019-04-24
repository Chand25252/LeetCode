package solutions;

import java.util.Arrays;
import java.util.Comparator;

/*
    在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序。 //TODO
*/

/**
 * @author Chand
 * @date 2019-04-24 17:29:47
 */
public class Q148_Sort_List {
    public ListNode sortList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode tempNode = head;
        int length = 0;
        while (tempNode != null) {
            length++;
            tempNode = tempNode.next;
        }
        ListNode[] nodeArr = new ListNode[length];
        tempNode = head;
        int i = 0;
        while (tempNode != null) {
            nodeArr[i] = tempNode;
            tempNode = tempNode.next;
            i++;
        }
        Arrays.sort(nodeArr, new CustomRule());
        head = nodeArr[0];
        tempNode = head;
        for (i = 1; i < length; i++) {
            tempNode.next = nodeArr[i];
            tempNode = tempNode.next;
        }
        tempNode.next = null;
        return head;
    }

    class CustomRule implements Comparator {
        @Override
        public int compare(Object o1, Object o2) {
            ListNode node1 = (ListNode) o1;
            ListNode node2 = (ListNode) o2;
            return node1.val - node2.val;
        }
    }

    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }
}
