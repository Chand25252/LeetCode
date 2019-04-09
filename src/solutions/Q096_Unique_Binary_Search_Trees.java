package solutions;

/*
    给定一个整数 n，求以 1 ... n 为节点组成的二叉搜索树有多少种？
*/

/**
 * @author Chand
 * @date 2019-04-09 11:03:35
 */
public class Q096_Unique_Binary_Search_Trees {
    public int numTrees(int n) {
        if (n <= 1) {
            return 1;
        }
        int result = 0;
        for (int i = 0; i < n; i++) {
            result = result + numTrees(i) * numTrees(n - 1 - i);
        }
        return result;
    }
}
