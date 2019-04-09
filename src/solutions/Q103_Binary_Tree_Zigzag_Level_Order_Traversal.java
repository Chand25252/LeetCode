package solutions;

import java.util.*;

/*
    给定一个二叉树，返回其节点值的锯齿形层次遍历。
    （即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）
*/

/**
 * @author Chand
 * @date 2019-04-09 18:13:30
 */
public class Q103_Binary_Tree_Zigzag_Level_Order_Traversal {
    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
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
        for (int i = 0; i < result.size(); i++) {
            if ((i & 1) == 1) {
                List<Integer> tempList = result.get(i);
                int listLength = tempList.size();
                for (int j = 0; j < listLength / 2; j++) {
                    int temp = tempList.get(j);
                    tempList.set(j, tempList.get(listLength - j - 1));
                    tempList.set(listLength - j - 1, temp);
                }
            }
        }
        return result;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        zigzagLevelOrder(root);
    }
}
