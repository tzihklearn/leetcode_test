package com.tzih.learn.daily;

import java.util.Arrays;
import java.util.Map;

public class LT1331 {
    public int[] arrayRankTransform(int[] arr) {
        int n = arr.length;
        int[] copy = Arrays.copyOf(arr, n);
        Arrays.sort(copy);
        int[] ans = new int[n];
        Map<Integer, Integer> rank = new java.util.HashMap<>();
        for (int i = 0; i < n; i++) {
            if (!rank.containsKey(copy[i])) {
                rank.put(copy[i], rank.size()+1);
            }
        }
        for (int i = 0; i < n; i++) {
            ans[i] = rank.get(arr[i]);
        }
        return ans;
    }

}
