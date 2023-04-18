package graph;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author yiyonghao
 * @Date 2023/1/15 17:20
 */
public class code6924 {
    private void build(List<Integer>[] graph, int[][] edges) {
        for(int i=0; i<graph.length; i++)
            graph[i] = new ArrayList<>();
        for(int[] edge : edges) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }
    }

    // dfs
    public long dfs(List<Integer>[] graph, boolean[] visited, int cur) {
        if(visited[cur])
            return 0L;

        long addValue = 0;

        visited[cur] = true;

        for(int idx : graph[cur])
            addValue = Math.max(dfs(graph, visited, idx), addValue);

        visited[cur] = false;
        return values[cur] + addValue;
    }

    int[] values;
    public long maxOutput(int n, int[][] edges, int[] price) {
        // graph[i] 表示第i个节点的邻接表
        List<Integer>[] graph = new ArrayList[n];
        build(graph, edges);
        boolean[] visited = new boolean[n];
        values = price;

        long maxValue = 0;
        for(int i=0; i<n; i++) {
            long res = dfs(graph, visited, i);
            System.out.println(res);
            maxValue = Math.max(maxValue, res - price[i]);
        }
        return maxValue;
    }
}
