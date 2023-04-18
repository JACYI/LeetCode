package array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class code1606 {
    public static int getServerNum(HashMap<Integer, Integer> status, int time, int start, int k){
        int count = 0;
        for(int j=start; ;j=(j+1)%k){
            if(status.get(j) <= time) return j; // return server number
            count++;
            if(count == k) return -1;           // drop
        }
    }
    public static List<Integer> busiestServers(int k, int[] arrival, int[] load){
        int len = arrival.length;
        int[] times = new int[k];
        int maxTimes = 0;
        HashMap<Integer, Integer> status = new HashMap<>();
        for(int i=0; i<k; i++)
            status.put(i, 0);       // status存储（服务器号，空闲时间）
        for(int i=0; i<len; i++){
            int serNum = getServerNum(status, arrival[i], i%k, k);
            if(serNum == -1) continue;
            times[serNum]++;        // 任务数+1
            maxTimes = Math.max(times[serNum], maxTimes);
            status.put(serNum, arrival[i] + load[i]);
        }
        List<Integer> res = new ArrayList<>();
        for(int t=0; t<k; t++){
            if(times[t] == maxTimes) res.add(t);
        }
        return res;
    }
    public static void main(String[] args){
        System.out.println(busiestServers(2,new int[]{1,2,3},new int[]{1000000000,1,1000000000}));
    }
}
