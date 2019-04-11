package solutions;

/*
    给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。
    说明:
        叶子节点是指没有子节点的节点。
*/

/**
 * @author Chand
 * @date 2019-04-11 16:04:06
 */
public class Q112_Path_Sum {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        return partition(root, sum, 0, false);
    }

    private boolean partition(TreeNode node, int sum, int value, boolean flag) {
        if (node.left == null && node.right == null) {
            return (value + node.val) == sum;
        }
        if (node.left != null && !flag) {
            flag = partition(node.left, sum, value + node.val, false);
        }
        if (node.right != null && !flag) {
            flag = partition(node.right, sum, value + node.val, false);
        }
        return flag;
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
