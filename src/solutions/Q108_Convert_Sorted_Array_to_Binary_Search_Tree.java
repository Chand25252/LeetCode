package solutions;

import java.util.Arrays;

/*
    将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。
    本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
*/

/**
 * @author Chand
 * @date 2019-04-11 14:26:03
 */
public class Q108_Convert_Sorted_Array_to_Binary_Search_Tree {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        TreeNode node = new TreeNode(nums[nums.length / 2]);
        node.left = sortedArrayToBST(Arrays.copyOfRange(nums, 0, nums.length / 2));
        node.right = sortedArrayToBST(Arrays.copyOfRange(nums, nums.length / 2 + 1, nums.length));
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
