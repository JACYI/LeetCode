package array;

public class code1652 {
    public int[] decrypt(int[] code, int k) {
        int len = code.length;
        if(0 == k) return new int[len];
        int[] res = new int[len];
        int[] preSums = new int[3*len];
        int a = 10%4;
        for(int i=0; i<3*len+1; i++){
            preSums[i+1] += preSums[i] + code[i%len];
        }
        for(int i=0; i<code.length; i++) {
            if(k > 0){
                res[i] = (preSums[i+len+k+1] - preSums[i+len+1]);
            }
            else{
                res[i] = (preSums[i+len] - preSums[i+len+k]);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        code1652 c = new code1652();
        c.decrypt(new int[]{2,4,9,3}, -2);

    }
}
