package graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @Author yiyonghao
 * @Date 2023/1/23 14:45
 */
public class code1584 {
    public int minCostConnectPoints(int[][] points) {
        List<int[]> edges = new ArrayList<>();
        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                int value = Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]);
                edges.add(new int[]{i, j, value});
            }
        }
        Collections.sort(edges, (edge1, edge2) -> Integer.compare(edge1[2], edge2[2]));
//        edges.sort((edge1, edge2) -> Integer.compare(edge1[2], edge2[2]));
        for (Object object : edges)
            System.out.println(object);
        UnionFind unionFind = new UnionFind(points.length);

        int costs = 0;
        for (int[] edge : edges) {
            if (unionFind.isConnected(edge[0], edge[1]))
                continue;
            System.out.println(edge[0] + " " + edge[1] + " " + edge[2]);
            costs += edge[2];
            unionFind.union(edge[0], edge[1]);
        }
        return costs;
    }

    public static void main(String[] args) {
        code1584 c = new code1584();
        c.minCostConnectPoints(new int[][] {{0,0}, {2,2},{3,10},{5,2},{7,0}});
    }
}
