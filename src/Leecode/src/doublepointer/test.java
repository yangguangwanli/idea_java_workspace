package doublepointer;

import com.sun.org.apache.bcel.internal.generic.NEW;

import javax.print.DocFlavor;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

/**
 * @Auther: Renjie
 * @Date: 2021/10/21 - 12:17
 * @Description: {PACKAGE_NAME}
 * @Version: 1.0
 */
//可以删除一个字符，判断是否能构成回文字符串
public class test {
    public static void main(String[] args) {
        String s = "pweekabc";
        System.out.println(lengthOfLongestSubstring(s));
    }

    //暴力匹配法
    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    res[0] = i;
                    res[1] = j;
                    return res;
                }
            }
        }
        return res;
    }


    //无重复字符的最长子串
    public static int lengthOfLongestSubstring(String s) {
        if (s.length() == 0 && s == null) {
            return 0;
        }
        int l = 0;
        int maxlen = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                //循环
                //记住map.get(s.charAt(i)) + 1
                // 表示的是之前前一个重复字符的位置+1，表示当前的重复字符的位置
                l = Math.max(l, map.get(s.charAt(i)) + 1);
            }

            map.put(s.charAt(i), i);
            maxlen = Math.max(maxlen, i - l + 1);
        }
        return maxlen;
    }
}
