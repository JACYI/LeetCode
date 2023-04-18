package newClass;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

class RandomizedSet {
    HashMap<Integer, Integer> indexMap;
    ArrayList<Integer> data;
    Random random;
    public RandomizedSet() {
        indexMap = new HashMap<>();
        data = new ArrayList<>();
        random = new Random();
    }

    public boolean insert(int val) {
        if(indexMap.containsKey(val)) return false;
        else{
            indexMap.put(val, data.size());
            data.add(val);
            return true;
        }
    }

    public boolean remove(int val) {
        if(!indexMap.containsKey(val)) return false;
        else{
            // 获取最后一个元素，覆盖目标元素
            int last = data.get(data.size()-1);
            int valIndex = indexMap.get(val);
            data.set(valIndex, last);
            data.remove(data.size()-1);
            // 更新哈希表
            indexMap.put(last, valIndex);
            indexMap.remove(val);
            return true;
        }
    }

    public int getRandom() {
        return data.get(random.nextInt(data.size()));
    }
}

public class code380 {
    public static void main(String[] args){
        RandomizedSet a = new RandomizedSet();
        System.out.println(a.insert(1));
        System.out.println(a.insert(2));
        System.out.println(a.remove(2));
        System.out.println(a.getRandom());

    }
}
