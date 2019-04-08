package solutions;

import java.util.ArrayList;
import java.util.List;

/*
    给定一个二叉树，返回它的中序 遍历。
    进阶:
        递归算法很简单，你可以通过迭代算法完成吗？ // TODO
*/

/**
 * @author Chand
 * @date 2019-04-08 16:06:36
 */
public class Q094_Binary_Tree_Inorder_Traversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        partition(result, root);
        return result;
    }
    private void partition(List<Integer> result, TreeNode root) {
        if (root == null) {
            return;
        }
        partition(result, root.left);
        result.add(root.val);
        partition(result, root.right);
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
