package com.tzih.learn.biweekly.bw174;

/**
 * @author tzih
 */
public class Q1 {
    public int[] bestTower(int[][] towers, int[] center, int radius) {
        int n = towers.length;
        int[] ans = {-1, -1};
        int maxQ = -1;
        for (int[] tower : towers) {
            if (Math.abs(tower[0] - center[0]) + Math.abs(tower[1] - center[1]) <= radius) {
                if (tower[2] == maxQ) {
                    if (tower[0] < ans[0] || (tower[0] == ans[0] && tower[1] < ans[1])) {
                        ans[0] = tower[0];
                        ans[1] = tower[1];
                    }
                } else if (tower[2] > maxQ) {
                    maxQ = tower[2];
                    ans[0] = tower[0];
                    ans[1] = tower[1];
                }
            }
        }
        return ans;
    }
}
