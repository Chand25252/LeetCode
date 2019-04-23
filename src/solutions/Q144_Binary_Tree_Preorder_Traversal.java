package solutions;

import java.util.*;

/*
    给定一个二叉树，返回它的 前序 遍历。
    进阶:
        递归算法很简单，你可以通过迭代算法完成吗？
*/

/**
 * @author Chand
 * @date 2019-04-23 11:12:18
 */
public class Q144_Binary_Tree_Preorder_Traversal {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Stack<TreeNode> nodeStack = new Stack<>();
        Map<TreeNode, Boolean> nodeMap = new HashMap<>();
        nodeStack.push(null);
        nodeStack.push(root);
        TreeNode temp = root;
        nodeMap.put(root, true);
        result.add(root.val);
        while (!nodeStack.isEmpty()) {
            if (temp.left != null && !nodeMap.containsKey(temp.left)) {
                nodeStack.push(temp.left);
                nodeMap.put(temp.left, true);
                result.add(temp.left.val);
                temp = temp.left;
                continue;
            }
            if (temp.right != null && !nodeMap.containsKey(temp.right)) {
                nodeStack.push(temp.right);
                nodeMap.put(temp.right, true);
                result.add(temp.right.val);
                temp = temp.right;
                continue;
            }
            temp = nodeStack.pop();
        }
        return result;
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

}
