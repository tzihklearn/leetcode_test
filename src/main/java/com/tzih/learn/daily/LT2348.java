package com.tzih.learn.daily;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author tzih
 * @version v1.0
 * @since 2025.08.19
 */
public class LT2348 {
    /**
     2348. 全 0 子数组的数目
     中等
     相关标签
     premium lock icon

     提示
     给你一个整数数组 nums ，返回全部为 0 的 子数组 数目。

     子数组 是一个数组中一段连续非空元素组成的序列。

     示例 1：

     输入：nums = [1,3,0,0,2,0,0,4]
     输出：6
     解释：
     子数组 [0] 出现了 4 次。
     子数组 [0,0] 出现了 2 次。
     不存在长度大于 2 的全 0 子数组，所以我们返回 6 。
     示例 2：

     输入：nums = [0,0,0,2,0,0]
     输出：9
     解释：
     子数组 [0] 出现了 5 次。
     子数组 [0,0] 出现了 3 次。
     子数组 [0,0,0] 出现了 1 次。
     不存在长度大于 3 的全 0 子数组，所以我们返回 9 。
     示例 3：

     输入：nums = [2,10,2019]
     输出：0
     解释：没有全 0 子数组，所以我们返回 0 。

     提示：
     1 <= nums.length <= 105
     -109 <= nums[i] <= 109
     */
    public long zeroFilledSubarray(int[] nums) {
        long ans = 0;
        int last = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                ans += i - last;
            } else {
                last = i;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        LT2348 lt2348 = new LT2348();
//        int[] nums = {1,3,0,0,2,0,0,4};
        int[] nums = {0,0,0,2,0,0};
        long res = lt2348.zeroFilledSubarray(nums);
        System.out.println(res);
    }
}
