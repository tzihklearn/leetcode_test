package com.tzih.learn.daily;

import java.util.List;

public class LT3314 {
    public int[] minBitwiseArray(List<Integer> nums) {
        int n = nums.size();
        int[] res = new int[n];
        
        for (int i = 0; i < n; i++) {
            int num = nums.get(i);
            boolean found = false;
            
            // 遍历可能的 ans[i] 值
            // 由于 OR 操作的性质，ans[i] 必须小于等于 nums[i]
            for (int ans = 0; ans <= num; ans++) {
                if ((ans | (ans + 1)) == num) {
                    res[i] = ans;
                    found = true;
                    break;
                }
            }
            
            // 如果没找到满足条件的值，设置为 -1
            if (!found) {
                res[i] = -1;
            }
        }
        
        return res;
    }
}
