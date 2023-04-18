package tree;

import java.util.ArrayList;
import java.util.List;

public class code2049 {
    List<Integer>[] childrens;
    int[] nodes;
    int len;
    // 返回当前节点为根节点的子树节点数
    int dfs(int root){
        List children = childrens[root];
        if(children == null) {
            nodes[root] = 1;
            return len-1;
        }
        int score = 1;
        for(Object node:children){
            int temp = dfs((int)node);
            score += temp;
        }
        return 0;
    }
    int countHighestScoreNodes(int[] parents){
        len = parents.length;
        if(len < 3) return 2;
        childrens = new List[len];  // 存储每个节点的子节点
        for(int i=1;i<len;i++){
            childrens[parents[i]].add(i);
        }
        dfs(0);
        return 0;
    }

    public static void main(String[] args){

    }
}
