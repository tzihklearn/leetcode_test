package com.tzih.learn.daily;

public class LT1390 {
//    public int sumFourDivisors(int[] nums) {
//        int res = 0;
//        int t = 0;
//        for (int num : nums) {
//             t = 0;
//            for (int i = 2; i <= Math.sqrt(num); i++) {
//                if (num % i == 0 && num / i != i) {
//                    if (t == 0) {
//                        t = 1 + num + i + num / i;;
//                    } else {
//                        t = 0;
//                        break;
//                    }
//                }
//            }
//            res += t;
//        }
//        return res;
//    }

    public int sumFourDivisors(int[] nums) {
        int ans = 0;
        for (int num : nums) {
            // factor_cnt: 因数的个数
            // factor_sum: 因数的和
            int factor_cnt = 0, factor_sum = 0;
            for (int i = 1; i * i <= num; ++i) {
                if (num % i == 0) {
                    ++factor_cnt;
                    factor_sum += i;
                    // 判断 i 和 num/i 是否相等，若不相等才能将 num/i 看成新的因数
                    if (i * i != num) {
                        ++factor_cnt;
                        factor_sum += num / i;
                    }
                }
            }
            if (factor_cnt == 4) {
                ans += factor_sum;
            }
        }
        return ans;
    }
}
