package graph;

public class code782 {
    public int movesToChessboard(int[][] board) {
        int n = board.length;
        // 任意一个正方形（4元素）内部要么全是0或1，要么两个0+两个1，异或为0
        for(int i=0; i<n-1; i++){
            for(int j=0; j<n-1; j++){
                if((board[i][j] ^ board[i+1][j] ^ board[i][j+1] ^ board[i+1][j+1]) != 0)
                    return -1;
            }
        }
        int rowOnes = 0;
        int colOnes = 0;
        int rowDiff = 0;
        int colDiff = 0;
        for(int i=0; i<n; i++){
            // 统计第一行和第一列1的个数
            rowOnes += board[i][0];
            colOnes += board[0][i];
            // 统计第一行和第一列与标准棋盘不相等位数
            rowDiff += board[i][0]==i%2 ? 1:0;
            colDiff += board[0][i]==i%2 ? 1:0;
        }
        // 如果第一行或者第一列的0个数与1个数相差超过2，不满足条件
        if(rowOnes < (n-1)/2 || rowOnes > (n+1)/2)
            return -1;
        if(colOnes < (n-1)/2 || colOnes > (n+1)/2)
            return -1;
        // 保证每行和每列不同位数总数最小且为偶数
        if(n%2 == 0){
            // 偶数行和列，0作为[0][0]的标准棋盘比较的不同位数与1作为[0][0]的标准棋盘不同位数相加等于n，取较小值
            rowDiff = Math.min(rowDiff, n-rowDiff);
            colDiff = Math.min(colDiff, n-colDiff);
        }
        else{
            // 奇数行和列，有可能出现rowDiff等于奇数情况，由于交换行和列不同位数会+2或者-2，无法处理奇数情况，因此需要更换目标标准棋盘(0->1)
            if(rowDiff%2 != 0)
                // 交换后和交换前不同位数之和等于0，同上
                rowDiff = n - rowDiff;
            if(colDiff%2 != 0)
                colDiff = n - colDiff;
        }
        // 交换一次列(或者行)降低行(或者列)2个不同位数
        return (rowDiff + colDiff)/2;
    }
}
