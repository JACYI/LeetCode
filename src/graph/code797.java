package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author yiyonghao
 * @Date 2023/1/11 22:07
 */
public class code797 {
    int n;
    List<List<Integer>> res;
    int[][] graph;

    public void dfs(int i, LinkedList<Integer> path) {
        if(i >= n)
            return;
        path.addLast(i);

        if(i == n - 1) {
            res.add(new ArrayList<>(path));
        }

        int[] directs = graph[i];
        for(int j : directs)
            dfs(j, path);
        path.removeLast();
    }
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        res = new ArrayList<>();
        n = graph.length;
        this.graph = graph;
        LinkedList<Integer> path = new LinkedList<>();
        dfs(0, path);
        return res;
    }
}
