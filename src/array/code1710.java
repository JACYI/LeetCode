package array;

import java.util.Arrays;
import java.util.Comparator;

public class code1710 {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, new Comparator<int[]>() {
            @Override
            public int compare(int[] ints1, int[] ints2) {
                return Integer.compare(ints2[1], ints1[1]);
            }
        });
        int curSize = 0;
        int sum = 0;
        int idx = 0;
        while(idx < boxTypes.length && curSize < truckSize) {
            int tempSize = Math.min(truckSize-curSize, boxTypes[idx][0]);

            sum += tempSize * boxTypes[idx][1];
            curSize += tempSize;
            idx++;

        }
        return sum;
    }
}
