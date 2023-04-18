package array;

public class code11 {
    public static void main(String[] args){

    }
    public static int maxArea(int[] height){
        int res = 0;
        int i =0;
        int j = height.length - 1;
        while(i<j){
            int s = Math.min(height[i], height[j]);
            res = Math.max(res, (j-i)*s);
            if(s == height[i])
                i++;
            else
                j--;
        }
        return res;
    }
}
