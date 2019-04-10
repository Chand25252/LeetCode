package solutions;

/*
    给定一个二叉树，找出其最大深度。
    二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
    说明:
        叶子节点是指没有子节点的节点。
*/

/**
 * @author Chand
 * @date 2019-04-10 11:29:47
 */
public class Q104_Maximum_Depth_of_Binary_Tree {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return partition(root, 1);
    }
    private int partition(TreeNode node, int num) {
        if (node.left == null && node.right == null) {
            return num;
        }
        int temp1 = num;
        int temp2 = num;
        if (node.left != null) {
            temp1 = partition(node.left, num + 1);
        }
        if (node.right != null) {
            temp2 = partition(node.right, num + 1);
        }
        num = temp1 > temp2 ? temp1 : temp2;
        return num;
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
