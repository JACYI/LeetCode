package Algorithm;

import java.util.*;

class Point{
    int x;
    int y;
    Point(int _x, int _y){
        x = _x;
        y = _y;
    }
}
class a {
    public List<Point> outerTrees(Point[] points) {
        List<Point> pp = Arrays.asList(points);
        helper(pp,true);
        helper(pp, false);
        return new ArrayList<>(ans);
    }

    Set<Point> ans = new HashSet<>();
    private void helper(List<Point> points, boolean calcuConvex){
        if (points.size() == 0) return;
        Collections.sort(points, new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                return o1.x != o2.x ? o1.x - o2.x : o1.y - o2.y;
            }
        });
        int fir = 0;
        int lst = points.size() - 1;

        ans.add(points.get(fir));
        ans.add(points.get(lst));

        if (points.size() == 2)
            return;

        // oneLine
        boolean isLine = true;
        for (int i = 0; i < points.size(); i++) {
            if (i == fir || i == lst)
                continue;
            if (calcuTriangle(points.get(fir), points.get(lst), points.get(i)) != 0) {
                isLine = false;
                break;
            }
        }
        if (isLine) {
            ans.addAll(points);
            return;
        }

        int maxIndex = -1;
        int max = 0;
        for (int i = 0; i < points.size(); i++) {
            if (i == fir || i == lst)
                continue;
            // 上凸包
            if (calcuConvex && calcuTriangle(points.get(fir), points.get(lst), points.get(i)) > max) {
                maxIndex = i;
                max = calcuTriangle(points.get(fir), points.get(lst), points.get(i));
            }
            // 下凸包
            if (!calcuConvex && -calcuTriangle(points.get(fir), points.get(lst), points.get(i)) > max) {
                maxIndex = i;
                max = -calcuTriangle(points.get(fir), points.get(lst), points.get(i));
            }
        }

        if (maxIndex == -1) {
            return;
        }

        // c1表示当前上凸包
        List<Point> c1 = new ArrayList<>();
        split(fir, maxIndex, points, c1, calcuConvex);
        helper(c1,calcuConvex);

        //c2表示当前的下凸包
        List<Point> c2 = new ArrayList<>();
        split(lst, maxIndex, points, c2, !calcuConvex);
        helper(c2,calcuConvex);
    }

    // 按照a1->a2直线将points点集分为上下两个凸包，isConvex=true表示上凸包，false表示下凸包
    // 划分后的点保存在part1中，上下凸包均包含边界点
    private void split(int a1, int a2, List<Point> points, List<Point> part1, boolean isConvex) {
        for (int i = 0; i < points.size(); i++) {
            if (i == a1 || i == a2) {
                part1.add(points.get(i));
                continue;
            }
            if (isConvex && calcuTriangle(points.get(a1), points.get(a2), points.get(i)) >= 0) {
                part1.add(points.get(i));
            }

            if (!isConvex && calcuTriangle(points.get(a1), points.get(a2), points.get(i)) <= 0) {
                part1.add(points.get(i));
            }
        }
    }

    private int calcuTriangle(Point a1, Point a2, Point a3) {
        return a1.x * a2.y + a3.x * a1.y + a2.x * a3.y
                - a3.x * a2.y - a2.x * a1.y - a1.x * a3.y;
    }
}

public class code812 {
    public double largestTriangleArea(int[][] points) {
        return 0.;
    }
    public static void main(String[] args) {

    }
}
