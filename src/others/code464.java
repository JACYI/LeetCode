package others;

public class code464 {
    int desiredTotal;
    // 当前角色是否有机会赢
    public boolean dfs(boolean[] chosen, int sum){
        for(int i=chosen.length-1; i>=0; i--){
            if(chosen[i])
                continue;
            if(sum+i >= desiredTotal)
                return true;
            // 当选择了i后后面的玩家一定会输吗
            boolean[] chosen_copy = chosen.clone();
            chosen_copy[i] = true;
            if(!dfs(chosen_copy, sum+i))
                return true;
        }
        return false;
    }
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        boolean[] chosen = new boolean[maxChoosableInteger];
        this.desiredTotal = desiredTotal;

        return dfs(chosen, 0);
    }
    public static void main(String[] args){

    }
}
