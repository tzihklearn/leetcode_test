package com.tzih.learn.daily;

import java.util.Arrays;

public class LT3075 {
    public long maximumHappinessSum(int[] happiness, int k) {
        Arrays.sort(happiness);
        int n = happiness.length;
        int num = 0;
        long result = 0;
        for (int i = n - 1; i >= n - k; --i) {
            if (happiness[i] > num) {
                happiness[i] -= num;
            } else if (happiness[i] <= num) {
                happiness[i] = 0;
            }
            result += happiness[i];
            ++num;
        }
        return result;
    }

    public static void main(String[] args) {
        LT3075 lt3075 = new LT3075();
        int[] happiness = new int[]{1, 2, 3};
        int k = 2;
        System.out.println(lt3075.maximumHappinessSum(happiness, k));
    }
}
