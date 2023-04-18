package priority_queue;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class code857 {
    public double mincostToHireWorkers(int[] quality, int[] wage, int k){
        class Node {
            int qlt;
            double r;
            Node(int _qlt, double _r) {
                qlt = _qlt;
                r = _r;
            }
        }
        Node[] nodes = new Node[quality.length];
        for(int i=0; i<quality.length; i++)
            nodes[i] = new Node(quality[i], wage[i] / (quality[i]+0.));
        // 按rate升序排列，quality大的在后面，时间复杂度O(nlogn)
        Arrays.sort(nodes, new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                if(o1.r == o2.r)
                    return Integer.compare(o1.qlt, o2.qlt);
                else
                    return Double.compare(o1.r, o2.r);
            }
        });
        // 维护k元素个堆，拥有较大的quality的Node优先被弹出
        PriorityQueue<Node> priorityQueue = new PriorityQueue<>(new Comparator<Node>(){
            @Override
            public int compare(Node o1, Node o2) {
                return Integer.compare(o2.qlt, o1.qlt);
            }
        });
        int sumQ = 0;
        double minR = nodes[k-1].r;
        int idx=0;
        // 建立优先队列堆，时间复杂度O(logn)
        for(; idx<k; idx++) {
            sumQ += nodes[idx].qlt;
            priorityQueue.offer(nodes[idx]);
        }
        double res = sumQ * minR;
        idx = k;
        // 插入删除时间复杂度O(logn)
        while(idx < nodes.length){
            minR = nodes[idx].r;
            sumQ += nodes[idx].qlt;
            priorityQueue.offer(nodes[idx]);
            sumQ -= priorityQueue.poll().qlt;
            res = Math.min(res, sumQ * minR);
            idx++;
        }

        return res;
    }
    public static void main(String[] args) {
        code857 c = new code857();
        c.mincostToHireWorkers(new int[]{1,2,3,4,5,6,7,8,9,10}, new int[]{10,9,8,7,6,5,4,3,2,1}, 5);
    }
}
