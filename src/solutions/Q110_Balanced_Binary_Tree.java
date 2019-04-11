package solutions;

/*
    给定一个二叉树，判断它是否是高度平衡的二叉树。
    本题中，一棵高度平衡二叉树定义为：
        一个二叉树每个节点的左右两个子树的高度差的绝对值不超过1。
*/

/**
 * @author Chand
 * @date 2019-04-11 15:45:20
 */
public class Q110_Balanced_Binary_Tree {

    public static boolean flag = true;

    public boolean isBalanced(TreeNode root) {
        partition(root);
        return flag;
    }

    private int partition(TreeNode root) {
        if (root == null || !flag) {
            return 0;
        }
        int left = partition(root.left);
        int right = partition(root.right);
        if (left - right > 1 || left - right < -1) {
            flag = false;
        }
        return (left > right ? left : right) + 1;
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
