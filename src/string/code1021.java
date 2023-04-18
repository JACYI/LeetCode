package string;

public class code1021 {
    public String removeOuterParentheses(String s) {
        StringBuffer ret = new StringBuffer();
        int left = 0;
        int right = 0;
        int pre = 0;
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i)=='(')
                left++;
            else
                right++;
            if(left==right) {
                ret.append(s, pre + 1, i);
                pre = i+1;
            }
        }
        return ret.toString();
    }
}
