package solutions;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
    给定一个二叉树，返回其节点值自底向上的层次遍历。
    （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
*/

/**
 * @author Chand
 * @date 2019-04-11 14:00:35
 */
public class Q107_Binary_Tree_Level_Order_Traversal_II {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> results = new ArrayList<>();
        if (root == null) {
            return results;
        }
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        Queue<Integer> numQueue = new LinkedList<>();
        nodeQueue.add(root);
        numQueue.add(0);
        while(!nodeQueue.isEmpty()) {
            TreeNode tempNode = nodeQueue.poll();
            int temp = numQueue.poll();
            if (results.size() <= temp) {
                List<Integer> tempList = new ArrayList<>();
                tempList.add(tempNode.val);
                results.add(tempList);
            } else {
                List<Integer> tempList = results.get(temp);
                tempList.add(tempNode.val);
            }
            if (tempNode.left != null) {
                nodeQueue.add(tempNode.left);
                numQueue.add(temp + 1);
            }
            if (tempNode.right != null) {
                nodeQueue.add(tempNode.right);
                numQueue.add(temp + 1);
            }
        }
        int size = results.size();
        for (int i = 0; i < size / 2; i++) {
            List<Integer> tempList = results.get(i);
            results.set(i, results.get(size - 1 - i));
            results.set(size - 1 - i, tempList);
        }
        return results;
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
