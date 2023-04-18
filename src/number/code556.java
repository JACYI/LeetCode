package number;

import java.util.Arrays;

public class code556 {
    public static void swap(char[] numbers, int start){
        int left = start, right = numbers.length - 1;
        while(left < right){
            char temp = numbers[left];
            numbers[left] = numbers[right];
            numbers[right] = temp;
            left++;
            right--;
        }
    }
    public static int nextGreaterElement(int n) {
        char[] numbers = String.valueOf(n).toCharArray();
        if(numbers.length < 2)
            return -1;

        int i = numbers.length - 2;
        while(i >= 0 && numbers[i] >= numbers[i+1])
            i--;
        if(i < 0)
            return -1;

        swap(numbers, i+1);


        int j = numbers.length - 1;
        while(numbers[j] > numbers[i])
            j--;

        char temp = numbers[j+1];
        numbers[j+1] = numbers[i];
        numbers[i] = temp;
        return Integer.parseInt(Arrays.toString(numbers));
    }
    public static void main(String[] args) {
        nextGreaterElement(2147483486);
    }
}
