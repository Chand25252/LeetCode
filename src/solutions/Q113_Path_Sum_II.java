package solutions;

import java.util.ArrayList;
import java.util.List;

/*
    给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。
    说明:
        叶子节点是指没有子节点的节点。
*/

/**
 * @author Chand
 * @date 2019-04-11 16:20:39
 */
public class Q113_Path_Sum_II {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> results = new ArrayList<>();
        if (root == null) {
            return results;
        }
        List<Integer> result = new ArrayList<>();
        partition(results, result, root, sum, 0);
        return results;
    }

    private void partition(List<List<Integer>> results, List<Integer> result, TreeNode node, int sum, int value) {
        if (node.left == null && node.right == null) {
            if (sum == value + node.val) {
                List<Integer> temp = new ArrayList<>(result);
                temp.add(node.val);
                results.add(temp);
            }
            return;
        }
        if (node.left != null) {
            List<Integer> temp = new ArrayList<>(result);
            temp.add(node.val);
            partition(results, temp, node.left, sum, value + node.val);
        }
        if (node.right != null) {
            List<Integer> temp = new ArrayList<>(result);
            temp.add(node.val);
            partition(results, temp, node.right, sum, value + node.val);
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
