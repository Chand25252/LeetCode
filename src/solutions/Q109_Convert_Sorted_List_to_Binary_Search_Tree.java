package solutions;

import java.util.ArrayList;
import java.util.List;

/*
    给定一个单链表，其中的元素按升序排序，将其转换为高度平衡的二叉搜索树。
    本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
*/

/**
 * @author Chand
 * @date 2019-04-11 14:42:49
 */
public class Q109_Convert_Sorted_List_to_Binary_Search_Tree {
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }
        List<Integer> numsList = new ArrayList<>();
        while (head != null) {
            numsList.add(head.val);
            head = head.next;
        }
        return partition(numsList);
    }

    private TreeNode partition(List<Integer> numsList) {
        if (numsList == null || numsList.size() == 0) {
            return null;
        }
        TreeNode node = new TreeNode(numsList.get(numsList.size() / 2));
        node.left = partition(numsList.subList(0, numsList.size() / 2));
        node.right = partition(numsList.subList(numsList.size() / 2 + 1, numsList.size()));
        return node;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }
}
