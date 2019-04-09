package solutions;

/*
    给定两个二叉树，编写一个函数来检验它们是否相同。
    如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
*/

/**
 * @author Chand
 * @date 2019-04-09 15:47:55
 */
public class Q100_Same_Tree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        return partition(p, q, true);
    }

    private boolean partition(TreeNode p, TreeNode q, boolean flag) {
        if (p == null && q == null) {
            return flag;
        }
        if ((p == null && q != null) || (p != null && q == null)) {
            return false;
        }
        if (p.val != q.val || !flag) {
            return false;
        }
        flag = partition(p.left, q.left, flag);
        flag = partition(p.right, q.right, flag);
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
