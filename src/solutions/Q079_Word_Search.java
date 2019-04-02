package solutions;

import java.util.Arrays;

/*
    给定一个二维网格和一个单词，找出该单词是否存在于网格中。
    单词必须按照字母顺序，通过相邻的单元格内的字母构成，
    其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。
    同一个单元格内的字母不允许被重复使用。
*/

/**
 * @author Chand
 * @date 2019-04-02 17:51:22
 */
public class Q079_Word_Search {
    public boolean exist(char[][] board, String word) {
        if(board == null || board.length == 0) {
            return false;
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (word.charAt(0) == board[i][j]) {
                    int[] nums = new int[board.length * board[0].length];
                    if (existNext(board, i , j, word, 0, nums)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean existNext(char[][] board, int i, int j, String word, int position, int[] nums) {
        if (position == word.length() - 1) {
            return true;
        }
        nums[i * board[0].length + j] = 1;
        position++;
        if (i > 0 && board[i - 1][j] == word.charAt(position) && nums[(i - 1) * board[0].length + j] == 0) {
            int[] temp = Arrays.copyOf(nums, nums.length);
            if (existNext(board, i - 1, j, word, position, temp)) {
                return true;
            }
        }
        if (i < board.length - 1 && board[i + 1][j] == word.charAt(position) && nums[(i + 1) * board[0].length + j] == 0) {
            int[] temp = Arrays.copyOf(nums, nums.length);
            if (existNext(board, i + 1, j, word, position, temp)) {
                return true;
            }
        }
        if (j > 0 && board[i][j - 1] == word.charAt(position) && nums[i * board[0].length + j - 1] == 0) {
            int[] temp = Arrays.copyOf(nums, nums.length);
            if (existNext(board, i, j - 1, word, position, temp)) {
                return true;
            }
        }
        if (j < board[0].length - 1 && board[i][j + 1] == word.charAt(position) && nums[i * board[0].length + j + 1] == 0) {
            int[] temp = Arrays.copyOf(nums, nums.length);
            if (existNext(board, i, j + 1, word, position, temp)) {
                return true;
            }
        }
        return false;
    }
}
