package com.tzih.learn.doubleWeek.dw180;

public class Q3 {
    public int minOperations(int[] nums) {
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0) {
                ans += findNearestPrime(nums[i]);
            } else {
                ans += findNearestNoPrime(nums[i]);
            }
        }
        return ans;
    }


    private int findNearestNoPrime(int num) {

        // 检查 num 本身是否是素数
        if (!isPrime(num)) {
            return 0;
        }

        int ans = 1;

        int upper = num + 1;

        while (true) {
            if (!isPrime(upper)) {
                return ans;
            }

            upper++;

            ++ ans;
        }
    }

    private int findNearestPrime(int num) {
        // 检查 num 本身是否是素数
        if (isPrime(num)) {
            return 0;
        }

        int ans = 1;
        
        int upper = num + 1;
        
        while (true) {
            if (isPrime(upper)) {
                return ans;
            }
            
            upper++;

            ++ ans;
        }
    }

    /**
     * 判断一个数是否是素数
     *
     * @param n 待判断的数
     * @return 如果是素数返回 true，否则返回 false
     */
    private boolean isPrime(int n) {
        if (n < 2) {
            return false;
        }
        if (n == 2) {
            return true;
        }
        if (n == 3) {
            return true;
        }
        if (n % 2 == 0) {
            return false;
        }
        for (int i = 3; i * i <= n; i += 2) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

}
