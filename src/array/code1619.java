package array;

import java.util.Arrays;

public class code1619 {
    public double trimMean(int[] arr) {
        HeapSort.heapSort(arr);
        int sum = 0;
        for(int i = 0; i<arr.length; i++){
            if(i<arr.length/20 || i >= (arr.length-arr.length/20))
                continue;
            sum += arr[i];
        }
        return sum * 9. / 10.;
    }
}
