package perfectNumber;

import java.util.Scanner;

public class PN {
//	完全数（Perfect number），又称完美数或完备数，是一些特殊的自然数。
//
//	它所有的真因子（即除了自身以外的约数）的和（即因子函数），恰好等于它本身。
//
//	例如：28，它有约数1、2、4、7、14、28，除去它本身28外，其余5个数相加，1+2+4+7+14=28。
//
//	输入n，请输出n以内(含n)完全数的个数。计算范围, 0 < n <= 500000
//
//	本题输入含有多组样例。
//
//	输入描述：
//	输入一个数字n
//
//	输出描述：
//	输出不超过n的完全数的个数
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			int n = sc.nextInt();
			int count = 0;
			//循环寻找完全数
			for (int i = 1; i <= n; i++) {
				if (isPerfectNumber(i)) {
					count++;
				}
			}
			System.out.println(count);
		}

	}
	
//判断是不是完全数
	private static boolean isPerfectNumber(int n) {
		int sum = 0;
		for (int i = 1; i <= n; i++) {
			//完全数条件1：不是自己；2：除了自己的所有约数相加为本身
			if (n % i == 0 && i != n) {
				sum += i;
			}
		}
		if (sum == n) {
			return true;
		} else {
			return false;
		}
	}
}
