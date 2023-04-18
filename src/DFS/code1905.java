package DFS;

public class code1905 {
    public void dfs(int[][] grid, int i, int j){
        if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == 0)
            return;
        grid[i][j] = 0;
        dfs(grid, i-1, j);
        dfs(grid, i+1, j);
        dfs(grid, i, j-1);
        dfs(grid, i, j+1);
    }

    public int countSubIslands(int[][] grid1, int[][] grid2) {
        // 题意：如果子岛屿群B中有一部分是岛屿，则这一部分在母岛屿群A中必定也是岛屿或者岛屿的一部分;
        // 逆否命题：若在A中不是岛屿的位置，对应的B中位置必定也不是。
        // 由于岛屿必须是连续的，因此需要删除B中不符合逆否命题的位置所在的整个岛屿
        int row = grid1.length;
        int col = grid1[0].length;

        // 消除A不是岛屿但B是岛屿的部分
        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                if(grid1[i][j] == 0 && grid2[i][j] != 0)
                    dfs(grid2, i, j);
            }
        }
        // 统计子岛屿
        int subNums = 0;
        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                if(grid2[i][j] == 1) {
                    subNums++;
                    dfs(grid2, i, j);
                }
            }
        }
        return subNums;
    }

    public static void main(String[] args) {
        boolean a = true;
        System.out.println(a &= false);
    }
}

