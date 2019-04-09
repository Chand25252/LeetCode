package solutions;

/*
    给定一个二叉树，检查它是否是镜像对称的。
*/

/**
 * @author Chand
 * @date 2019-04-09 16:17:06
 */
public class Q101_Symmetric_Tree {
    public boolean isSymmetric(TreeNode root) {
        return partition(root.left, root.right, true);
    }

    private boolean partition(TreeNode p, TreeNode q, boolean flag) {
        if (!flag || (p == null && q == null)) {
            return flag;
        }
        if ((p == null && q != null) || (p != null && q == null) || p.val != q.val) {
            return false;
        }
        flag = partition(p.left, q.right, flag);
        flag = partition(p.right, q.left, flag);
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
