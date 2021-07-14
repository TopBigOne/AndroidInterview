package tree.dfs.island.leet_code_200;

public class NumIslands3 {


    private char land = '1';

    public int numIslands(char[][] grid) {
        int row = grid.length;
        int column = grid[0].length;
        int res = 0;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (grid[i][j] == land) {
                    dfsGris(grid, i, j);
                    res++;
                }
            }
        }
        return res;
    }

    private void dfsGris(char[][] grid, int i, int j) {
        if (i >= grid.length || j >= grid[0].length || i < 0 || j < 0 || grid[i][j] != '1') {
            return;
        }

        grid[i][j] = '2';

        dfsGris(grid, i, j - 1);
        dfsGris(grid, i, j + 1);
        dfsGris(grid, i + 1, j);
        dfsGris(grid, i - 1, j);
    }
}
