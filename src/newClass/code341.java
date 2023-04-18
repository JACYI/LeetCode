package newClass;

import string.NestedInteger;

import java.util.*;

/**
 * @Author yiyonghao
 * @Date 2023/1/8 20:47
 */

class NestedIterator implements Iterator<Integer> {

    private Deque<NestedInteger> stack;

    private void dfs(List<NestedInteger> nestedList) {

    }

    public NestedIterator(List<NestedInteger> nestedList) {
        stack = new ArrayDeque<>();
        if(nestedList.isEmpty())
            return;
        for(NestedInteger ni : nestedList)
            stack.addLast(ni);
    }

    @Override
    public Integer next() {
        return stack.pop().getInteger();
    }

    @Override
    public boolean hasNext() {
        // 1. 栈顶如果是Int不作任何处理

        // 2. 栈顶是list，将其展开为list
        while(!stack.isEmpty() && !stack.peek().isInteger()) {
            NestedInteger ni = stack.pop();
            List<NestedInteger> list = ni.getList();
            // 倒序展开
            for(int i=list.size() - 1; i>=0; i--) {
                stack.push(list.get(i));
            }
        }
        return !stack.isEmpty();
    }
}

public class code341 {

}
