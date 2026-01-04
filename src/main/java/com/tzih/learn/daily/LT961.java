package com.tzih.learn.daily;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LT961 {
    public int repeatedNTimes(int[] nums) {
        int n = nums.length;
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) {
                return num;
            } else {
                set.add(num);
            }
        }
        return -1;
    }
}
