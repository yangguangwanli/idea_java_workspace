package dynamicplan;

import java.util.ArrayList;
import java.util.Scanner;

public class rob {
//	题目描述：抢劫一排住户，但是不能抢邻近的住户，求最大抢劫量。
//
//	定义 dp 数组用来存储最大的抢劫量，其中 dp[i] 表示抢到第 i 个住户时的最大抢劫量。
//
//	由于不能抢劫邻近住户，如果抢劫了第 i -1 个住户，那么就不能再抢劫第 i 个住户，所以
//  d[i] = MAX{d[i-1], d[i-2] + num[i]}

    public static void main(String[] args) {
        System.out.println(robmaxmoney(new int[]{1, 2, 4, 5, 7, 8, 2, 6, 4}));
    }

    public static int robmaxmoney(int[] nums) {
        int pre2 = 0, pre1 = 0;
        for (int i = 0; i < nums.length; i++) {
            int cur = Math.max(pre2 + nums[i], pre1);
            pre2 = pre1;//pre2保存前一个值即d[i-2]的值
            pre1 = cur;//pre1保存最大抢劫量,dp[i] 表示抢到第 i 个住户时的最大抢劫量
        }
        return pre1;
    }
}


class Solution {
    public int rob(int[] nums) {
        int len = nums.length;
        if (len == 1) {
            return nums[0];
        } else if (len == 2) {
            return Math.max(nums[0], nums[1]);
        }
        return Math.max(robR(nums, 0, len - 2) , robR(nums, 1, len - 1));
    }

    //问题转换就是抢劫还是不抢劫前两个房屋的问题
    private int robR(int[] nums, int start, int end) {
        int fir = nums[start];
        //初始化
        int sec = Math.max(nums[start], nums[start + 1]);
        for (int i = start + 2; i <= end; i++) {
            int tem = sec;//保存sec
            sec = Math.max(nums[i] + fir, sec);
            fir = tem;
        }
        return sec;
    }
}