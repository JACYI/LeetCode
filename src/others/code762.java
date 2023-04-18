package others;

import java.util.HashSet;

public class code762 {
    public static int hanmingWeight(int number){
        if(number == 0) return 0;
        int weight = 0;
        do{
            number -= (number & -number);
            weight++;
        }while(number != 0);
        return weight;
    }
    public static int countPrimeSetBits(int left, int right){
        // 优化效率
        int[] zhishus = new int[]{2, 3, 5, 7, 11, 13, 17, 19};
        HashSet<Integer> set = new HashSet<>();
        for(int zhishu:zhishus)
            set.add(zhishu);
        zhishus = null;

        int res = 0;
        for(int i=left; i<=right; i++){
            int curnum = i;
            if(set.contains(Integer.bitCount(curnum)))
                res++;
        }
        return res;
    }
    public static void main(String[] args){
//        System.out.println(countPrimeSetBits(6, 10));
        System.out.println();
    }
}
