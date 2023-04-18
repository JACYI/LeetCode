package graph;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author yiyonghao
 * @Date 2023/1/12 21:19
 */
public class code207 {
    public void build(List<Integer>[] adjacent, int[][] prerequisites){
        for(int i=0; i<adjacent.length; i++) {
            adjacent[i] = new ArrayList<>();
        }
        for(int[] edge : prerequisites) {
            adjacent[edge[0]].add(edge[1]);
        }
    }
    public void dfs(List<Integer>[] adjacent, int course) {
        // 环
        if(onPath[course]){
            res = false;
            return;
        }
        // 学过了或者已经学不完了
        if(visited[course] || !res){
            return;
        }

        List<Integer> preCourse = adjacent[course];
        onPath[course] = true;
        for(int pre : preCourse) {
            dfs(adjacent, pre);
        }
        onPath[course] = false;
        visited[course] = true;
    }
    boolean[] visited;
    boolean[] onPath;
    boolean res;
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] adjacent = new ArrayList[numCourses];
        build(adjacent, prerequisites);

        visited = new boolean[numCourses];
        onPath = new boolean[numCourses];
        res = true;

        for(int i=0; i<numCourses; i++)
            dfs(adjacent, i);
        return res;
    }
}

