package zuixiaogongbeishu;

import java.util.*;

/**
 * 题目描述 正整数A和正整数B 的最小公倍数是指 能被A和B整除的最小的正整数值，
 * 
 * 设计一个算法，求输入A和B的最小公倍数。
 * 
 * 输入描述: 输入两个正整数A和B。
 * 
 * 输出描述: 输出A和B的最小公倍数。
 * 
 * 示例1 输入 5 7 输出 35 解题思路 最小公倍数=两数之积/两个数的最大公约数
 * 
 * @Classname:Zuixiaogongbeishu
 * @Description:TODO(描述这个类的作用)
 * @author Renjie
 * @date：2021年9月9日 下午3:45:30
 * @version 1.9
 */
public class Zuixiaogongbeishu {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			int m = sc.nextInt();
			int n = sc.nextInt();
			System.out.println(m * n / y(m, n));
		}
	}

	// 求最大公约数
	public static int y(int a, int b) {
		// 保证a比b的值大
		if (a < b) {
			int tmp;
			tmp = a;
			a = b;
			b = tmp;
		}
		// 求最大公约数，非递归方法
		// 辗转相除法
		// 先把b赋值给到a，再把a对b的余数赋值给b
		// 直到不能再取余了,a就是最大公约数
		int k;// 用来保存每次a对b的余数
		while (b != 0) {
			k = a % b;
			a = b;
			b = k;
		}
		return a;

//		//递归方法
//        if (b == 0){
//            return a;
//           }
//       return y(b, a % b);
	}
}

//求最小公倍数= 两数之积 / 两数最大公约数
//判定是否是质数/素数
//isprime(int n){
//	boolean a = false;
//	if (n == 2 && n == 3) {
//		return true;
//	}
//		for (int i = 3; i <= (int) Math.sqrt(n); i++) {
//			if (n % i == 0) {
//			a = false;
//			}else {
//			a = true;
//			}
//		}
//		return a;
//	}
