package com.tzih.learn.daily;

public class LT1266 {
    public int minTimeToVisitAllPoints(int[][] points) {
        int res = 0;
        int x = points[0][0];
        int y = points[0][1];
        for (int i = 1; i < points.length; i++) {
            int x1 = points[i][0];
            int y1 = points[i][1];
            res += Math.max(Math.abs(x1 - x), Math.abs(y1 - y));
            x = x1;
            y = y1;
        }
        return res;
    }
}
