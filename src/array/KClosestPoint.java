package array;

import java.util.*;
public class KClosestPoint {
    public static void main(String[] args) {
        int[][] points = new int[2][2];
        Comparator<CPoint>com = (CPoint c1,CPoint c2) -> c1.dist.compareTo(c2.dist);
        PriorityQueue<CPoint> pq = new PriorityQueue<>(2,com.reversed());
        Double dist = Math.sqrt(Math.pow((points[0][0]),2)+Math.pow(points[0][1],2));
        CPoint c1 = new CPoint();
        c1.index =1;
        c1.dist = 10.0;
        pq.add(c1);
        System.out.println(pq.remove());
    }
}


class CPoint{
    public int index;
    public Double dist;
}