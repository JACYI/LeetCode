package graph;

/**
 * @Author yiyonghao
 * @Date 2023/1/21 13:41
 */
public class code990 {
    public boolean equationsPossible(String[] equations) {
        UnionFind unionFind = new UnionFind(26);
        for(String equation : equations) {
            if(equation.charAt(1) == '=')
                unionFind.union(equation.charAt(0) - 'a', equation.charAt(3) - 'a');
        }
        for(String equation : equations) {
            if(equation.charAt(1) == '!' && unionFind.isConnected(equation.charAt(0) - 'a', equation.charAt(3) - 'a'))
                return false;
        }


        return true;
    }
}
