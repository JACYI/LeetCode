package others;

public class code440 {
    // 返回字典树当前节点的子节点数
    public static long getCounts(int n, int perfix){
        if(perfix <= 0) return 0;
        long cur = perfix;
        long next = perfix + 1;
        long count = 0;
        while(cur <= n){
            count += Math.min(n+1, next) - cur;
            cur *= 10;
            next *= 10;
        }
        return count;
    }
    public static int findKthNumber(int n, int k) {
        if(n<=9) return k;
        int perfix = 1;
        long counts = 1;
        // 循环找到包含对应k的节点的
        while(counts < k){
            long cur_counts = getCounts(n, perfix);
            if(counts + cur_counts > k){
                // k在当前节点下
                perfix *= 10;
                counts += 1;
            }
            else{
                // k不在当前节点
                perfix ++;
                counts+=cur_counts;
            }
        }
        return perfix;
    }
    public static void main(String[] args){
        int res = findKthNumber(13, 2);
        System.out.println(Integer.MAX_VALUE);
//        int res = getCounts(112, 10);
        System.out.println(res);
    }
}
