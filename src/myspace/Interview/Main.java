package myspace.Interview;

import myspace.ConcurrentProgramming.juc.CountDownLatchDemo;

import java.util.*;

/**
 * @Auther: Renjie
 * @Date: 2021/10/11 - 18:09
 * @Description: {PACKAGE_NAME}
 * @Version: 1.0
 */

//找出不含重复字符的最长子串长度
//
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String s = sc.next();
//            System.out.println("有效字符串为： "+ norepeatseq(s));
//            System.out.println("长度为： " + norepeatseq(s).length());
            System.out.println(norepeatseq1(s));
            System.out.println(twoSum(new int[]{1, 2, 3, 4, 5}, 5));
        }
    }

    private static int norepeatseq1(String s) {
        if (s.length() == 0) {
            return 0;
        }
        if (s.length() == 1) {
            return 1;
        }
        int res = 0;
        int j = 1;
        int i = 0;
        //j为后一个字符
        //最后的长度
        int subLength = 0;
        //128个字符,用来记录下标的位置,字符自动覆盖
        int[] index = new int[128];
        //初始值设为-1
        for (int k = 0; k < index.length; k++) {
            index[k] = -1;
        }
        while (j < s.length()) {
            //不为-1(说明j这个字符出现过)且这个位置的下一个点比左窗口边界大
            if (index[s.charAt(j)] != -1 && index[s.charAt(j)] + 1 >= i) {
                //滑动左边边界到左右两边字符不等的右边那个字符的位置
                i = index[s.charAt(j)] + 1;
            }
            //保存较大值
            subLength = (j - i + 1) > subLength ? (j - i + 1) : subLength;
            //记录后面字符那个点的位置，值为j，自动覆盖前一个重复字符的位置，j++向后遍历
            index[s.charAt(j)] = j;
            j++;
        }
        return subLength;


//        //保证边界
//        while (j < s.length() - 1) {
//
//            if (arr[i] != arr[j] && !s.substring(i, j + 1).contains(arr[j] + "")) {
//                res = Math.max(j - i + 1, res);
//            }
//
//            //找到下一个不重复的地方
//            while (arr[j] == arr[j + 1]) {
//                j++;
//            }
//            i = j;
//            j = j + 1;
//
//
//        }
//        return res;
    }


    //    由于该题为最长子串， 所以应该设置一个滑动窗口记录子串，用一个maxLength来记录最长长度，此处注意
//    最长子串和滑动窗口并没有直接联系，滑动窗口时为了下一个进入计算的右字符所设置，即有两种可能 ：
//        1. 字符不在窗口内， 左窗口不变
//        2. 字符在窗口内， 左窗口变为该字符上次出现的位置+1
//    则最长长度为 max(窗口长度， 上次的最长长度)
    public static int lengthOfLongestSubstring(String s) {
        //字符串为空返回空
        if (s.length() == 0) {
            return 0;
        }
        //一个字符返回1
        if (s.length() == 1) {
            return 1;
        }
        //双指针
        int i = 0;
        int j = 0;
        //最后的长度
        int subLength = 0;
        //128个字符
        int[] index = new int[128];
        //初始值设为-1
        for (int k = 0; k < index.length; k++) {
            index[k] = -1;
        }
        //j为后一个字符，
        while (j < s.length()) {
            //不为-1(说明这个字符出现过)且靠后的那个字符的下标比左窗口边界大
            if (index[s.charAt(j)] != -1 && index[s.charAt(j)] + 1 >= i) {
                //滑动左边边界靠后的那个字符的位置
                i = index[s.charAt(j)] + 1;
            }
            //保存较大值
            subLength = (j - i + 1) > subLength ? (j - i + 1) : subLength;
            //记录后面字符那个点的位置，值为j，j++向后遍历
            index[s.charAt(j)] = j;
            j++;
        }
        return subLength;
    }

    public static int hashmapsolution(String s) {
        if (s.length() == 0) return 0;
        //hashmap中的keset可以自动去重
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int max = 0;
        int left = 0;
        for (int i = 0; i < s.length(); i++) {
            //keyset中如果已经包含了这个数，记录窗口左边界右移一位
            // 移动到靠后的那个重复字符的位置
            if (map.containsKey(s.charAt(i))) {
                left = Math.max(left, map.get(s.charAt(i)) + 1);
            }
            //keyset放入字符，value放入字符位置
            //对于已存在的key，会把value直接覆盖，更新成更大的那个数值
            map.put(s.charAt(i), i);
            //比较出最大长度,加1代表加上自身那个数
            max = Math.max(max, i - left + 1);
        }
        return max;
    }
 //    给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出
//    和为目标值 target  的那 两个 整数，并返回它们的数组下标。
//    你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。

    public static int[] twoSum(int[] nums, int target) {
        //hashmap进行存储数据，key里面存放nums数值，value存放位置
        //用一个数组表现结果
        int[] res = new int[2];
        if (nums == null || nums.length == 0) {
            return res;
        }
        //map的实际应用,keyset保存数值，key存放数值，value存放下标
        // target - nums【i】也放入keyset中，如果keset包括这个数值，就输出
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                res[0] = i;
                res[1] = map.get(target - nums[i]);
            }
            map.put(nums[i], i);
        }
        return res;
    }
}



