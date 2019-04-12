package solutions;

import java.util.Stack;

/*
    给定一个二叉树，原地将它展开为链表。//TODO
*/

/**
 * @author Chand
 * @date 2019-04-12 16:00:00
 */
public class Q114_Flatten_Binary_Tree_to_Linked_List {
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> leftNode = new Stack<>();
        TreeNode listNode = root;
        while (true) {
            if (listNode.right != null) {
                leftNode.push(listNode.right);
                listNode.right = null;
            }
            if (listNode.left == null) {
                break;
            }
            listNode = listNode.left;
        }
        while (!leftNode.isEmpty()) {
            TreeNode subTreeNode = leftNode.pop();
            TreeNode temp = subTreeNode;
            while (true) {
                if (temp.right != null) {
                    leftNode.push(temp.right);
                    temp.right = null;
                }
                if (temp.left == null) {
                    break;
                }
                temp = temp.left;
            }
            listNode.left = subTreeNode;
            listNode = temp;
        }
        reverse(root);
    }

    private TreeNode reverse(TreeNode node) {
        if (node == null) {
            return null;
        }
        node.right = reverse(node.left);
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
}
