package solutions;

import java.util.Arrays;

/*
    根据一棵树的前序遍历与中序遍历构造二叉树。
    注意:
        你可以假设树中没有重复的元素。
*/

/**
 * @author Chand
 * @date 2019-04-10 17:03:17
 */
public class Q105_Construct_Binary_Tree_from_Preorder_and_Inorder_Traversal {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (inorder == null || inorder.length == 0) {
            return null;
        }
        TreeNode node = null;
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == preorder[0]) {
                node = new TreeNode(preorder[0]);
                for (int j = 0; j < preorder.length - 1; j++) {
                    preorder[j] = preorder[j + 1];
                }
                node.left = buildTree(preorder, Arrays.copyOfRange(inorder, 0, i));
                node.right = buildTree(preorder, Arrays.copyOfRange(inorder, i + 1, inorder.length));
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
