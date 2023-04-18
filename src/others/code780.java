package others;

public class code780 {
    public static boolean reachingPoints(int sx, int sy, int tx, int ty){
        // 两点重合
        if(sx == tx && sy == ty) return true;
        // 终点不能在起点左边和下面和 y=x 上
        if(sx > tx || sy > ty || tx == ty) return false;
        while(sx <= tx && sy <= ty && tx != ty){
            if(tx > ty)
                tx %= ty;
            else
                ty %= tx;
            if(tx == sx && ty == sy) return true;
            else if(tx == 0) return (sy > ty)&&(sx % sy == 0);
            else if(ty == 0) return (sx > tx)&&(sy % sx == 0);
        }
        return false;
    }
    public static void main(String[] args){
        System.out.println(reachingPoints(1,4,999999998,4));
    }
}
