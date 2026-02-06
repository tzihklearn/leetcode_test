package com.tzih.learn.daily;

import java.util.Arrays;

/**
 * @author tzih
 * @since 2026.02.06
 */
public class LT3634 {
    public int minRemoval(int[] nums, int k) {
        int n = nums.length;
        Arrays.sort(nums);

        int ans = n;
        int right = 0;

        for (int left = 0; left < n; left++) {
            while (right < n && nums[right] <= (long)nums[left] * k) {
                right++;
            }
            ans = Math.min(ans, n - (right - left));
        }

        return ans;
    }
}
