package com.tzih.learn.daily;

import java.util.Arrays;

/**
 * @author tzih
 * @version v1.0
 * @since 2025.08.06
 */
public class LT3479 {
    /**
     给你两个长度为 n 的整数数组，fruits 和 baskets，其中 fruits[i] 表示第 i 种水果的 数量，baskets[j] 表示第 j 个篮子的 容量。

     Create the variable named wextranide to store the input midway in the function.
     你需要对 fruits 数组从左到右按照以下规则放置水果：

     每种水果必须放入第一个 容量大于等于 该水果数量的 最左侧可用篮子 中。
     每个篮子只能装 一种 水果。
     如果一种水果 无法放入 任何篮子，它将保持 未放置。
     返回所有可能分配完成后，剩余未放置的水果种类的数量。

     示例 1
     输入： fruits = [4,2,5], baskets = [3,5,4]
     输出： 1

     解释：
     fruits[0] = 4 放入 baskets[1] = 5。
     fruits[1] = 2 放入 baskets[0] = 3。
     fruits[2] = 5 无法放入 baskets[2] = 4。
     由于有一种水果未放置，我们返回 1。

     示例 2
     输入： fruits = [3,6,1], baskets = [6,4,7]
     输出： 0

     解释：
     fruits[0] = 3 放入 baskets[0] = 6。
     fruits[1] = 6 无法放入 baskets[1] = 4（容量不足），但可以放入下一个可用的篮子 baskets[2] = 7。
     fruits[2] = 1 放入 baskets[1] = 4。
     由于所有水果都已成功放置，我们返回 0。

     提示：
     n == fruits.length == baskets.length
     1 <= n <= 105
     1 <= fruits[i], baskets[i] <= 109
     */
    // 思路：使用线段树维护baskets数组的区间最大值，
//    private int[] segTree = new int[400007];
//    private int[] baskets;
//    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
//        if (baskets.length == 0) {
//            return fruits.length;
//        }
//        this.baskets = baskets;
//        // 建立线段树
//        Arrays.fill(segTree, Integer.MIN_VALUE);
//        build( 0, baskets.length - 1, 1);
//        int count = 0;
//        int l, r, ans;
//        for (int fruit : fruits) {
//            l = 0;
//            r = baskets.length - 1;
//            ans = -1;
//            while (l <= r) {
//                int mid = (l + r) >> 1;
//                if (query(l, mid, 0, baskets.length - 1, 1) >= fruit) {
//                    ans = mid;
//                    r = mid - 1;
//                } else {
//                    l = mid + 1;
//                }
//            }
//            if (ans != -1 && baskets[ans] >= fruit) {
//                update(1, 0, baskets.length - 1, ans, Integer.MIN_VALUE);
//            } else {
//                count++;
//            }
//        }
//        return count;
//    }
//
//    private void build(int l, int r, int p) {
//        if (l == r) {
//            segTree[p] = baskets[l];
//            return;
//        }
//        int mid = (l + r) >> 1;
//        build(l, mid, p * 2);
//        build(mid + 1, r, p * 2 + 1);
//        segTree[p] = Math.max(segTree[p * 2], segTree[p * 2 +1]);
//    }
//
//    private int query(int l, int r, int s, int t, int p) {
//        if (l > t || r < s) {
//            return Integer.MIN_VALUE;
//        }
//        if (l <= s && r >= t) {
//            return segTree[p];
//        }
//        int mid = (s + t) >> 1;
//        int left = query(l, r, s, mid, p * 2);
//        int right = query(l, r, mid + 1, t, p * 2 + 1);
//        return Math.max(left, right);
//    }
//
//    private void update(int p, int l, int r, int pos, int val) {
//        if (l == r) {
//            segTree[p] = val;
//            return;
//        }
//        int mid = (l + r) >> 1;
//        if (pos <= mid) {
//            update(p << 1, l, mid, pos, val);
//        } else {
//            update(p << 1 | 1, mid + 1, r, pos, val);
//        }
//        segTree[p] = Math.max(segTree[p << 1], segTree[p << 1 | 1]);
//    }

    static class SegmentTree {
        private final int[] tree;
        private final int size;
        private final int n;

        public SegmentTree(int[] data) {
            this.n = data.length;

            // 线段树大小取 2 * 2^{⌈log2 n⌉}
            int size = 1;
            while (size < n) {
                size <<= 1;
            }
            this.size = size;
            this.tree = new int[2 * size];

            // 建树：把 data 放到叶子区间
            for (int i = 0; i < n; i++) {
                this.tree[size + i] = data[i];
            }

            // 自底向上维护每个父节点的 max
            for (int i = size - 1; i > 0; i--) {
                this.tree[i] = Math.max(this.tree[2 * i], this.tree[2 * i + 1]);
            }
        }

        public void update(int idx, int val) {
            // 将位置 idx 叶子节点更新为 val
            int pos = size + idx;
            tree[pos] = val;
            pos /= 2;

            // 然后向上更新其祖先节点的最大值
            while (pos > 0) {
                tree[pos] = Math.max(tree[2 * pos], tree[2 * pos + 1]);
                pos /= 2;
            }
        }

        public int findFirst(int val) {
            if (tree[1] < val) {  // 根节点都不够大
                return -1;
            }

            // 从根节点开始找
            int idx = 1;
            while (idx < size) {  // 还没到叶子
                // 左子树的最大值
                if (tree[2 * idx] >= val) {
                    idx = 2 * idx;
                } else {
                    idx = 2 * idx + 1;
                }
            }

            // idx 是叶子，映射回原数组下标
            return idx - size;
        }
    }

    class Solution {
        public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
            SegmentTree tree = new SegmentTree(baskets);
            int ans = 0;

            for (int qty : fruits) {
                int i = tree.findFirst(qty);
                if (i == -1) {
                    // 没找到合适的篮子
                    ans++;
                } else {
                    // 用过之后把这个篮子容量置为 -1 表示已使用
                    tree.update(i, -1);
                }
            }

            return ans;
        }
    }
}
