package DFS;

public class code1254 {
    // 填平岛屿
    public void dfs(int[][] grid, int i, int j) {
        int row = grid.length;
        int col = grid[0].length;

        if(i < 0 || i >= row || j < 0 || j >= col || grid[i][j] == 1)
            return;
        grid[i][j] = 1;
        dfs(grid, i-1, j);
        dfs(grid, i+1, j);
        dfs(grid, i, j-1);
        dfs(grid, i, j+1);
    }
    public int closedIsland(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        // 封闭岛屿，即靠岸的岛不算在内，首先将跟岸衔接的岛屿填平
        for(int i=0; i < row; i++){
            // 左边缘
            if(grid[i][0] == 0)
                dfs(grid, i, 0);
            // 右边缘
            if(grid[i][col-1] == 0)
                dfs(grid, i, col-1);
        }
        for(int j=0; j < col; j++){
            // 上边缘
            if(grid[0][j] == 0)
                dfs(grid, 0, j);
            // 下边缘
            if(grid[row-1][j] == 0)
                dfs(grid, row-1, j);
        }

        // 统计岛屿数量
        int nums = 0;
        for(int i=0; i < row; i++){
            for(int j=0; j < col; j++) {
                if(grid[i][j] == 0) {
                    nums++;
                    dfs(grid, i, j);
                }
            }
        }
        return nums;
    }
}
