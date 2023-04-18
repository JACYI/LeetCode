package array;

import java.util.HashSet;

public class code720 {
    public static String[] stringsMergeSort(String[] strings,int low,int high){
        int mid = (low+high)/2;
        if(low<high){
            stringsMergeSort(strings, low, mid);
            stringsMergeSort(strings, mid+1, high);
            //左右归并
            merge(strings, low, mid, high);
        }
        return strings;
    }

    public static void merge(String[] strings, int low, int mid, int high) {
        String[] temp = new String[high-low+1];
        int i= low;
        int j = mid+1;
        int k=0;
        // 把较小的数先移到新数组中
        while(i<=mid && j<=high){
            // 这个符号控制了归并排序是否稳定
            if(!stringsIsBiger(strings[j],strings[i]))
                temp[k++] = strings[i++];
            else
                temp[k++] = strings[j++];

        }
        // 把左边剩余的数移入数组
        while(i<=mid){
            temp[k++] = strings[i++];
        }
        // 把右边边剩余的数移入数组
        while(j<=high){
            temp[k++] = strings[j++];
        }
        // 把新数组中的数覆盖nums数组
        for(int x=0;x<temp.length;x++){
            strings[x+low] = temp[x];
        }
    }

    public static void stringsQuickSort(String[] strings, int left, int right){
        if(left >= right)
            return;
        String pivot = strings[left];
        int i = left;
        int j = right;
        while(i<j){
            while(i<j && !stringsIsBiger(strings[j], pivot))
                j--;
            strings[i] = strings[j];
            while(i<j && !stringsIsBiger(pivot, strings[i]))
                i++;
            strings[j] = strings[i];
        }
        strings[i] = pivot;
        stringsQuickSort(strings, left, i-1);
        stringsQuickSort(strings, i+1, right);
    }
    // b是否大于a
    static Boolean stringsIsBiger(String a, String b){
        if(a.length()>b.length())
            return false;
        else if(a.length()<b.length())
            return true;
        else{
            for(int i=0;i<a.length();i++){
                int temp = a.charAt(i) - b.charAt(i);
                if(temp < 0)
                    return true;
                else if(temp > 0)
                    return false;
            }
        }
        return false;
    }
    public static String longestWord(String[] words){
        stringsMergeSort(words, 0, words.length-1);
        HashSet<String> set = new HashSet<>();
        String res = "";
        for(String word:words){
            String pre = word.substring(0, word.length()-1);
            if(set.contains(pre)||pre.length()==0) {
                set.add(word);
                if(word.length() > res.length())
                    res = word;
            }
        }
        return res;
    }

    public static void main(String[] args){
        String[] s = {"a", "banana", "appl","w","wo","wor","worl","world", "ap", "apply", "apple"};
        System.out.println(longestWord(s));
//        stringsMergeSort(s, 0, s.length-1);
//        for(String a:s)
//            System.out.println(a);
    }
}
