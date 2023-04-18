package DFS;

/**
 * @Author yiyonghao
 * @Date 2023/3/11 16:22
 */
public class Code79 {
    private boolean dfs(char[][] board, String word, int m, int i, int j, boolean[][] visited) {
        if(m == word.length())
            return true;
        if(i < 0 || i >= board.length || j < 0 || j >= board[0].length)
            return false;
        if(visited[i][j] || board[i][j] != word.charAt(m))
            return false;
        visited[i][j] = true;
        boolean res = dfs(board, word, m + 1, i + 1, j, visited) ||
                dfs(board, word, m + 1, i, j + 1, visited) ||
                dfs(board, word, m + 1, i - 1, j, visited) ||
                dfs(board, word, m + 1, i, j - 1, visited);
        visited[i][j] = false;
        return res;
    }
    public boolean exist(char[][] board, String word) {
        for(int i=0; i<board.length; i++) {
            for(int j=0; j<board[0].length; j++) {
                boolean[][] visited = new boolean[board.length][board[0].length];
                if(dfs(board, word, 0, i, j, visited))
                    return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Code79 c = new Code79();
        c.exist(new char[][]{{'A','B','C','E'},{'S','F','E','S'}, {'A','D','E','E'}}, "ABCESEEEFS");

    }
}
