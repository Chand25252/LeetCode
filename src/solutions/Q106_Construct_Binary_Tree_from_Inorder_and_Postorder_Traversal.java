package solutions;

import java.util.Arrays;

/*
    根据一棵树的中序遍历与后序遍历构造二叉树。
    注意:
        你可以假设树中没有重复的元素
*/

/**
 * @author Chand
 * @date 2019-04-11 09:16:24
 */
public class Q106_Construct_Binary_Tree_from_Inorder_and_Postorder_Traversal {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || inorder.length == 0 || postorder.length == 0) {
            return null;
        }
        TreeNode node = null;
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == postorder[postorder.length - 1]) {
                node = new TreeNode(postorder[postorder.length - 1]);
                for (int j = postorder.length - 1; j > 0; j--) {
                    postorder[j] = postorder[j - 1];
                }
                node.right = buildTree(Arrays.copyOfRange(inorder, i + 1, inorder.length), postorder);
                node.left = buildTree(Arrays.copyOfRange(inorder, 0, i), postorder);
                break;
            }
        }
        return node;
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
