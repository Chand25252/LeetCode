package solutions;

/*
    给定一个二叉树，它的每个结点都存放一个 0-9 的数字，每条从根到叶子节点的路径都代表一个数字。
    例如，从根到叶子节点路径 1->2->3 代表数字 123。
    计算从根到叶子节点生成的所有数字之和。
    说明:
        叶子节点是指没有子节点的节点。
*/

/**
 * @author Chand
 * @date 2019-04-16 14:07:27
 */
public class Q129_Sum_Root_to_Leaf_Numbers {

    private int result = 0;

    public int sumNumbers(TreeNode root) {
        subTreeNode(root, 0);
        return result;
    }

    private void subTreeNode(TreeNode node, int sum) {
        if (node.left == null && node.right == null) {
            result = sum * 10 + node.val;
        }
        if (node.left != null) {
            subTreeNode(node.left, sum * 10 + node.val);
        }
        if (node.right != null) {
            subTreeNode(node.right, sum * 10 + node.val);
        }
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
