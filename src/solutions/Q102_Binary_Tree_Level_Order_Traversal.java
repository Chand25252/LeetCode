package solutions;

import java.util.*;

/*
    给定一个二叉树，返回其按层次遍历的节点值。 （即逐层地，从左到右访问所有节点）。
*/

/**
 * @author Chand
 * @date 2019-04-09 17:15:13
 */
public class Q102_Binary_Tree_Level_Order_Traversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        Queue<Integer> rowQueue = new LinkedList<>();
        nodeQueue.add(root);
        rowQueue.add(0);
        while (!nodeQueue.isEmpty()) {
            TreeNode tempNode = nodeQueue.poll();
            int temp = rowQueue.poll();
            if (result.size() <= temp) {
                List<Integer> tempList = new ArrayList<>();
                tempList.add(tempNode.val);
                result.add(tempList);
            } else {
                result.get(temp).add(tempNode.val);
            }
            if (tempNode.left != null) {
                nodeQueue.add(tempNode.left);
                rowQueue.add(temp + 1);
            }
            if (tempNode.right != null) {
                nodeQueue.add(tempNode.right);
                rowQueue.add(temp + 1);
            }
        }
        return result;
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
