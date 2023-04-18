package DFS;

public class code695 {
    public int dfs(int[][] grid, int i, int j) {
        int row = grid.length;
        int col = grid[0].length;

        if(i < 0 || i >= row || j < 0 || j >= col || grid[i][j] == 0)
            return 0;
        // 避免重复计算
        grid[i][j] = 0;
        int area = 1;
        area += dfs(grid, i-1, j);
        area += dfs(grid, i+1, j);
        area += dfs(grid, i, j-1);
        area += dfs(grid, i, j+1);
        return area;
    }
    public int maxAreaOfIsland(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int maxArea = 0;
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(grid[i][j] == 1){
                    maxArea = Math.max(dfs(grid, i, j), maxArea);
                }
            }
        }
        return maxArea;
    }
}
