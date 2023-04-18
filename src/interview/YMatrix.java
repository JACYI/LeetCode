package interview;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @Author yiyonghao
 * @Date 2022/12/20 10:49
 */
public class YMatrix {
    /**
     * 要求
     * 请编程实现以下各题目, 请尽量优化你的程序以高效处理海量数据, 请注重代码风格与程序结构, 请以注释对程序的行为进行解释.  我们推荐你采用 C / C++ 进行答题, 但是你也可以选择任意你擅长的语言.  你可以使用语言自带的基础库, 如 C 中可使用 libc 提供的函数, C++ 中可以使用 STL.  可以假设内存大到足以容纳所有数据.
     * 任务 1
     * 基于以下 C 程序框架, 我们希望你实现 task1() 这个函数, 它把 rows 中所有满足 b >= 10 && b < 50 并且 a == 1000 || a == 2000 || a == 3000 的行的内容都打印到终端.
     * typedef struct Row
     * {
     *     int a;
     *     int b;
     * } Row;
     *
     * /*!
     *  * Task 1.
     *  *
     *  * Find out all the rows that sastify below conditions:
     *  *
     *  *     ((b >= 10 && b < 50) &&
     *  *      (a == 1000 || a == 2000 || a == 3000))
     *  *
     *  * Print them to the terminal, one row per line, for example:
     *  *
     *  *     1000,20
     *  *     1000,23
     *  *     2000,16
     *  *
     *  * @param nrows     The total number of rows.
     *  * @param rows      The rows, for example rows[0] is the first row.
     *  */
//     *void
//     *
//
//    task1(const Row *rows, int nrows)
//     *
//
//    {
//     *     /*
//     *      * TODO: implement this function.
//     *      */
//     *}
//     * @param args
//     */

    static class Row {
        int a;
        int b;
        public Row(int _a, int _b) {
            a = _a;
            b = _b;
        }
    }

    static void task1(Row[] rows, int nrows) {
        int cnt = 0;
        for(Row row : rows) {
            if((row.a == 1000 || row.a == 2000 || row.a == 3000) && (row.b >= 10 && row.b < 50)) {
                if (cnt++ < nrows)
                    System.out.println(row.a + "," + row.b);
            }
        }


    }
    // 查找 row.a = a 且b在[10, 50)范围内的row序列的左边界
    public static int binarySearchLeft(Row[] rows, int a) {
        int left = 0, right = rows.length;
        // 寻找 a=1000的范围的记录
        while(left < right){
            int mid = left + (right - left)/2;
            if(rows[mid].a < a || (rows[mid].a == a && rows[mid].b < 10))
                left = mid + 1;
            else
                right = mid;
        }
        return left;
    }
    // 查找 row.a = a 且b在[10, 50)范围内的row序列的右边界
    public static int binarySearchright(Row[] rows, int a) {
        int left = 0, right = rows.length;
        // 寻找 a=1000的范围的记录
        while(left < right){
            int mid = left + (right - left)/2;
            if(rows[mid].a > a || (rows[mid].a == a && rows[mid].b >= 50))
                right = mid;
            else
                left = mid + 1;
        }
        return left;
    }

    //
    static void task2(Row[] rows, int nrows) {
        int[] as = new int[]{1000, 2000, 3000};
        for(int a : as) {
            int left = binarySearchLeft(rows, a);
            for(int i=left; i<rows.length; i++) {
                if(rows[i].a == a && rows[i].b >= 10 && rows[i].b < 50)
                    System.out.println(rows[i].a + "," + rows[i].b);
            }
        }
    }


    /*
    在任务 2 的基础上, 我们期望你打印出的匹配行是按照 b 列进行排序的, 请实现 task3().  示例输出:
    2000,22
    1000,31
    2000,33
    */
    static class Node {
        // 表示row.a = a的序列的当前节点指向idx
        int a;
        int idx;
        Node(int a, int idx) {
            this.a = a;
            this.idx = idx;
        }
    }
    public static void task3(Row[] rows, int nrows) {
        // 优先队列去存储 每个符合条件的头指针k1left, k2left, k3left

        PriorityQueue<Node> queue = new PriorityQueue<>(new Comparator<Node>(){
            public int compare(Node n1, Node n2) {
                // 优先队列的比较器，由i1与i2对比转化为rows[i1]与rows[i2]的 "b" 的值进行比较
                return Integer.compare(rows[n1.idx].b, rows[n2.idx].b);
            }
        });
        // 加入a = 1000，2000和3000的三个序列的头指针的节点
        int k1left = binarySearchLeft(rows, 1000);
        if(k1left < rows.length)
            queue.offer(new Node(1000, k1left));
        int k2left = binarySearchLeft(rows, 2000);
        if(k2left < rows.length)
            queue.offer(new Node(2000, k2left));
        int k3left = binarySearchLeft(rows, 3000);
        if(k3left < rows.length)
            queue.offer(new Node(3000, k3left));

        int cnt = 0;
        // 优先队列依次取出数据
        while(!queue.isEmpty() && cnt < nrows){
            Node cur = queue.poll();
            if(cur.idx >= rows.length || rows[cur.idx].a != cur.a || rows[cur.idx].b >= 50 && rows[cur.idx].b < 10) {
                // 直接抛弃节点
                continue;
            }
            System.out.println(rows[cur.idx].a + "," + rows[cur.idx].b);
            cnt++;
            cur.idx += 1;       // 向后移动一位
            if(cur.idx < rows.length)
                queue.offer(cur);         // 重新加入队列
        }
    }



    /*

    任务 4
    在任务 3 的基础上, 如果 a 列上的匹配条件不只是 1000,2000,3000, 而是扩充成 1000,2000,3000,...,98000,99000, 你在任务 3 中进行的实现是否足够优化?  请针对这一场景实现 task4(), 再次提醒, 程序要能高效处理海量数据.

     */
    public static void task4(Row[] rows, int nrows, int[] aRange) {
        PriorityQueue<Node> queue = new PriorityQueue<>(new Comparator<Node>(){
            public int compare(Node n1, Node n2) {
                // 优先队列的比较器，由i1与i2对比转化为rows[i1]与rows[i2]的 "b" 的值进行比较
                return Integer.compare(rows[n1.idx].b, rows[n2.idx].b);
            }
        });
        // 加入a = 1000，2000和3000的三个序列的头指针的节点
        for(int a : aRange) {
            int left = binarySearchLeft(rows, a);
            if(left < rows.length)
                queue.offer(new Node(a, left));
        }
        int cnt = 0;
        // 优先队列依次取出数据
        while(!queue.isEmpty() && cnt < nrows){
            Node cur = queue.poll();
            if(cur.idx >= rows.length || rows[cur.idx].a != cur.a || rows[cur.idx].b >= 50 || rows[cur.idx].b < 10) {
                // 直接抛弃节点
                continue;
            }
            System.out.println(rows[cur.idx].a + "," + rows[cur.idx].b);
            cnt++;
            cur.idx += 1;       // 向后移动一位
            if(cur.idx < rows.length)
                queue.offer(cur);         // 重新加入队列
        }
    }

    public static void main(String[] args) {
        // 输入测试用例
        Row[] rows = new Row[]{
                new Row(1000, 1),
                new Row(1000, 10),
                new Row(1000, 31),
                new Row(1000, 49),
                new Row(1000, 50),
                new Row(1000, 56),
                new Row(1000, 72),
                new Row(1500, 12),
                new Row(1500, 34),
                new Row(2000, 10),
                new Row(2000, 22),
                new Row(2000, 33),
                new Row(2000, 50),
        };

        System.out.println("Task2的输出如下: ");
        task2(rows, 3);
        System.out.println("Task3的输出如下: ");
        task3(rows, 10);
        System.out.println("Task4的输出如下: ");
        task4(rows, 5, new int[]{500, 2000});
    }
}
