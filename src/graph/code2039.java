package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class code2039 {

    public static int networkBecomesIdle(int[][] edges, int[] patience){
        int n = patience.length;
        Queue<Integer> queue = new LinkedList<>();
        List<Integer>[] graph = new List[n];
        int dist = -1;
        for(int i=0;i<n;i++){
            graph[i] = new ArrayList<Integer>();
        }
        // 构建邻接矩阵数组
        for(int[] edge:edges){
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }
        boolean[] visited = new boolean[n];
        queue.offer(0);
        // BFS
        int last = 0;
        while(!queue.isEmpty()) {
            Queue<Integer> temp = new LinkedList<>();
            while (!queue.isEmpty()) {
                last = queue.poll();
                for (int adj : graph[last])
                    if (!visited[adj])
                        temp.offer(adj);
                visited[last] = true;
            }
            dist++;
            queue = temp;
        }

        // 计算0到各点的最近距离的最大值
        return 4*dist -(2*dist-1)%patience[last];
    }
    public static void main(String[] args){

    }
}
