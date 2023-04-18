package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author yiyonghao
 * @Date 2023/1/16 21:48
 */
public class code886 {
    public void build(List<Integer>[] graph, int[][] edges) {
        for(int i=0; i<graph.length; i++) {
            graph[i] = new ArrayList<Integer>();
        }
        for(int[] edge : edges) {
            graph[edge[0]-1].add(edge[1]-1);
            graph[edge[1]-1].add(edge[0]-1);
        }
    }
    boolean[] visited;
    boolean[] color;    // false 与 true颜色不同
    boolean res = true;
    public void traverse(List<Integer>[] graph, int index) {
        if(!res)
            return;
        visited[index] = true;
        List<Integer> neighbours = graph[index];
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
    public boolean possibleBipartition(int n, int[][] dislikes) {
        List<Integer>[] graph = new ArrayList[n];
        build(graph, dislikes);

        visited = new boolean[n];
        color = new boolean[n];

        for(int i=0; i<n; i++) {
            if(!res)
                return false;
            if(!visited[i])
                traverse(graph, i);
        }
        return res;
    }
}
