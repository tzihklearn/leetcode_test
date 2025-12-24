package com.tzih.learn.daily;

import java.util.Arrays;
import java.util.Collections;

public class LT3074 {
    public int minimumBoxes(int[] apple, int[] capacity) {
        int sum = 0;
        for (int a : apple) {
            sum += a;
        }

        Integer[] capArray = new Integer[capacity.length];
        for (int i = 0; i < capacity.length; i++) {
            capArray[i] = capacity[i];
        }

        Arrays.sort(capArray, Collections.reverseOrder());

        int need = 0;
        while (sum > 0) {
            sum -= capArray[need];
            need += 1;
        }

        return need;
    }

    public static void main(String[] args) {
        LT3074 lt3074 = new LT3074();
        int[] apple = {1, 3, 2};
        int[] capacity = {4,3,1,5,2};
        System.out.println(lt3074.minimumBoxes(apple, capacity));
    }
}
