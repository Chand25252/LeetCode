package solutions;

//import java.util.ArrayList;
//import java.util.List;

/*
    给定一个整数 n，生成所有由 1 ... n 为节点所组成的二叉搜索树。
*/
public class Q095_M_Unique_Binary_Search_Trees_II {
//    public List<TreeNode> generateTrees(int n) {
//        List<TreeNode> result = new ArrayList<>();
//        if (n == 0) {
//            return result;
//        }
//        if (n == 1) {
//            result.add(new TreeNode(1));
//            return result;
//        }
//        for (int i = 1; i <= n; i++) {
//            partition(result, new TreeNode(i), n, i - 1, i + 1);
//        }
//        return result;
//    }
//
//    private void partition(List<TreeNode> result, TreeNode node, int n, int left, int right) {
//        for (int i = left; i > 0 && i < node.val; i--) {
//            TreeNode temp = new TreeNode(i);
//            node.left = temp;
//            partition(result, temp, n, i - 1, i + 1);
//        }
//        for (int i = right; i <= n && i > node.val; i++) {
//            TreeNode temp = new TreeNode(i);
//            node.right = temp;
//            partition(result, temp, n, i - 1, i + 1);
//        }
//    }
//
//    public class TreeNode {
//        int val;
//        TreeNode left;
//        TreeNode right;
//        TreeNode(int x) {
//            val = x;
//        }
//    }
}
