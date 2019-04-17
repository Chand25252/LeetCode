package solutions;

import java.util.ArrayList;
import java.util.List;

/*
    二叉搜索树中的两个节点被错误地交换。
    请在不改变其结构的情况下，恢复这棵树。
    进阶:
        使用 O(n) 空间复杂度的解法很容易实现。
        你能想出一个只使用常数空间的解决方案吗？
*/

/**
 * @author Chand
 * @date 2019-04-09 15:37:50
 */
public class Q099_Recover_Binary_Search_Tree {
    public void recoverTree(TreeNode root) {
        List<TreeNode> nodeList = new ArrayList<>();
        partition(root, nodeList);
        int position = -1;
        for (int i = 0; i < nodeList.size() - 1; i++) {
            if (nodeList.get(i).val > nodeList.get(i + 1).val) {
                position = i;
                break;
            }
        }
        for (int i = nodeList.size() - 1; i > 0; i--) {
            if (nodeList.get(i).val < nodeList.get(i - 1).val) {
                int temp = nodeList.get(i).val;
                nodeList.get(i).val = nodeList.get(position).val;
                nodeList.get(position).val = temp;
                return;
            }
        }
    }

    private void partition(TreeNode root, List<TreeNode> nodeList) {
        if (root == null) {
            return;
        }
        partition(root.left, nodeList);
        nodeList.add(root);
        partition(root.right, nodeList);
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
