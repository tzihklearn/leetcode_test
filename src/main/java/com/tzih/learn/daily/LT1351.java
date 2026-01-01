package com.tzih.learn.daily;

public class LT1351 {
    public int countNegatives(int[][] grid) {
        int num = 0;
        int m = grid[0].length;
        int pos = grid[0].length - 1;

        for (int[] row : grid) {
            int i;
            for (i = pos; i >= 0; i--) {
                if (row[i] >= 0) {
                    if (i + 1 < m) {
                        pos = i + 1;
                        num += m - pos;
                    }
                    break;
                }
            }
            if (i == -1) {
                num += m;
                pos = -1;
            }
        }

        return num;
    }

    public static void main(String[] args) {
        LT1351 lt1351 = new LT1351();
        int[][] grid = {{4,3,2,-1},{3,2,1,-1},{1,1,-1,-2},{-1,-1,-2,-3}};
        System.out.println(lt1351.countNegatives(grid));
    }
}
