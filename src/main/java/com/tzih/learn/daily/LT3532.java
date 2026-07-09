package com.tzih.learn.daily;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LT3532 {
    /**
     * 给你一个整数 n，表示图中的节点数量，这些节点按从 0 到 n - 1 编号。
     *
     * 同时给你一个长度为 n 的整数数组 nums，该数组按 非递减 顺序排序，以及一个整数 maxDiff。
     *
     * 如果满足 |nums[i] - nums[j]| <= maxDiff（即 nums[i] 和 nums[j] 的 绝对差 至多为 maxDiff），则节点 i 和节点 j 之间存在一条 无向边 。
     *
     * 此外，给你一个二维整数数组 queries。对于每个 queries[i] = [ui, vi]，需要判断节点 ui 和 vi 之间是否存在路径。
     *
     * 返回一个布尔数组 answer，其中 answer[i] 等于 true 表示在第 i 个查询中节点 ui 和 vi 之间存在路径，否则为 false。
     * @param n
     * @param nums
     * @param maxDiff
     * @param queries
     * @return
     */
    public boolean[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {

        // 并查集，因为是非递减的数组，所以如果i、j联通，那一定有一个点k（i < k < j），也和i、j连通
        // 所以相互联通的节点可以理解为都在一个下标连续的区间内，而一个数组则被分隔为了数个不联通的区间
        // 所以只需要定义tags数组，记录每个节点的并查集标签，如果两个节点的标签相同，则两个节点是连通的

        int[] tags = new int[n];
        for (int i = 1; i < n; i++) {
            if (nums[i] - nums[i - 1] > maxDiff) {
                tags[i] = tags[i - 1] + 1;
            } else {
                tags[i] = tags[i - 1];
            }
        }

        boolean[] res = new boolean[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int x = queries[i][0];
            int y = queries[i][1];
            res[i] = tags[x] == tags[y];
        }
        return res;
    }
}
