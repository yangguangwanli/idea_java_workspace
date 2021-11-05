package com.huaweiyun.example2;

import java.util.Scanner;

public class GuessNumberDemo {
//  需求：
//  编写程序随机生成一个1~10之间的随机数，程序提示用户输入一个数字，不停猜测直到猜对为止
//  最后输出猜测的数字和猜测的次数
//  并且如果没有猜中要提示用户输入的值是大了还是小了
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入一个整数，范围是1~10（包含）之间");
		int guessNum = (int) (Math.random() * 10 + 1);// [0.0,1.0)
		//System.out.println(guessNum);

		int i = 0;
		while (true) {// 不知道要猜多少次，用死循环一直做，满足条件后退出
			i++;
			System.out.println("猜测第" + i + "次：");
			int result = sc.nextInt();// 接收用户每次从键盘输入的正数

//			if (result < guessNum) {
//				System.out.println("猜小了");//买大了
//				}
//			else if (result > guessNum) {
//				System.out.println("猜大了");//买小了
//				}
//			else {
//					System.out.println("猜对了");//中彩了
//					break;
//			     }
			if (new MyGuess().compare(guessNum, result) == true) {
				System.out.println("猜测正确共猜测了" + i + "次.");
				break;
			}
		}

	}
}
