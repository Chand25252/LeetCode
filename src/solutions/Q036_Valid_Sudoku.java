package solutions;

/*
    判断一个 9x9 的数独是否有效。只需要根据以下规则，验证已经填入的数字是否有效即可。
    数字 1-9 在每一行只能出现一次。
    数字 1-9 在每一列只能出现一次。
    数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
    数独部分空格内已填入了数字，空白格用 '.' 表示。
*/

/**
 * @author Chand
 * @date 2019-03-20 09:53:14
 */
public class Q036_Valid_Sudoku {
    public boolean isValidSudoku(char[][] board) {
        boolean[][] row = new boolean[9][10];
        boolean[][] column = new boolean[9][10];
        boolean[][] block = new boolean[9][10];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    int check = board[i][j] - '0';
                    int blockNum = i / 3 * 3 + j / 3;
                    if (row[i][check] || column[j][check] || block[blockNum][check]) {
                        return false;
                    }
                    row[i][check] = true;
                    column[j][check] = true;
                    block[blockNum][check] = true;
                }
            }
        }
        return true;
    }
}
