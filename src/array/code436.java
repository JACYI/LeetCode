package array;

import java.util.ArrayList;
import java.util.Comparator;

public class code436 {
    class Node{
        Node(int s, int i){
            start=s;
            index=i;
        }
        int start;
        int index;
    }
    public int binarySearch(ArrayList<Node> list, int target){
        if(list.get(list.size()-1).start < target) return -1;
        //返回Node.start大于或者等于target的最小节点的索引
        int left=0, right=list.size()-1;
        while(left<right){
            int mid = left+(right-left)/2;
            if(list.get(mid).start < target)
                left = mid + 1;
            else
                right = mid;
        }
        return left;
    }
    public int[] findRightInterval(int[][] intervals) {
        ArrayList<Node> map = new ArrayList<>();
        for(int i=0; i<intervals.length; i++){
            map.add(new Node(intervals[i][0], i));
        }
        map.sort(new Comparator<Node>() {
            public int compare(Node n1, Node n2){
                return n1.start-n2.start;
            }
        });
        int[] ret = new int[intervals.length];
        for(int i=0; i<intervals.length; i++){
            int idx = binarySearch(map, intervals[i][1]);
            ret[i] = idx == -1 ? -1:map.get(idx).index;
        }
        return ret;
    }
    public static void main(String[] args) {

    }
}
