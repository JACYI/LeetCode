package others;

import java.util.Comparator;
import java.util.PriorityQueue;

public class code668 {
    public class Node{
        int value;
        int next;
        Node(int value, int next){
            this.value = value;
            this.next = next;
        }
    }
    public int count(int m, int n, int number){
        //返回比当前数number小的数的个数
        int sum = 0;
        for(int i=1; i<=m; i++){
            sum += Math.min(n, number/i);
        }
        return sum;
    }
    public int findKthNumber(int m, int n, int k) {
        int left = 1, right = m * n;
        while(left<right){
            int mid =left + (right-left)/2;
            int cnt = count(m, n, mid);
            if(cnt < k){
                left = mid+1;
            }
            else if(cnt >= k)
                right = mid;

        }
        return right;
//        PriorityQueue<Node> priorityQueue = new PriorityQueue<>(new Comparator<Node>() {
//            public int compare(Node n1, Node n2){
//                return Integer.compare(n1.value, n2.value);
//            }
//        });
//        for(int i=1; i<=m; i++){
//            priorityQueue.offer(new Node(i, i));
//        }
//        int cnt = 0;
//        while(cnt < k && !priorityQueue.isEmpty()){
//            Node cur = priorityQueue.poll();
//            if(++cnt == k) return cur.value;
//            if(cur.value < cur.next * n){
//                cur.value += cur.next;
//                priorityQueue.offer(cur);
//            }
//
//        }
//        return -1;
    }
    public static void main(String[] args) {
        code668 c = new code668();
        c.findKthNumber(3,3,5);
        System.out.println();
    }
}
