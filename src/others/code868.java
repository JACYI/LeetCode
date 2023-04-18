package others;

public class code868 {
    public static int lowbit(int n) {
        return n & (-n);
    }
    public static int binaryDistance(int a, int b){
        if(b==0) return 0;
        int a1 = a;
        int b1 = b;
        int count = 0;
        while(a1 != b1){
            a1 /= 2;
            count ++;
        }
        return count;
    }
    public static int binaryGap(int n) {
        int pre = 0;
        int res = 0;
        while(n != 0){
            int cur = lowbit(n);
            res = Math.max(res, binaryDistance(cur, pre));
            n -= cur;
            pre = cur;
        }
        return res;
    }
    public static void main(String[] args) {
        binaryGap(22);
    }
}
