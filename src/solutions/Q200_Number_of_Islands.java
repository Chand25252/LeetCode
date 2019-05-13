package solutions;

/*
    给定一个由 '1'（陆地）和 '0'（水）组成的的二维网格，
计算岛屿的数量。一个岛被水包围，并且它是通过水平方向或垂直方向上相邻的陆地连接而成的。
    你可以假设网格的四个边均被水包围。
*/

/**
 * @author Chand
 * @date 2019-05-13 14:10:11
 */
public class Q200_Number_of_Islands {
    public int numIslands(char[][] grid) {
        if (grid.length == 0) {
            return 0;
        }
        int result = 0;
        int[][] marked = new int[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (dfs(grid, marked, i, j, false)) {
                    result++;
                }
            }
        }
        return result;
    }

    private boolean dfs(char[][] grid, int[][] marked, int i, int j, boolean flag) {
        if (marked[i][j] == 1 || grid[i][j] == '0') {
            return flag;
        }
        flag = true;
        if (i > 0 && grid[i][j] == '1') {
            marked[i][j] = 1;
            flag = dfs(grid, marked, i - 1, j, flag);
        }
        if (i < grid.length - 1 && grid[i][j] == '1') {
            marked[i][j] = 1;
            flag = dfs(grid, marked, i + 1, j, flag);
        }
        if (j > 0 && grid[i][j] == '1') {
            marked[i][j] = 1;
            flag = dfs(grid, marked, i, j - 1, flag);
        }
        if (j < grid[0].length - 1 && grid[i][j] == '1') {
            marked[i][j] = 1;
            flag = dfs(grid, marked, i, j + 1, flag);
        }
        return flag;
    }
}
