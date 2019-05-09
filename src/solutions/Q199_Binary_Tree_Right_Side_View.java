package solutions;

import java.util.*;

/*
    给定一棵二叉树，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
*/

/**
 * @author Chand
 * @date 2019-05-09 18:09:15
 */
public class Q199_Binary_Tree_Right_Side_View {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        Map<TreeNode, Integer> nodeMap = new HashMap<>();
        nodeQueue.add(root);
        nodeMap.put(root, 0);
        int level = 0;
        TreeNode currentNode = root;
        while (!nodeQueue.isEmpty()) {
            TreeNode tempNode = nodeQueue.poll();
            if (level < nodeMap.get(tempNode)) {
                result.add(currentNode.val);
                level = nodeMap.get(tempNode);
            }
            currentNode = tempNode;
            if (tempNode.left != null) {
                nodeQueue.add(tempNode.left);
                nodeMap.put(tempNode.left, level + 1);
            }
            if (tempNode.right != null) {
                nodeQueue.add(tempNode.right);
                nodeMap.put(tempNode.right, level + 1);
            }
        }
        result.add(currentNode.val);
        return result;
    }

    class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }
}
