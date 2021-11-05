package threeMaxProduct;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @Auther: Renjie
 * @Date: 2021/10/11 - 13:16
 * @Description: 数组中三个数最大乘积
 * @Version: 1.0
 */
public class MaxProduct {
    public static void main(String[] args) {
        System.out.println(sort(new int[]{1, -1, -2, -3, 5, 6, -7, 8}));
    }

    private static int sort(int[] nums) {
        //Arrays.sort的时间复杂度为O（NlogN）
        Arrays.sort(nums);
        int n = nums.length;
        //两负一正和全正，取最大值
        return Math.max(nums[0] * nums[1] * nums[n - 1],
                nums[n - 1] * nums[n - 2] * nums[n - 3]);
    }
}
