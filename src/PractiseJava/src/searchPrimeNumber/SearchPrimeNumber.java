package searchPrimeNumber;

import java.util.Scanner;

public class SearchPrimeNumber {
private static final int b2 = 0;
private static final int b1 = 0;

//查找组成一个偶数最接近的两个素数
	//题目描述
//	任意一个偶数（大于2）都可以由2个素数组成，组成偶数的2个素数有很多种情况，
//  本题目要求输出组成指定偶数的两个素数差值最小的素数对
//	输入描述:
//
//	输入一个偶数
//
//	输出描述:
//
//	输出两个素数
//
//	示例1
//
//	输入：20
//	输出：7 13
//
//	解题思路
//	该题思路是：我们先实现一个判断一个数是否为素数的子函数，
	//  如何判断一个数是否为素数?
	//  for循环让n除以从2开始到sqrt(n)的所有数，若是均不能整除，则n是素数，反之不是。
	//  实现好子函数后，我们再来找某数2等于最近两个素数相加的两个数，
	//  最近，我们就应该从中间开始往两边找，然后通过刚刚写的子函数来判断两个数是不是素数
	//  不是就一个++，另一个--，直到找到为止。
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			int n = sc.nextInt();
			int c = n / 2;
			//要求两个素数差值最小，那就从中间开始找，给入的偶数默认就是两个素数相加
			//因此用一个值来递增判断就可以，用自己写的方法循环判断
			while (true) {
				if(isPrime(c) && isPrime(n - c) ) {
					break;
				}
				c++;
			}
			System.out.println(c + " " + (n-c));
		}
	}
	
	public static boolean isPrime(int n) {//单独写一个方法判断是否为素数
		boolean a = true;
		if (n == 2 && n == 3) {//若是2或3，就都是，特殊数值直接给出
			a = true;
		}
		//n除以从2开始到sqrt(n)的所有数，若是均不能整除，则n是素数，反之不是
		for (int i = 2; i <= (int)Math.sqrt(n); i++) {
		//若在2开始到sqrt(n)范围内有一个可以被整除，就不是素数
			if (n % i == 0) {
				a = false;
			}
		}
		return a;
	}
}
