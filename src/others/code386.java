package others;

import java.util.ArrayList;
import java.util.List;

public class code386 {
    public static List<Integer> lexicalOrder(int n) {
        List<Integer> res = new ArrayList<>();
        int prefix = 1;
        while(prefix <= n) {
            res.add(prefix);
            if(res.size() == n) break;
            if(prefix*10 <= n){
                prefix *= 10;
            }
            else {
                while (prefix + 1 > n || prefix % 10 == 9) {
                    prefix /= 10;
                }
                prefix += 1;
            }
        }
        return res;
    }
    public static void main(String[] args) {
        List<Integer> a = lexicalOrder(20);
        for(int b:a)
            System.out.println(b);
    }
}
