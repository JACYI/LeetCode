package array;

public class code2024 {
    public static int getCount(String answerKey, int k, char c){
        if(answerKey.length() == 1) return 1;
        char[] answers = answerKey.toCharArray();
        int m = answers.length;
        int left = 0, right = 0;
        int var = 0, res = 0;
        char pivot = answers[0];
        for(right=0;right<m;right++){
            if(answers[right] == c)
                var++;
            while(var > k){
                if(answers[left] == c) var--;
                left++;
            }
            res = Math.max(res, right-left+1);
        }
        return res;
    }
    public static int maxConsecutiveAnswers(String answerKey, int k){

        return Math.max(getCount(answerKey, k, 'T'), getCount(answerKey, k, 'F'));
    }
    public static void main(String[] args){
        String s = "TTFF";
        System.out.println(maxConsecutiveAnswers(s, 2));
    }
}
