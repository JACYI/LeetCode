package graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Author yiyonghao
 * @Date 2023/1/12 21:42
 */
public class code210 {

    boolean[] onPath;
    boolean[] visited;
    boolean canFin;
    List<Integer> postOrder;

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
            canFin = false;
            return;
        }
        // 学过了或者已经学不完了
        if(visited[course] || !canFin){
            return;
        }

        List<Integer> preCourse = adjacent[course];
        onPath[course] = true;
        for(int pre : preCourse) {
            dfs(adjacent, pre);
        }
        onPath[course] = false;
        visited[course] = true;
        // 后序遍历
        postOrder.add(course);
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        onPath = new boolean[numCourses];
        visited = new boolean[numCourses];
        postOrder = new ArrayList<>();
        canFin = true;

        List<Integer>[] adjacent = new ArrayList[numCourses];
        build(adjacent, prerequisites);

        for(int i=0; i<numCourses; i++) {
            dfs(adjacent, i);
        }

        if(!canFin)
            return new int[]{};

        int[] res = new int[numCourses];
        for(int i=0; i<numCourses; i++) {
            res[i] = postOrder.get(i);
        }
        return res;
    }
}
