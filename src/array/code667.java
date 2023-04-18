package array;

public class code667 {
    public int[] constructArray(int n, int k) {
        int[] res = new int[n];
        for(int i=0; i<n; i++) {
            res[i]=i+1;
        }
        int[] d = new int[k+1];
        d[0] = 1;
        for(int i=1; i<k+1; i++){
            if(i%2 == 0)
                d[i] = -(k-i+1);
            else
                d[i] = k-i+1;
        }
        for(int i=1; i<=k; i++){
            res[i] = res[i-1] + d[i];
        }
        return res;
    }
    public static void main(String[] args) {
        code667 c = new code667();
        c.constructArray(5, 4);
    }
}
