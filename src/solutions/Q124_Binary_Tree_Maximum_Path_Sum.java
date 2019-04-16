package solutions;

/*
    给定一个非空二叉树，返回其最大路径和。
    本题中，路径被定义为一条从树中任意节点出发，达到任意节点的序列。
    该路径至少包含一个节点，且不一定经过根节点。
*/

/**
 * @author Chand
 * @date 2019-04-16 09:51:02
 */
public class Q124_Binary_Tree_Maximum_Path_Sum {

    private int maxPath = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        maxPath = root.val;
        partition(root);
        return maxPath;
    }

    private int partition(TreeNode node) {
        if (node.left == null && node.right == null) {
            return node.val;
        }
        int leftPath = Integer.MIN_VALUE;
        int rightPath = Integer.MIN_VALUE;
        if (node.left != null) {
            leftPath = partition(node.left);
        }
        if (node.right != null) {
            rightPath = partition(node.right);
        }
        int tempPath = node.val;
        int totalPath = node.val;
        maxPath = Math.max(maxPath, tempPath);
        maxPath = Math.max(maxPath, leftPath);
        maxPath = Math.max(maxPath, rightPath);
        if (leftPath > 0) {
            totalPath = totalPath + leftPath;
            leftPath = tempPath + leftPath;
        }
        if (rightPath > 0) {
            totalPath = totalPath + rightPath;
            rightPath = tempPath + rightPath;
        }
        tempPath = Math.max(leftPath, rightPath);
        tempPath = Math.max(tempPath, node.val);
        maxPath = Math.max(tempPath, maxPath);
        maxPath = Math.max(totalPath, maxPath);
        return tempPath;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }

}
