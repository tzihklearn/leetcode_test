package com.tzih.learn.daily;

public class LT2483 {
    public int bestClosingTime(String customers) {
        char[] charArray = customers.toCharArray();

        int res = 0;
        int min = Integer.MAX_VALUE;
        int now = 0;
        for (char c : charArray) {
            if (c == 'Y') {
                now++;
            }
        }
        min = now;
        int n = charArray.length;
        for (int i = 1; i <= n; i++) {
            if (charArray[i -1] == 'Y') {
                now--;
            } else if (charArray[i - 1] == 'N') {
                now++;
            }
            if (now < min) {
                min = now;
                res = i;
            }
        }
        return res;
    }
}
