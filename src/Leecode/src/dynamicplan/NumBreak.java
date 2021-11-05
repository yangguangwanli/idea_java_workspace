package dynamicplan;

import java.util.Scanner;

public class NumBreak {

    public static void main(String[] args) {

    }
	/*
    n -> memo(n) 
    将n 分成两个数字  a:  memo(n) = i * (n - i);
    将n 分成多个数字
      b:  memo(n) = memo(i) * (n - i);
      c:  memo(n) = i * memo(n - i);
      d:  memo(n) = memo(i) * memo(n - i);

    memo(n) = Math.max(a,b,c,d);
    b,c这两种分解方式其实是重合了，所以取一种即可
*/

    public int integerBreak(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i - 1; j++) {
                dp[i] = Math.max(dp[i], Math.max(j * dp[i - j], j * (i - j)));
            }
        }
        return dp[n];
    }
}


class Solution11 {
    public int Fibonacci(int n) {
        int[] f = new int[n + 1];
        f[0] = 0;
        f[1] = 1;
        for (int i = 2; i <= n; i++) {
            f[i] = f[i - 1] + f[i - 2];
        }
        return f[n];
    }

    public int Fibonacci2(int n) {
        int f = 0;
        int pre2 = 0;
        int pre1 = 1;
        for (int i = 2; i <= n; i++) {
            f = pre1 + pre2;
            pre2 = pre1;
            pre1 = f;
        }
        return f;
    }
}