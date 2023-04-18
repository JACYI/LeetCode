package string;

public class OneAway {
    public static boolean oneEditAway(String first, String second) {
        if(first.equals(second)) return true;

        int l1 = first.length(), l2 = second.length();
        // 修改一次不能完成任务
        if(l1-l2>1 || l2-l1>1) return false;
        if(l1 == l2){
            // 替换
            int count = 0;
            for(int i=0; i<l1; i++){
                if(first.charAt(i) != second.charAt(i)){
                    count++;
                    if(count >= 2) return false;
                }
            }
            return true;
        }
        else{
            // 增删
            if(l1 > l2){
                String temp = first;
                first = second;
                second = temp;
            }
            for(int i=0; i<second.length(); i++){
                if((second.substring(0,i) + second.substring(i+1)).equals(first)) return true;
            }
            return false;
        }
    }
    public static void main(String[] args) {
        System.out.println(oneEditAway("ab", "cd"));
        String a = "abcd";
        int i = 0;
        System.out.println(a.substring(0,i) + a.substring(i+1));
    }
}
