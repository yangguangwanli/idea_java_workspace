package myspace.Interview;

import com.sun.org.apache.bcel.internal.generic.NEW;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: Renjie
 * @Date: 2021/11/5 - 0:10
 * @Description: {PACKAGE_NAME}
 * @Version: 1.0
 */
public class solution {
    public static void main(String[] args) {
        int[] nums = {2, 7, 1, 22, 44, 1};
        System.out.println(Arrays.toString(twoNumsadd(nums, 9)));
    }

    public static int[] twoNumsadd(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{i, map.get(target - nums[i])};
            }
            map.put(nums[i], i);
        }
        return null;
    }
}
