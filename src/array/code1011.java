package array;

public class code1011 {
    public int shipWithinDays(int[] weights, int days) {
        int min = 0, max = 0;
        for (int weight : weights) {
            min = Math.max(weight, min);
            max += weight;
        }
        while(min < max) {
            int mid = min + (max - min) / 2;
            int times = calTimes(weights, mid);
            if(times > days)
                min = mid + 1;
            else
                max = mid;
//            else
//                max = mid - 1;
        }
        return min;
    }
    public int calTimes(int[] weight, int maxWeight) {
        int index = 0;
        int times = 0;
        int sum = 0;
        while(index < weight.length) {
            if(sum + weight[index] <= maxWeight) {
                sum += weight[index];
            } else {
                sum = weight[index];
                times++;
            }
            index++;
        }
        return times;
    }
}
