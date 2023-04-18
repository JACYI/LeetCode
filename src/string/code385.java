package string;

import java.util.ArrayList;
import java.util.List;

class myNestedInteger implements NestedInteger {
    private int value;
    private boolean isInteger;
    private List<NestedInteger> list;
    public myNestedInteger(String s, int point){
        if(s.charAt(point) == '['){
            value = Integer.valueOf(null);
            isInteger = false;
        }
        else{
            isInteger = true;
            boolean flag = true;
            if(s.charAt(point) == '-'){
                flag = false;
                point++;
            }
            int end = point;
            do {
                end++;
            }while(s.charAt(end) - '0' < 0 || s.charAt(end) - '0' > 9);
            value = Integer.parseInt(s.substring(point, end));
            if(!flag) value = -value;
            point = end;
        }
        list = new ArrayList<>();
    }
    @Override
    public boolean isInteger() {
        return isInteger;
    }
    @Override
    public Integer getInteger() {
        return value;
    }

    @Override
    public void setInteger(int value) {
        this.value = value;
    }
    @Override
    public void add(NestedInteger ni) {
        list.add(ni);
    }
    @Override
    public List<NestedInteger> getList() {
        return list;
    }
}

public class code385 {

    public static NestedInteger deserialize(String s) {
        int point = 0;
        NestedInteger cur = new myNestedInteger(s, point);
        if(cur.isInteger()) return cur;
        while(point <= s.length()){
            NestedInteger temp = new myNestedInteger(s, point);
            if(!cur.isInteger())
                cur.add(temp);
        }
        return cur;
    }
    public static void main(String[] args) {

    }
}
