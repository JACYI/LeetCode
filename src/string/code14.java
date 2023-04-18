package string;

public class code14 {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length==1 || strs[0].length() == 0) return strs[0];
        StringBuffer string = new StringBuffer();
        for(int idx=0; idx<strs[0].length(); idx++){
            char temp = strs[0].charAt(idx);
            for(String str:strs){
                if(str.length() <= idx || str.charAt(idx) != temp)
                    return string.toString();
            }
            string.append(temp);
        }
        return string.toString();
    }
}
