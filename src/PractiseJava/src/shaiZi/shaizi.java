package shaiZi;

import java.util.Scanner;

public class shaizi {

	/**
	 * 骰子有6个面，现在用1，2，3，4，5，6分别代表一个骰子的左，右，前，后，上，下的初始位置，
	 * 用R代表向右滚动一次，用L代表向左滚动一次，可以向前翻转（用F表示向前翻转1次），
	 * 可以向后翻转（用B表示向右翻转1次），可以逆时针旋转（用A表示逆时针旋转90度），
	 * 可以顺时针旋转（用C表示逆时针旋转90度），现从初始状态开始，根据输入的动作序列，计算得到最终的状态。 
	 * 
	 * 输入描述： 初始状态为：123456
	 * 输入只包含LRFBAC的字母序列，最大长度为50，可重复 
	 * 输出描述：输出最终状态 输入例子:RA 输出例子：436512
	 * 
	 * @author loy
	 * @desc
	 * @date 2018/8/29
	 */
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String[] str_array = { "1", "2", "3", "4", "5", "6" };
		String s = scan.nextLine();
		String[] s1 = s.split("");
		int len = s.length();
		for (int i = 0; i < s1.length; i++) {
			String ss = s1[i];
			rv(str_array, ss);
		}
		int t = 0;

		for (int i = 0; i < str_array.length; i++) {
			t = t * 10 + Integer.valueOf(str_array[i]);
		}
		System.out.println(t);
	}

	static void rv(String[] str_array, String s) {
		switch (s) {
		case "L":
			change(str_array, 0, 5);
			change(str_array, 1, 4);
			change(str_array, 0, 1);
			break;
		case "R":
			change(str_array, 0, 4);
			change(str_array, 1, 5);
			change(str_array, 0, 1);
			break;
		case "F":
			change(str_array, 2, 5);
			change(str_array, 3, 4);
			change(str_array, 2, 3);
			break;
		case "B":
			change(str_array, 2, 4);
			change(str_array, 3, 5);
			change(str_array, 2, 3);
			break;
		case "A":
			change(str_array, 0, 2);
			change(str_array, 1, 3);
			change(str_array, 0, 1);
			break;
		case "C":
			change(str_array, 0, 3);
			change(str_array, 1, 2);
			change(str_array, 0, 1);
			break;
		default:
			break;
		}
	}

	static void change(String[] str_array, int a, int b) {
		String temp = str_array[a];
		str_array[a] = str_array[b];
		str_array[b] = temp;
	}
}
