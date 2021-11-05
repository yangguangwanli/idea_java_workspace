package Maxseq;

/**
 * @Auther: Renjie
 * @Date: 2021/10/11 - 15:46
 * @Description: 找到最长递增连续序列
 * @Version: 1.0
 */
public class MaxSeq {
    public static void main(String[] args) {
        System.out.println(findlength(new int[]{1, 2, 3, 2, 3, 4, 3, 4, 5, 6, 7}));
    }

    private static int findlength(int[] nums) {
        int start = 0;
        int max = 0;
        for (int i = 1; i <= nums.length - 1; i++) {
            if (nums[i] <= nums[i - 1]) {
                start = i;
            }
            max = Math.max(max, i - start + 1);
        }
        return max;
    }
}


//递归法
//返回一个数组的最长递增子序列 -- > 返回从数组某个数开始向后的最大递增子序列 + 循环数组每个数取最大值
//时间复杂度为：O(2^n) * O(n)
class Solution {

    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] memo = new int[nums.length];//记录从i开始的最长递增子序列长度
        int maxL = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            maxL = Math.max(maxL, L(nums, i));
        }
        return maxL;
    }


    int[] memo = new int[1000];//记录从i开始的最长递增子序列长度

    //从数值为i的这个数向后循环遍历，返回最大递增子序列
    public int L(int[] nums, int i) {
        //最后一个数作为边界
        if (memo[i] != 0) {
            return memo[i];
        }

        if (i == nums[nums.length - 1]) {
            return 1;
        }
        int max = 1;
        for (int j = i + 1; j < nums.length; j++) {
            if (nums[j] > nums[i]) {
                max = Math.max(L(nums, j) + 1, max);
            }
        }
        memo[i] = max;
        return max;
    }
}