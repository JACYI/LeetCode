package graph;

/**
 * @Author yiyonghao
 * @Date 2023/1/21 13:19
 */
public class code323 {
    private int[] parent;
    private int count;  // 连通分量
    private boolean union(int p, int q) {
        int parentP = find(p);
        int parentQ = find(q);

        if(parentP == parentQ)
            return false;
        parent[parentQ] = parentP;
        count--;
        return true;
    }
    private boolean connected(int p, int q) {
        return find(p) == find(q);
    }
    private int find(int child) {
        // 压缩
        if(child != parent[child]){
            parent[child] = find(parent[child]);
        }
        return parent[child];
    }
    public int countComponents(int n, int[][] edges) {
        parent = new int[n];
        for(int i=0; i<n; i++){
            parent[i] = i;
        }
        count = n;

        for(int[] edge : edges) {
            if(union(edge[0], edge[1]))
                count--;
        }
        return count;
    }
}
