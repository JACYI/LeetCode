package string;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * @Author yiyonghao
 * @Date 2022/12/8 9:12
 */
public class code22 {
    int max;
    // left, right 表示当前位置的左右括号数
    public void dfs(HashSet<String> set, StringBuilder string, int location, int left, int right) {
        if (location == max) {
            set.add(string.toString());
            return;
        }
        // 1. location 之前的位置左括号的数量 >= 右括号的数量
        if (left == right) {
            string.append('(');
            dfs(set, string, location + 1, left + 1, right);
            string.deleteCharAt(string.length() - 1);
        } else {
            if (left < max / 2) {
                string.append('(');
                dfs(set, string, location + 1, left + 1, right);
                string.deleteCharAt(string.length() - 1);
            }
            string.append(')');
            dfs(set, string, location + 1, left, right + 1);
            string.deleteCharAt(string.length() - 1);
        }

    }
    public List<String> generateParenthesis(int n) {
        HashSet<String> res = new HashSet<>();
        // string 上限 2n
        StringBuilder string = new StringBuilder();
        max = n * 2;
        dfs(res, string, 0, 0, 0);
        return new ArrayList<>(res);
    }
}
