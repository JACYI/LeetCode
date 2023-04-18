package DFS;

import java.util.HashMap;
import java.util.HashSet;

public class code827 {
    public int dfs(int[][] grid, int i, int j, int index) {
        int row = grid.length;
        int col = grid[0].length;

        // 越界判定 + 海水判定 + 重复访问判定
        if(i < 0 || j < 0 || i >= row ||  j >= col || grid[i][j] == 0 || grid[i][j] == index)
            return 0;
        grid[i][j] = index;
        int sum = 1;
        sum += dfs(grid, i-1, j, index);
        sum += dfs(grid, i+1, j, index);
        sum += dfs(grid, i, j-1, index);
        sum += dfs(grid, i, j+1, index);
        return sum;
    }
    public int largestIsland(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        // 哈希表存放面积
        HashMap<Integer, Integer> map = new HashMap<>();
        int islandIndex = 1;
        // 标记岛屿 + 统计岛屿面积存放在map中
        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                if(grid[i][j] == 1) {
                    islandIndex++;
                    map.put(islandIndex, dfs(grid, i, j, islandIndex));
                }
            }
        }

        // 当没有岛屿可以填平时，原来的岛即是最大岛
        if(row * col == map.getOrDefault(grid[0][0], 0))
            return row * col;

        // 人工填岛
        int maxArea = 0;
        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                // 不是水则跳过
                if(grid[i][j] != 0)
                    continue;
                // 造岛后计算总面积
                HashSet<Integer> set = new HashSet<>();
                int area = 1;
                if(i > 0 && grid[i-1][j] != 0)
                    set.add(grid[i-1][j]);
                if(j > 0 && grid[i][j-1] != 0)
                    set.add(grid[i][j-1]);
                if(i < row-1 && grid[i+1][j] != 0)
                    set.add(grid[i+1][j]);
                if(j < col-1 && grid[i][j+1] != 0)
                    set.add(grid[i][j+1]);

                for(int idx:set)
                    area += map.get(idx);
                maxArea = Math.max(maxArea, area);
            }
        }

        return maxArea;
    }

    public static void main(String[] args) {
        int[][] grid = new int[][]{{1, 0}, {0, 1}};
        code827 c = new code827();
        int a = c.largestIsland(grid);
    }
}
