package array;

public class code883 {
    public static int projectionArea(int[][] grid) {
        int s1 = 0, s2 = 0, s3 = 0;
        for(int i=0; i<grid.length; i++){
            int s3_i = 0;
            int s2_i = 0;
            for(int j=0;j<grid[0].length; j++){
                if(grid[i][j] != 0)
                    s1++;
                s3_i = Math.max(s3_i, grid[i][j]);
                s2_i = Math.max(s2_i, grid[j][i]);
            }
            s3 += s3_i;
            s2 += s2_i;
        }
        return s1 + s2 + s3;
    }
    public static void main(String[] args) {

    }
}
