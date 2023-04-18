package string;

import java.util.Arrays;

public class code1592 {
    public String reorderSpaces(String text) {
        char[] texts = text.toCharArray();
        int spaceNum = 0;
        int wordNum = 0;
        int idx = 0;
        // 统计单词数以及空格数
        while(idx < texts.length){
            if(texts[idx] == ' '){
                spaceNum += 1;
                idx++;
            }
            else {
                wordNum += 1;
                while (idx < texts.length && texts[idx] != ' ')
                    idx++;
            }
        }
        char[] res = new char[texts.length];
        idx = 0;
        int resIdx = 0;
        // 找到第一个非空格字母的索引
        while(texts[idx] == ' ')
            idx++;
        Arrays.fill(res, ' ');
        while(resIdx < texts.length){
            while(idx < texts.length && texts[idx] != ' ') {
                res[resIdx++] = texts[idx++];
            }
            // 空格
            resIdx += spaceNum / (wordNum - 1);
            while(idx < texts.length && texts[idx] == ' ')
                idx++;
        }
        return new String(res);
    }
    public static void main(String[] args) {
        code1592 c = new code1592();
        System.out.println(c.reorderSpaces("jgj  fjf dkd"));;
    }
}
