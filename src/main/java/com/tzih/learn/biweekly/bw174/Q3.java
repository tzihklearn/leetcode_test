package com.tzih.learn.biweekly.bw174;

public class Q3 {

    private static final int MOD = (int) 1e9 + 7;
    
    public int alternatingXOR(int[] nums, int target1, int target2) {
        int n = nums.length;
        // 使用前缀异或数组和记忆化搜索
        int[] prefixXor = new int[n + 1];
        for (int i = 0; i < n; i++) {
            prefixXor[i + 1] = prefixXor[i] ^ nums[i];
        }
        
        // memo[i][j] 表示从位置i开始，目标为target j 的方案数
        Integer[][] memo = new Integer[n][2];
        return dfs(0, 0, target1, target2, prefixXor, memo);
    }
    
    private int dfs(int pos, int turn, int target1, int target2, int[] prefixXor, Integer[][] memo) {
        // 到达末尾，找到一种有效分割
        if (pos == prefixXor.length - 1) {
            return 1;
        }
        
        if (memo[pos][turn] != null) {
            return memo[pos][turn];
        }
        
        int target = (turn == 0) ? target1 : target2;
        int result = 0;
        
        // 尝试从当前位置到数组末尾的所有可能子数组
        for (int end = pos + 1; end < prefixXor.length; end++) {
            // 计算从pos到end-1的异或值
            int currentXor = prefixXor[end] ^ prefixXor[pos];
            
            if (currentXor == target) {
                // 如果当前异或值等于目标值，则继续搜索
                // 切换目标
                int nextTurn = 1 - turn;
                result = (result + dfs(end, nextTurn, target1, target2, prefixXor, memo)) % MOD;
            }
        }
        
        memo[pos][turn] = result;
        return result;
    }

    public static void main(String[] args) {
        Q3 q3 = new Q3();
//        int[] nums = {2, 3, 1, 4};
//        int target1 = 1;
//        int target2 = 5;
        int[] nums = {1, 0, 0};
        int target1 = 1;
        int target2 = 0;
        System.out.println(q3.alternatingXOR(nums, target1, target2));
    }
}
