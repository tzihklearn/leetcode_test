package com.tzih.learn.daily;


public class LT3655 {
    public int xorAfterQueries(int[] nums, int[][] queries) {
        for (int[] query : queries) {
            int idx = query[0];
            while (idx <= query[1] && idx < nums.length) {
                nums[idx] = Math.toIntExact(((long) nums[idx] * query[3]) % 1000000007);
                idx += query[2];
            }
        }
        int ans = 0;
        for (int num : nums) {
            ans ^= num;
        }
        return ans;
    }
}
