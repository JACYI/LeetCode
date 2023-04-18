package DP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * @Author yiyonghao
 * @Date 2023/3/2 16:34
 */
public class Code39 {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        HashSet<List<Integer>> res = new HashSet<>();
        dfs(res, candidates, target, new ArrayList<>(), 0);

        return new ArrayList<>(res);
    }
    private void dfs(HashSet<List<Integer>> res, int[] candidates, int target, List<Integer> cur, int idx){
        if(target == 0)
            res.add(new ArrayList<>(cur));
        if(idx == candidates.length)
            return;
        dfs(res, candidates, target, cur, idx + 1);

        if(target - candidates[idx] >= 0){
            cur.add(candidates[idx]);
            dfs(res, candidates, target - candidates[idx], cur, idx);
            cur.remove(cur.size() - 1);
        }
    }
}
