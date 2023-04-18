package array;

public class code661 {
    // 区间前缀和
    public int[][] imageSmoother(int[][] img) {
        int m = img.length;
        int n = img[0].length;
        int[][] mem = new int[m+1][n+1];
        for(int i = 1; i < m+1; i++){
            for(int j = 1; j < n+1; j++){
                if(i==1)
                    mem[i][j] = mem[i][j-1] + img[i-1][j-1];
                else
                    mem[i][j] = mem[i][j-1] + img[i-1][j-1] + mem[i-1][j];
            }
        }
        int[][] res = new int[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++) {
                int left = 0;
                int right = 0;
                int top = 0;
                int bottom = 0;
                if(i != 0)
                    top = -1;
                if(i != m-1)
                    bottom = 1;
                if(j != 0)
                    left = -1;
                if(j != n-1)
                    right = 1;
                int sum = mem[i+1+bottom][j+1+right] + mem[i+top][j+left] - mem[i+top][j+1+right] - mem[i+1+bottom][j+left];
                res[i][j] = sum/(((bottom-top+1)*(right-left+1)));
            }
        }
        return res;
    }
//    public int[][] imageSmoother(int[][] img) {
//        int m = img.length;
//        int n = img[0].length;
//        int[][] mem = new int[m][n+1];
//        for(int i = 0;i<m;i++){
//            for(int j = 1;j<n+1;j++){
//                if(j==1)
//                    mem[i][j] = img[i][j-1];
//                else
//                    mem[i][j] = img[i][j-1]+mem[i][j-1];
//            }
//        }
//        int[][] res = new int[m][n];
//        for(int i = 0;i<m;i++){
//            for(int j = 0;j<n;j++){
//                int sum = 0;
//                int left = 0;
//                int right = 0;
//                int count = 0;
//                if(j != n-1)
//                    right = 1;
//                if(j != 0)
//                    left = -1;
//                // 上一行
//                if(i != 0) {
//                    sum += (mem[i - 1][j + right + 1] - mem[i - 1][j + left]);
//                    count += (right-left + 1);
//                }
//                // 所在行
//                sum+=(mem[i][j + right + 1] - mem[i][j + left]);
//                count += (right - left + 1);
//                if(i!=m-1) {
//                    sum += (mem[i + 1][j + right + 1] - mem[i + 1][j + left]);
//                    count += (right - left + 1);
//                }
//                res[i][j] = sum/(count);
//            }
//        }
//        return res;
//    }

    public static void main(String[] args){

    }
}
