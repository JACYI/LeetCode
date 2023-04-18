package Algorithm;

import java.util.*;

public class ConvexHull {
    HashSet<Point> ret = new HashSet<>();
    public Object[] convexHull (Point[] points) {
        List<Point> pointList = Arrays.asList(points);
        halfConvexHull(pointList, true);
        halfConvexHull(pointList, false);
        return ret.toArray();
    }
    public void halfConvexHull(List<Point> points, boolean up_or_down){
        points.sort(new Comparator<Point>(){
            public int compare(Point p1, Point p2){
                return p1.x != p2.x ? p1.x-p2.x : p1.y-p2.y;
            }
        });
        int first=0, last=points.size()-1;
        // point 表示当前点集，up_or_down表示求上凸包还是下凸包
        ret.add(points.get(first));
        ret.add(points.get(last));
        if(ret.size() <= 2)
            return;

        // 判断points中的点是否在同一直线
        boolean isLine = true;
        for(int i=first; i<=last; i++){
            if(i==first || i==last)
                continue;
            if(crossProduct(points.get(first), points.get(last), points.get(i)) != 0)
                isLine = false;
        }
        if (isLine){
            ret.addAll(points);
            return;
        }

        //
        int maxLengthIndex = first;
        int maxLength = 0;
        for(int i=first+1; i<last; i++){
            // 求first->last, last->i围成三角形面积，省略/2操作，面积最大的对应点是边界点，若有多个最大值，取第一个
            int temp = crossProduct(points.get(first), points.get(last), points.get(i));
            if(!up_or_down)
                temp = -temp;
            if(temp > maxLength){
                maxLength = temp;
                maxLengthIndex = i;
            }
        }
        // 当前凸包的中点
        ret.add(points.get(maxLengthIndex));

        // 按这一点划分Points为两个上凸包点集，一个上凸包集以first->max为边界，另一以max->last为边界
        ArrayList<Point> points1 = split(points.get(first), points.get(maxLengthIndex), points, up_or_down);
        ArrayList<Point> points2 = split(points.get(maxLengthIndex), points.get(last), points, up_or_down);

        halfConvexHull(points1, up_or_down);
        halfConvexHull(points2, up_or_down);
    }
    public ArrayList<Point> split(Point first, Point last, List<Point> points, boolean up_or_down){
        ArrayList<Point> res = new ArrayList<>();
        for(int i=0; i<points.size(); i++){
            Point cur = points.get(i);
            if(cur==first||cur==last){
                res.add(cur);
                continue;
            }
            if(up_or_down && crossProduct(first, last, cur)>0)
                res.add(cur);
            if(!up_or_down && crossProduct(first, last, cur)<0)
                res.add(cur);
        }
        return res;
    }
    // 计算p1->p2 与 p2->p3的叉积
    // 大于0 则p3在p1->p2左边，小于0在右边，等于0在直线上
    public int crossProduct(Point p1, Point p2, Point p3){
        int x1 = p2.x-p1.x;
        int x2 = p3.x-p2.x;
        int y1 = p2.y-p1.y;
        int y2 = p3.y-p2.y;
        return x1*y2-x2*y1;
//        return (p2.x-p1.x)*(p3.y-p2.y) - (p3.x-p2.x)*(p2.y-p1.y);
    }
    public int[][] a(){
        return ret.toArray(new int[][]{});
    }
    public static void main(String[] args) {
        Point[] points = new Point[]{new Point(1,1), new Point(2,2), new Point(2,0), new Point(2,4), new Point(3,3), new Point(4,2)};
        ConvexHull convexHull = new ConvexHull();
    }
}
