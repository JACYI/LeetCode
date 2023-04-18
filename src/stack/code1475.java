package stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class code1475 {
    public int[] finalPrices(int[] prices) {
//        int[] sub = new int[prices.length];
        // stack存储的是待打折的商品，等到后面有比当前栈内商品小的价格时，将商品依次弹出并打折
        Deque<Integer> stack = new ArrayDeque<>();
        for(int i=0; i<prices.length; i++){
            while(!stack.isEmpty() && prices[stack.peek()] >= prices[i])
                prices[stack.pop()] -= prices[i];
            stack.push(i);
        }
//        int[] res = new int[prices.length];
//        for(int i=0; i<res.length; i++)
//            res[i] = prices[i] - sub[i];
        return prices;
    }
}
