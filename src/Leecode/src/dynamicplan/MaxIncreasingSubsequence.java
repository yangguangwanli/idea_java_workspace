package dynamicplan;

import java.util.Arrays;

/**
 * @Auther: Renjie
 * @Date: 2021/11/2 - 15:20
 * @Description: 给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
 * <p>
 * 子序列是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序列。
 * @Version: 1.0
 */
public class MaxIncreasingSubsequence {
    private static int[] memo = new int[1000];
    ;

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        System.out.println(lengthOfLIS(new int[]{0,1,0,3,2,3}));
        long end = System.currentTimeMillis();
        System.out.println("花费的时间为: " + (end - start));
    }

    public static int lengthOfLIS(int[] nums) {
        //该问题转化为从第1个数向后，找出比他大的第1个数字，从这个数字开始找出后续比这个数字大那个数，递归这个操作
        //直到最后那个数字，长度为1，就能反向推导出所有问题的答案
//        L(0) = max{L(1),L(2),L(3)...L(n)} + 1
//        L(1) = max{L(2),L(3),L(4)...L(n)} + 1
//        L(2) = max{L(3),L(4),L(5)...L(n)} + 1

//        ...
        //L(N - 2) = max{L(N - 1)} + 1
//        L(N - 1) = 1
        //L就是我们的递归操作的方法
        int len = nums.length;
        int max = 0;
        for (int i = 0; i < len; i++) {
            max = Math.max(max, L1(i, nums));
        }
        return max;
    }

    //动态规划
    public static int lengthOfLIS1(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        int max = 1;
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        for(int i = nums.length - 1; i >= 0; i--){
            for(int j = i + 1; j < nums.length; j++){
                if(nums[j] > nums[i]){//能构成递增序列
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            max = Math.max(dp[i],max);
        }
        return max;
    }


//使用字典保存的方式
    private static int L(int i, int[] nums) {
        if (memo[i] != 0) {
            return memo[i];
        }
        if (i == nums.length) {
            return 1;
        }
        int maxL = 1;
        for (int j = i + 1; j < nums.length; j++) {
            if (nums[j] > nums[i]) {
                maxL = Math.max(maxL, L(j, nums) + 1);
            }
        }
        memo[i] = maxL;
        return maxL;
    }

    //  不使用字典的形式
    private static int L1(int i, int[] nums) {
        if (i == nums.length) {
            return 1;
        }
        int maxL = 0;
        for (int j = i + 1; j < nums.length; j++) {
            if (nums[j] > nums[i]) {
                maxL = Math.max(maxL, L(j, nums) + 1);
            }
        }
        return maxL;
    }

}
