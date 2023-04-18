package others;

public class code10 {
    public static void main(String[] args){
        System.out.println("sag".substring(0,0));
    }
    public static boolean isMatch(String s, String p){
        int i=s.length()-1,j=p.length()-1;
        while(i>=0 && j>=0){
            if(s.charAt(i) == p.charAt(j)){
                i--;
                j--;
            }
            else if(p.charAt(j) == '.')
            {
                i--;
                j--;
            }
            // * 的情况多种分类
            else if(p.charAt(j) == '*'){
                char c = p.charAt(--j);
                boolean res = false;
                // *表示0-n个字符
                do{
                    res |= isMatch(s.substring(0, i+1), p.substring(0, j));
                }while(s.charAt(i--)!=c || i<0);// while为真时结束循环
            }
            else
                return false;
        }
        return false;
    }
}
