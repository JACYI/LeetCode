package array;

import java.util.ArrayList;
import java.util.List;

public class code728 {
    public static boolean judge(int number){
        int temp = number;
        while(temp!=0){
            int res = temp % 10;
            if(res == 0) return false;
            if(number % res != 0) return false;
            temp/=10;
        }
        return true;
    }
    public static List<Integer> selfDividingNumbers(int left, int right){
        List<Integer> res = new ArrayList<>();
        for(int i = left;i<=right;i++){
            if(judge(i))
                res.add(i);
        }
        return res;
    }
    public static void main(String[] args){

    }
}
