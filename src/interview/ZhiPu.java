package interview;

/**
 * @Author yiyonghao
 * @Date 2022/12/7 14:00
 */
public class ZhiPu {
    // 输入正方形矩阵，顺时针旋转90度
    public void rotate(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        if(m != n)
            return;
        // 对角线翻转
        for(int i=0; i<m; i++) {
            for (int j=i; j<n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        // 左右翻转 ->
        for(int i=0; i<m/2; i++) {
            for(int j=0; j<n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n - i - 1][j];
                matrix[n - i - 1][j] = temp;
            }
        }


        // 输出
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

    }
    public static void main(String[] args) {
        ZhiPu test = new ZhiPu();
        test.rotate(new int[][]{
                {1,2,3}, {4,5,6}, {7,8,9}
        });
    }
}
