package solutions;

/*
    给定一个二维的矩阵，包含 'X' 和 'O'（字母 O）。
    找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充。
    解释:
        被围绕的区间不会存在于边界上，换句话说，任何边界上的 'O' 都不会被填充为 'X'。
    任何不在边界上，或不与边界上的 'O' 相连的 'O' 最终都会被填充为 'X'。
    如果两个元素在水平或垂直方向相邻，则称它们是“相连”的。
*/

/**
 * @author Chand
 * @date 2019-04-16 17:20:34
 */
public class Q130_Surrounded_Regions {
    public void solve(char[][] board) {
        if (board == null || board.length <= 1 || board[0].length <= 1) {
            return;
        }
        for (int i = 1; i < board.length - 1; i++) {
            for (int j = 1; j < board[0].length - 1; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'M';
                }
            }
        }
        for (int i = 0; i < board.length; i++) {
            if (board[i][0] == 'O') {
                board = dfs(board, i, 1);
            }
            if (board[i][board[0].length - 1] == 'O') {
                board = dfs(board, i, board[0].length - 2);
            }
        }
        for (int j = 0; j < board[0].length; j++) {
            if (board[0][j] == 'O') {
                board = dfs(board, 1, j);
            }
            if (board[board.length - 1][j] == 'O') {
                board = dfs(board, board.length - 2, j);
            }
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'M') {
                    board[i][j] = 'X';
                }
            }
        }
    }

    private char[][] dfs(char[][] board, int i, int j) {
        if (i < 0 || i > board.length - 1 || j < 0 || j > board[0].length - 1) {
            return board;
        }
        if (board[i][j] != 'M') {
            return board;
        }
        board[i][j] = 'O';
        board = dfs(board, i - 1, j);
        board = dfs(board, i + 1, j);
        board = dfs(board, i, j - 1);
        board = dfs(board, i, j + 1);
        return board;
    }
}
