package com.tzih.learn.daily;

import java.util.Arrays;

/**
 * @author tzih
 * @since 2021/12/27
 */
public class LT1877 {
    public int minPairSum(int[] nums) {
        Arrays.sort(nums);

        int n = nums.length;
        int ans = 0;

        for (int i = 0; i < n / 2; i++) {
            ans = Math.max(ans, nums[i] + nums[n - i - 1]);
        }
        return ans;
    }
}
