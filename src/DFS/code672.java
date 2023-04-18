package DFS;

import java.util.HashSet;

public class code672 {
    int max;
    public void dfs(int num, HashSet<Integer> set, int cri, int depth) {
        if(depth == max) return;
        int temp = num;
        // press 1
        num = ~temp & cri;
        set.add(num);
        dfs(num, set, cri, depth+1);

        // press 2
        num = (2 ^ temp) & cri;
        set.add(num);
        dfs(num, set, cri, depth+1);

        // press 3
        num = 5 ^ temp & cri;
        set.add(num);
        dfs(num, set, cri, depth+1);

        // press 4
        num = 4 ^ temp & cri;
        set.add(num);
        dfs(num, set, cri, depth+1);
    }
    public int flipLights(int n, int presses) {
        max = presses;
        int num = 7;
        if(n < 3) num >>= (3-n);
        HashSet<Integer> set = new HashSet<>();
        set.add(num);
        dfs(num, set, num, 0);
        return set.size();
    }

    public static void main(String[] args) {
        System.out.println(7 >> 1);
        int b = 7;
        int c = (5 ^ b) & b;
    }
}
