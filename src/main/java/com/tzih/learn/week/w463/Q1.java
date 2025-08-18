package com.tzih.learn.week.w463;

/**
 * @author tzih
 * @version v1.0
 * @since 2025.08.17
 */
public class Q1 {
    /**
     Q1. 按策略交易股票的最佳时机
     中等
     4 分
     给你两个整数数组 prices 和 strategy，其中：

     prices[i] 表示第 i 天某股票的价格。
     strategy[i] 表示第 i 天的交易策略，其中：
     -1 表示买入一单位股票。
     0 表示持有股票。
     1 表示卖出一单位股票。
     同时给你一个 偶数 整数 k，你可以对 strategy 进行 最多一次 修改。一次修改包括：

     选择 strategy 中恰好 k 个 连续 元素。
     将前 k / 2 个元素设为 0（持有）。
     将后 k / 2 个元素设为 1（卖出）。
     利润 定义为所有天数中 strategy[i] * prices[i] 的 总和 。

     返回你可以获得的 最大 可能利润。

     注意： 没有预算或股票持有数量的限制，因此所有买入和卖出操作均可行，无需考虑过去的操作。

     示例 1：
     输入： prices = [4,2,8], strategy = [-1,0,1], k = 2
     输出： 10
     解释：
     修改	策略	利润计算	利润
     原始	[-1, 0, 1]	(-1 × 4) + (0 × 2) + (1 × 8) = -4 + 0 + 8	4
     修改 [0, 1]	[0, 1, 1]	(0 × 4) + (1 × 2) + (1 × 8) = 0 + 2 + 8	10
     修改 [1, 2]	[-1, 0, 1]	(-1 × 4) + (0 × 2) + (1 × 8) = -4 + 0 + 8	4
     因此，最大可能利润是 10，通过修改子数组 [0, 1] 实现。

     示例 2：
     输入： prices = [5,4,3], strategy = [1,1,0], k = 2
     输出： 9
     解释：
     修改	策略	利润计算	利润
     原始	[1, 1, 0]	(1 × 5) + (1 × 4) + (0 × 3) = 5 + 4 + 0	9
     修改 [0, 1]	[0, 1, 0]	(0 × 5) + (1 × 4) + (0 × 3) = 0 + 4 + 0	4
     修改 [1, 2]	[1, 0, 1]	(1 × 5) + (0 × 4) + (1 × 3) = 5 + 0 + 3	8
     因此，最大可能利润是 9，无需任何修改即可达成。

     提示：
     2 <= prices.length == strategy.length <= 105
     1 <= prices[i] <= 105
     -1 <= strategy[i] <= 1
     2 <= k <= prices.length
     k 是偶数
     */
    public long maxProfit(int[] prices, int[] strategy, int k) {
        long sum = 0;
        for (int i = 0; i < strategy.length; i++) {
            sum += (long) strategy[i] * prices[i];
        }
//        long ans = sum;
//        long res = sum;
//        for (int i = 0; i <= prices.length - k; i++) {
//            ans = sum;
//            for (int j = i; j < i + k; j++) {
//                ans -= (long) prices[j] * strategy[j];
//                // 2/k之后
//                if ((j - i) * 2 >= k) {
//                    ans += prices[j];
//                }
//            }
//            if (ans > res) {
//                res = ans;
//            }
//        }
        int i = 0, j = 0;
        long t1 = 0, t2 = 0;
        int n = prices.length;
        for (i = 0; i < k; i++) {
            t1 += (long) prices[i] * strategy[i];
            if (i * 2 >= k) {
                t2 += prices[i];
            }
        }
        long t3 = t2 - t1;
        i = 0;
        j = k - 1;
        while (j < n - 1) {
            t1 -= (long) prices[i] * strategy[i];
            ++i;
            ++j;
            t1 += (long) prices[j] * strategy[j];
            t2 += prices[j];
            t2 -= prices[(i+j)/2];
            if (t2 - t1 > t3) {
                t3 = t2 - t1;
            }
        }
        if (t3 < 0) {
            return sum;
        }
        return sum + t3;
    }

    public static void main(String[] args) {
//        int[] prices = {4,2,8};
//        int[] strategy = {-1,0,1};
//        int[] prices = {5,4,3};
//        int[] strategy = {1,1,0};
//        int[] prices = {8,5};
//        int[] strategy = {1,-1};
        int[] prices = {4,7,13};
        int[] strategy = {-1,-1,0};
        int k = 2;
        Q1 q1 = new Q1();
        System.out.println(q1.maxProfit(prices, strategy, k));
    }
}
