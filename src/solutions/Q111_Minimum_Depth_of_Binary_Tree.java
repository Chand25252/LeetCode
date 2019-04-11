package solutions;


/*
    给定一个二叉树，找出其最小深度。
    最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
    说明:
        叶子节点是指没有子节点的节点。
*/

/**
 * @author Chand
 * @date 2019-04-11 15:53:47
 */
public class Q111_Minimum_Depth_of_Binary_Tree {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = minDepth(root.left);
        int right = minDepth(root.right);
        if (left != 0 && right == 0) {
            return left + 1;
        }
        if (left == 0 && right != 0) {
            return right + 1;
        }
        return left < right ? left + 1 : right + 1;
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
