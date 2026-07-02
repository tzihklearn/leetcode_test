package com.tzih.learn.daily;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

public class LT3286 {
    private static final int[][] DIRS = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};

    public boolean findSafeWalk(List<List<Integer>> grid, int health) {
        int m = grid.size();
        int n = grid.get(0).size();
        Integer[][] a = new Integer[m][];
        int[][] dis = new int[m][n];
        for (int i = 0; i < m; i++) {
            a[i] = grid.get(i).toArray(Integer[]::new);
            Arrays.fill(dis[i], Integer.MAX_VALUE);
        }

        dis[0][0] = a[0][0];
        Deque<int[]> q = new ArrayDeque<>();
        q.addFirst(new int[]{0, 0});
        while (!q.isEmpty()) {
            int[] p = q.pollFirst();
            int i = p[0];
            int j = p[1];
            for (int[] d : DIRS) {
                int x = i + d[0];
                int y = j + d[1];
                if (0 <= x && x < m && 0 <= y && y < n) {
                    int cost = a[x][y];
                    if (dis[i][j] + cost < dis[x][y]) {
                        dis[x][y] = dis[i][j] + cost;
                        if (cost == 0) {
                            q.addFirst(new int[]{x, y});
                        } else {
                            q.addLast(new int[]{x, y});
                        }
                    }
                }
            }
        }
        return dis[m - 1][n - 1] < health;
    }
}
