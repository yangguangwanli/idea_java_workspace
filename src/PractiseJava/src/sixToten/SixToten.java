package sixToten;

import java.util.Scanner;

public class SixToten {
//		写出一个程序，接受一个十六进制的数值字符串，输出该数值的十进制字符串。（多组同时输入 ）
//		输入描述:
//		输入一个十六进制的数值字符串。
//
//		输出描述:
//		输出该数值的十进制字符串。
//
//		输入例子1:
//		0xA
//
//		输出例子1:
//		10
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNextLine()) {
			String s = sc.nextLine();
			//把s从第二个位置之后的16进制的子字符串转化为10进制的int类型
			int i = Integer.parseInt(s.substring(2),16);
			System.out.println(i);
		}
	}

}
