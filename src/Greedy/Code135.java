package Greedy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.IntStream;

/**
 * @Author yiyonghao
 * @Date 2023/3/13 21:37
 */
public class Code135 {
    public int candy(int[] ratings) {
        int len = ratings.length;
        int[] idx = new int[len];
        for(int i=0; i<len; i++)
            idx[i] = i;
        // 按照分数排序
        idx = IntStream.of(idx).boxed().sorted((o1, o2) -> ratings[o1] - ratings[o2]).mapToInt(Integer::intValue).toArray();

        int[] candy = new int[len];
        candy[idx[0]] = 1;
        // 排好序的索引依次遍历，确保当前糖果数大于两边的较大值
        for(int i=1; i<len; i++) {
            int left = idx[i] > 0 && (ratings[idx[i] - 1] < ratings[idx[i]]) ? candy[idx[i] - 1] : 0;
            int right = idx[i] < len - 1 && ratings[idx[i] + 1] < ratings[idx[i]] ? candy[idx[i] + 1] : 0;
            // + 1 保证大于
            candy[idx[i]] = Math.max(left, right) + 1;
        }
        return Arrays.stream(candy).sum();
    }

    public static void main(String[] args) {
        Code135 c = new Code135();
        c.candy(new int[]{1, 0, 2});
    }
}
