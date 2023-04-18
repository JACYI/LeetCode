package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class code417 {
    private int[][] heights;
    private int m, n;
    public void dfs(boolean[][] coulds, int i, int j) {
        if(coulds[i][j]) return;
        coulds[i][j] = true;
        if(i<m-1 && heights[i+1][j] >= heights[i][j])
            dfs(coulds, i+1, j);
        if(j<n-1 &&heights[i][j+1] >= heights[i][j])
            dfs(coulds, i, j+1);
        if(i>0 && heights[i-1][j] >= heights[i][j])
            dfs(coulds, i-1, j);
        if(j>0 && heights[i][j-1] >= heights[i][j])
            dfs(coulds, i, j-1);
    }
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        this.m = heights.length;
        this.n = heights[0].length;
        this.heights = heights;
        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];
        List<List<Integer>> res = new ArrayList<>();
        for(int i=0; i<m; i++)
            dfs(pacific, i, 0);
        for(int j=1; j<n; j++)
            dfs(pacific, 0, j);
        for(int i=0; i<m; i++)
            dfs(atlantic, i, n-1);
        for(int j=0; j<n-1; j++)
            dfs(atlantic, m-1, j);
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(pacific[i][j] && atlantic[i][j])
                    res.add(new ArrayList<>(Arrays.asList(i, j)));
            }
        }
        return res;
    }
    public static void main(String[] args) {
        code417 a = new code417();
        a.pacificAtlantic(new int[][]{{2,1},{1,2}});
    }
}
