package hwtest1;

import java.util.Scanner;

public class zifuchuandelete {
	/**
	 * 题目描述 实现删除字符串中出现次数最少的字符，若多个字符出现次数一样，则都删除。
	 * 输出删除这些单词后的字符串，字符串中其它字符保持原来的顺序。
	 * 
	 * 输入描述: 字符串只包含小写英文字母, 不考虑非法输入，输入的字符串长度小于等于20个字节。
	 * 
	 * 输出描述: 删除字符串中出现次数最少的字符后的字符串。
	 * 
	 * 输入 abcdd 输出 dd
	 * 
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			String s = sc.nextLine();
			// 写一个方法执行
			judge(s);
			System.out.println();
		}

	}

	// 静态方法
	public static void judge(String s) {
		int[] ch = new int[26];//字母范围有界，26个字母，定义数组表示每个小写字母出现的次数
		int min = s.length();// 极端情况字符串仅为一个数值
		for (int i = 0; i < s.length(); i++) {
			ch[s.charAt(i) - 'a'] ++;// 每个字母的位置，找到一次，数组的值递增1
		}
		
		//取字符串中字符出现的最少次数min
		for (int i = 0; i < ch.length; i++) {
			if (min > ch[i] && ch[i] != 0) {// 未出现的字母为0,不计入比较，把更小的值放在min中
				min = ch[i];
			}
		}

		for (int i = 0; i < s.length(); i++) {
			if (ch[s.charAt(i) - 'a'] != min) {// 只要不是最小出现次数就可以输出
				System.out.print(s.charAt(i));
			}
		}
	}

}
