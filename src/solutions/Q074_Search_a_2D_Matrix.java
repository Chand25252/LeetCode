package solutions;

/*
    编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。
    该矩阵具有如下特性：
        每行中的整数从左到右按升序排列。
        每行的第一个整数大于前一行的最后一个整数。
*/

/**
 * @author Chand
 * @date 2019-04-02 13:51:44
 */
public class Q074_Search_a_2D_Matrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) {
            return false;
        }
        int row = matrix.length;
        int col = matrix[0].length;
        int left = 0;
        int right = row - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (matrix[mid][0] == target) {
                return true;
            }
            if (matrix[mid][0] < target) {
                if (mid + 1 < row && matrix[mid + 1][0] > target) {
                    left = mid;
                    break;
                }
                left = mid + 1;
                continue;
            }
            if (matrix[mid][0] > target) {
                if (mid - 1 >= 0 && matrix[mid - 1][0] <= target) {
                    left = mid - 1;
                    break;
                }
                right = mid - 1;
                continue;
            }
        }
        row = left;
        left = 0;
        right = col - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (matrix[row][mid] == target) {
                return true;
            }
            if (matrix[row][mid] < target) {
                left = mid + 1;
                continue;
            }
            if (matrix[row][mid] > target) {
                right = mid - 1;
                continue;
            }
        }
        return false;
    }
}
