package com.tzih.learn.doubleWeek.dw163;/**
* @author tzih 
* @since 2025.08.16
* @version v1.0
*/
public class Q1 {
    /**
     Q1. 覆盖网格的最少传感器数目
     中等
     4 分
     给你一个 n × m 的网格和一个整数 k。
     一个放置在单元格 (r, c) 的传感器可以覆盖所有与 (r, c) 的 切比雪夫距离不超过 k 的单元格。
     两个单元格 (r1, c1) 和 (r2, c2) 之间的 切比雪夫距离 为 max(|r1 − r2|,|c1 − c2|)。
     你的任务是返回覆盖整个网格所需传感器的 最少 数量。

     示例 1:
     输入: n = 5, m = 5, k = 1
     输出: 4
     解释:
     当 k = 1 时，传感器可以覆盖所有与 (r, c) 的切比雪夫距离不超过 1 的单元格。
     在位置 (0, 3)、(1, 0)、(3, 3) 和 (4, 1) 放置传感器可以确保网格中的每个单元格都被覆盖。因此，答案是 4。

     示例 2:
     输入: n = 2, m = 2, k = 2
     输出: 1
     解释:
     当 k = 2 时，无论传感器放在哪个位置，单个传感器都可以覆盖整个 2 * 2 的网格。因此，答案是 1。

     提示:
     1 <= n <= 10^3
     1 <= m <= 10^3
     0 <= k <= 10^3
     */
    public int minSensors(int n, int m, int k) {
        if (n <= k && m <= k) {
            return 1;
        }
        if (k == 0) {
            return n * m;
        }
        int i, j;
        int res = Integer.MAX_VALUE;
        i = 2 * k + 1;
        j = 2 * k + 1;
        int x = 1, y = 1;
        while (i < n) {
            i += 2 * k + 1;
            x++;
        }
        while (j < m) {
            j += 2 * k + 1;
            y++;
        }
        res = Math.min(res, x * y);
        return res;
    }

    public static void main(String[] args) {
        Q1 q1 = new Q1();
        int res = q1.minSensors(6, 5, 1);
        System.out.println(res);
    }


}
