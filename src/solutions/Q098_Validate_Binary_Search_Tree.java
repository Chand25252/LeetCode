package solutions;

import java.util.ArrayList;
import java.util.List;

/*
    给定一个二叉树，判断其是否是一个有效的二叉搜索树。
    假设一个二叉搜索树具有如下特征：
        节点的左子树只包含小于当前节点的数。
        节点的右子树只包含大于当前节点的数。
        所有左子树和右子树自身必须也是二叉搜索树。
*/

/**
 * @author Chand
 * @date 2019-04-09 14:17:07
 */
public class Q098_Validate_Binary_Search_Tree {
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        List<Integer> nodeValue = new ArrayList<>();
        partition(root, nodeValue);
        for (int i = 1; i < nodeValue.size(); i++) {
            if (nodeValue.get(i) <= nodeValue.get(i - 1)) {
                return false;
            }
        }
        return true;
    }

    private void partition(TreeNode root, List<Integer> nodeValue) {
        if (root == null) {
            return;
        }
        partition(root.left, nodeValue);
        nodeValue.add(root.val);
        partition(root.right, nodeValue);
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
