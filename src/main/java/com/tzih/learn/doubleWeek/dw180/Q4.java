package com.tzih.learn.doubleWeek.dw180;

import java.util.*;

public class Q4 {

    public int maxValue(int[] nums1, int[] nums0) {
        int n = nums1.length;

        List<Num> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            list.add(new Num(nums1[i], nums0[i]));
        }
        // 按照a来升序排序，如果a相等，则按照b来降序排序
//        list.sort((x, y) -> {
//            if (x.a != y.a) {
//                return Integer.compare(x.a, y.a);
//            }
//            return Integer.compare(y.b, x.b);
//        });
        int mod = 1000000007;
        list.sort((x, y) -> {
            double valX = x.a * Math.log(2) + x.b * Math.log(2); // log2(valX)
            double valY = y.a * Math.log(2) + y.b * Math.log(2);
            return Double.compare(valY, valX);
        });

//        int ans = 0;
//
//        int size = 0;
//        for (int i = 0; i < n; i++) {
//            Num num = list.get(i);
//            long value = calculateBinaryValue(num.a, num.b);
//            long shift = powMod(2, size, mod);
//            ans = (int) ((ans + value * shift % mod) % mod);
//            size += num.a + num.b;
//        }
        long ans = 0;
        int size = 0;
        for (Num num : list) {
            long value = calculateBinaryValue(num.a, num.b);
            ans = (ans + value * powMod(2, size, mod) % mod) % mod;
            size += num.a + num.b;
        }

        return (int) ans;
    }


    /**
     * 二进制结果计算，a代表有几个1，b代表有几个0
     * @param a，a最大可以为10000
     * @param b，b最大可以为10000
     * @return
     */
    private long calculateBinaryValue(int a, int b) {

        int mod = 1000000007;

        // 计算 2^a % mod
        long powA = powMod(2, a, mod);
        // 2^a - 1
        long onesVal = (powA - 1 + mod) % mod;

        // 计算 2^b % mod
        long powB = powMod(2, b, mod);

        // (2^a - 1) * 2^b % mod
        return (onesVal * powB) % mod;
    }

    private long powMod(long base, int exp, int mod) {
        long result = 1;
        base %= mod;
        while (exp > 0) {
            if ((exp & 1) == 1) {
                result = (result * base) % mod;
            }
            base = (base * base) % mod;
            exp >>= 1;
        }
        return result;
    }

    class Num {
        int a;
        int b;
        public Num(int a, int b) {
            this.a = a;
            this.b = b;
        }
    }

    public static void main(String[] args) {
        Q4 q4 = new Q4();
        int[] nums1 = {1,1038,1,3725,6296,2962,4,2930,7976,5,1,8612,1363,4011,251,1321,831,7334,16,114,3784,9467,814,88,4318,3230};
        int[] nums0 = {0,10000,0,10000,6707,10000,1,10000,9765,126,16,7051,2746,9435,8604,5148,1054,913,1,2810,2756,800,5236,7699,9286,9353};
        System.out.println(q4.maxValue(nums1, nums0));
    }
}
