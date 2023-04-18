package DFS;

public class code200 {
    // 海水填平岛屿
    public void dfs(char[][] grid, int i, int j) {
        int row = grid.length;
        int col = grid[0].length;
        // 越界判定
        if(i < 0 || i >= row || j < 0 || j >= col)
            return;
        // 遇到海水则返回
        if(grid[i][j] == '0')
            return;
        grid[i][j] = '0';
        // 上下左右深度优先搜索
        dfs(grid, i-1, j);
        dfs(grid, i+1, j);
        dfs(grid, i, j-1);
        dfs(grid, i, j+1);
    }
    public int numIslands(char[][] grid) {
        int nums = 0;   // 岛屿数量
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid.length; j++){
                if(grid[i][j] == '1'){
                    nums++;
                    dfs(grid, i, j);
                }

            }
        }
        return nums;
    }
}
