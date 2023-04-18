package graph;

/**
 * @Author yiyonghao
 * @Date 2023/1/16 21:26
 */
public class code785 {
    boolean[] visited;
    boolean[] color;    // false 与 true颜色不同
    boolean res = true;
    public void traverse(int[][] graph, int index) {
        if(!res)
            return;
        visited[index] = true;
        int[] neighbours = graph[index];
        for(int neighbour : neighbours) {
            if(!visited[neighbour]) {
                color[neighbour] = !color[index];
                traverse(graph, neighbour);
            }
            else{
                // 已经染色，需要跟本节点的颜色clr不同
                if(color[index] == color[neighbour])
                    res = false;
            }
        }
    }
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        visited = new boolean[n];
        color = new boolean[n];
        // 图可能不是连通的，因此需要遍历所有节点
        for(int i=0; i<n; i++) {
            if(!visited[i])
                traverse(graph, i);
        }

        return res;
    }

    public static void main(String[] args) {
        code785 c = new code785();
        c.isBipartite(new int[][]{{1,3},{0,2}, {1,3},{0,2}});

    }
}
