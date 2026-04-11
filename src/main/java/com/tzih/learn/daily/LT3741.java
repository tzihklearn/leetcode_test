package com.tzih.learn.daily;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LT3741 {
    public int minimumDistance(int[] nums) {
        int n = nums.length;
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                List<Integer> array = map.get(nums[i]);
                array.add(i);
            } else {
                List<Integer> array = new ArrayList<>();
                array.add(i);
                map.put(nums[i], array);
            }
        }

        int res = Integer.MAX_VALUE;
        for (List<Integer> array : map.values()) {
            if (array.size() >= 3) {
                int l = 0, r = 2;
                while (r < array.size()) {
                    if (array.get(r) - array.get(l) < res) {
                        res = array.get(r) - array.get(l);
                    }
                    ++l;
                    ++r;
                }
            }
        }
        if (res == Integer.MAX_VALUE) {
            return -1;
        }
        return res * 2;

    }
}
