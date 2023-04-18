package graph;

/**
 * @Author yiyonghao
 * @Date 2023/1/21 13:26
 */
public class UnionFind {
    private final int[] parent;
    private int counts;

    public UnionFind(int n) {
        parent = new int[n];
        counts = n;
        for(int i=0; i<n; i++)
            parent[i] = i;
    }
    public int find(int p){
        if(parent[p] != p)
            parent[p] = find(parent[p]);
        return parent[p];
    }
    public void union(int p, int q) {
        int parentP = find(p);
        int parentQ = find(q);

        if(parentP == parentQ)
            return;
        parent[parentQ] = parentP;
        counts--;
    }
    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }
}
