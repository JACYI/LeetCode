package graph;

/**
 * @Author yiyonghao
 * @Date 2023/1/21 12:09
 */
public class code130 {
    private void dfs(char[][] board, char target, int i, int j) {
        if(i >= board.length || i < 0 || j >= board[0].length || j <= 0 || board[i][j] != 'O')
            return;

        board[i][j] = target;

        dfs(board, target, i+1, j);
        dfs(board, target, i, j+1);
        dfs(board, target, i-1, j);
        dfs(board, target, i, j-1);
    }
    public void solve(char[][] board) {
        int m = board.length, n = board[0].length;
        for(int i=0; i<m; i++) {
            if(board[i][0] == 'O')
                dfs(board, 'F', i, 0);
            if(board[i][n-1] == 'O')
                dfs(board, 'F', i, n-1);
        }
        for(int j=0; j<n; j++) {
            if(board[0][j] == 'O')
                dfs(board, 'F', 0, j);
            if(board[m-1][j] == 'O')
                dfs(board, 'F', m-1, j);
        }


        for(int i=0; i < m; i++) {
            for(int j=0; j < n; j++) {
                board[i][j] = board[i][j] == 'F' ? 'O' : 'X';
            }
        }
    }
    // 并查集
    // 将与边相连的O加入并查集，然后，将其他置为X，并查集中的元素置为O（特殊元素）
    public void solve2(char[][] board) {
        int m = board.length, n = board[0].length;
        // 假设并查集的特殊元素的祖先是m * n（最后一个元素）
        UnionFind unionFind = new UnionFind(m*n + 1);
        for(int i=0; i<m; i++){
            if(board[i][0] == 'O')
                unionFind.union(i * n, m * n);
            if(board[i][n-1] == 'O')
                unionFind.union(i * n + n - 1, m * n);
        }
        for(int j=0; j<n; j++){
            if(board[0][j] == 'O')
                unionFind.union(j, m * n);
            if(board[m-1][j] == 'O')
                unionFind.union((m-1) * n + j, m * n);
        }
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++){
                board[i][j] = unionFind.find(i * n + j) == m * n ? 'O' : 'X';
            }
        }
    }
}
