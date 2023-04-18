package others;

public class code7 {
    public static void main(String[] args){
        System.out.println(reverse(-2147483648));
    }
    public static int reverse(int x){
        if (x == 0) return 0;
        long l = x;
        if(x<0)
            l = -l;
        StringBuilder temp = new StringBuilder();
        while(l > 0){
            temp.append(l%10);
            l/=10;
        }
        long a = Long.parseLong(temp.toString());
        if(x < 0)
            a = -a;
        if(a > Integer.MAX_VALUE || a < Integer.MIN_VALUE)
            return 0;
        else
            return (int)a;
    }
    // 别人的
    public static int reverse2(int x) {
        long n = 0;
        while(x != 0) {
            n = n*10 + x % 10;// 手动十进制左移
            x = x/10;
        }
        return (int)n==n? (int)n:0;// 判断是否越界
    }
}
