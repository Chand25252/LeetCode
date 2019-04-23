package solutions;

import java.util.*;

/*
    给定一个二叉树，返回它的 后序 遍历。
    进阶:
        递归算法很简单，你可以通过迭代算法完成吗？
*/

/**
 * @author Chand
 * @date 2019-04-23 14:56:48
 */
public class Q145_Binary_Tree_Postorder_Traversal {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        List<Integer> nodeList = new ArrayList<>();
        Stack<TreeNode> nodeStack = new Stack<>();
        nodeStack.add(root);
        while (!nodeStack.isEmpty()) {
            TreeNode temp = nodeStack.pop();
            if (temp.left != null) {
                nodeStack.push(temp.left);
            }
            if (temp.right != null) {
                nodeStack.push(temp.right);
            }
            nodeList.add(temp.val);
        }
        for (int i = nodeList.size() - 1; i >= 0; i--) {
            result.add(nodeList.get(i));
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
