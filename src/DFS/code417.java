package DFS;

import java.util.ArrayList;
import java.util.List;

public class code417 {
    public void dfs(int[][] heights, boolean[][] ocean, int i, int j, int height){
        if(i < 0 || j < 0 || i >= heights.length || j >= heights[0].length || height > heights[i][j] || ocean[i][j])
            return;

        ocean[i][j] = true;

        dfs(heights, ocean, i-1, j, heights[i][j]);
        dfs(heights, ocean, i+1, j, heights[i][j]);
        dfs(heights, ocean, i, j-1, heights[i][j]);
        dfs(heights, ocean, i, j+1, heights[i][j]);
    }
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int row = heights.length;
        int col = heights[0].length;
        boolean[][] pacific = new boolean[row][col];
        boolean[][] atlantic = new boolean[row][col];
        dfs(heights, pacific, 0, 0, 0);
        for(int i=0; i<row; i++){
            dfs(heights, pacific, i, 0, 0);
            dfs(heights, atlantic, i, col-1, 0);
        }

        for(int j=0; j<col; j++){
            dfs(heights, pacific, 0, j, 0);
            dfs(heights, atlantic, row-1, j, 0);
        }
        List<List<Integer>> res = new ArrayList<>();
        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                if(pacific[i][j] && atlantic[i][j]){
                    List<Integer> temp = new ArrayList<>();
                    temp.add(i);
                    temp.add(j);
                    res.add(temp);
                }

            }
        }
        return res;
    }
}
