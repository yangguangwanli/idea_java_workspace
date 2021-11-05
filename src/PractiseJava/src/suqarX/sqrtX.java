package suqarX;

import java.util.Scanner;

/**
 * @Auther: Renjie
 * @Date: 2021/10/11 - 12:55
 * @Description: 不使用sqrt(x)函数的情况下，得到x的平方根整数部分
 * @Version: 1.0
 */
public class sqrtX {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int a = sc.nextInt();
            System.out.println(newton(a));
        }
    }

    //二分法
    private static int binarySearch(int x) {
        int index = -1, l = 0, r = x;
        while (l <= r){
            int mid = l + (r - l) / 2;
            if (mid * mid <= x){
                index = mid;
                l = mid + 1;
            }else{
                r = mid - 1;
            }
        }
        return index;
    }

    //牛顿迭代
    public static int newton(int x){
        if (x == 0){
            return 0;
        }
        return (int)sqrt(x, x);
    }

    //原理：循环寻找n/i 和 n的均值，因为他们的均值会比他们各自更加趋近于sqrt（n）
    private static double sqrt(double i, int x) {
        double res = (i + x / i) / 2;
        if (res == i) {
            return i;
        }else {
            return sqrt(res, x);
        }
    }; //
}
