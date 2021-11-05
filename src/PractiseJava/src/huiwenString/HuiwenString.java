package huiwenString;

import java.util.Scanner;

//中心扩散法
public class HuiwenString {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String s = sc.nextLine();
            int maxLen = 0;
            for (int i = 0; i < s.length(); i++) {
                int left = i - 1;
                int right = i + 1;
                int len = 1;
                // 找到左边和中心元素不相等的位置
                while (left >= 0 && s.charAt(left) == s.charAt(i)) {
                    left--;
                    len++;
                }
                // 找到右边和中心元素不相等的位置
                while (right < s.length() && s.charAt(right) == s.charAt(i)) {
                    right++;
                    len++;
                }
                // 左右同时扩散
                while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {// 左右同时扩散
                    left--;
                    right++;
                    len += 2;
                }
                maxLen = maxLen > len ? maxLen : len;
            }
            System.out.println(maxLen);
        }
    }

    //中心扩散法,返回最长回文子串
    public String longestPalindrome(String s) {
        if (s.length() == 1) return s;
        if (s.length() == 0) return "";
        int len = 0;
        int maxLen = 0;
        int maxStart = 0;
        for (int i = 0; i < s.length(); i++) {
            //每次初始化len，至少一个i这个位置的字符
            len = 1;
            int left = i - 1;
            int right = i + 1;
            //设置边界并找到左边那个与当前字符（窗口中心）不匹配的位置，窗口+1
            while (left >= 0 && s.charAt(left) == s.charAt(i)) {
                left--;
                len++;
            }
            // //设置边界并找到右边那个与当前字符（窗口中心）不匹配的位置，窗口+1
            while (right <= s.length() - 1 && s.charAt(right) == s.charAt(i)) {
                right++;
                len++;
            }
            //设置边界并左右扩展开来，窗口+2
            while (right <= s.length() - 1 && left >= 0 && s.charAt(left) == s.charAt(right)) {
                left--;
                right++;
                len += 2;
            }
            //记录最大长度和起始位置
            if (len > maxLen) {
                maxLen = len;
                maxStart = left;
            }
        }
        //返回字符串，注意subString是左闭右开[x,y),不会包括y这个位置的字符
        //maxStart + 1是因为left在前面退出循环的时候最后左移了一个位置才能跳出循环，这里补上
        return s.substring(maxStart + 1, maxStart + maxLen + 1);
    }

    //中心扩散法,返回最长回文子串（优化）
//    用一个 boolean dp[l][r] 表示字符串从 i 到 j 这段是否为回文。试想如果 dp[l][r]=true，我们要判断 dp[l-1][r+1] 是否为回文。只需要判断字符串在(l-1)和（r+1)两个位置是否为相同的字符，是不是减少了很多重复计算。
//    进入正题，动态规划关键是找到初始状态和状态转移方程。
//    初始状态，l=r 时，此时 dp[l][r]=true。
//    状态转移方程，dp[l][r]=true 并且(l-1)和（r+1)两个位置为相同的字符，此时 dp[l-1][r+1]=true
    public String longestPalindrome2(String s) {
        if (s == null || s.length() < 2) {
            return s;
        }
        int strLen = s.length();
        int maxStart = 0;  //最长回文串的起点】
        int maxEnd = 0;    //最长回文串的终点
        int maxLen = 1;  //最长回文串的长度
        //回文判断二维布尔数组
        boolean[][] dp = new boolean[strLen][strLen];
        for (int r = 1; r < strLen; r++) {
            for (int l = 0; l < r; l++) {
                //左右指针字符相等且（双方边界内部为回文为真 || 左右边界距离在2以内）
                if (s.charAt(l) == s.charAt(r) && (r - l <= 2 || dp[l + 1][r - 1])) {
                    dp[l][r] = true;
                    //循环比较最长子串
                    if (r - l + 1 > maxLen) {
                        maxLen = r - l + 1;
                        maxStart = l;
                        maxEnd = r;

                    }
                }

            }
        }//返回最长子串
        return s.substring(maxStart, maxEnd + 1);
    }
}
