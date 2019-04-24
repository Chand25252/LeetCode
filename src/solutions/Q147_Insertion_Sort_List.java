package solutions;

/*
    对链表进行插入排序。
    每次迭代时，从输入数据中移除一个元素（用红色表示），并原地将其插入到已排好序的链表中。
    插入排序算法：
        插入排序是迭代的，每次只移动一个元素，直到所有元素可以形成一个有序的输出列表。
        每次迭代中，插入排序只从输入数据中移除一个待排序的元素，找到它在序列中适当的位置，并将其插入。
        重复直到所有输入数据插入完为止。
*/

/**
 * @author Chand
 * @date 2019-04-24 16:19:00
 */
public class Q147_Insertion_Sort_List {
    public ListNode insertionSortList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode pre_pointer = null;
        ListNode cur_pointer  = head;
        ListNode pre_position = head;
        ListNode cur_position = head.next;
        while (cur_position != null) {
            ListNode next = cur_position.next;
            while (cur_pointer != cur_position) {
                if (cur_pointer.val <= cur_position.val) {
                    pre_pointer = cur_pointer;
                    cur_pointer = cur_pointer.next;
                    continue;
                }
                pre_position.next = next;
                if (pre_pointer == null) {
                    cur_position.next = cur_pointer;
                    head = cur_position;
                } else {
                    pre_pointer.next = cur_position;
                    cur_position.next = cur_pointer;
                }
                break;
            }
            if (cur_pointer == cur_position) {
                pre_position = cur_position;
            }
            cur_position = next;
            pre_pointer = null;
            cur_pointer = head;
        }
        return head;
    }

    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }
}
