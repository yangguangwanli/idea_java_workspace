package reverse;

import java.util.Scanner;

/**
 * 题目要求 题目描述 将一个字符串str的内容颠倒过来，并输出。str的长度不超过100个字符。 如：输入“I am a
 * student”，输出“tneduts a ma I”。
 * 
 * 输入参数： inputString：输入的字符串
 * 
 * 返回值： 输出转换好的逆序字符串
 * 
 * 输入描述: 输入一个字符串，可以有空格
 * 
 * 输出描述: 输出逆序的字符串
 * 
 * 示例1 输入 复制 I am a student 输出 tneduts a ma I
 * 
 * @Classname:Reverse
 * @Description:TODO(描述这个类的作用)
 * @author Renjie
 * @date：2021年9月9日 下午7:25:46
 * @version 1.9
 */
public class Reverse {
	public static String revert(String s) {
		char[] ch = s.toCharArray();
		int l = ch.length / 2;
		// 以中轴为准，循环交换数值
		for (int i = 0; i < l; i++) {
			char temp = ch[i];
			ch[i] = ch[ch.length - i - 1];
			ch[ch.length - i - 1] = temp;
		}
		String ss = new String(ch);
		return ss;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			String s = sc.nextLine();
			System.out.println(revert(s));
		}
	}

}
//法二：
//public static void main(String[] args) {
//	Scanner in = new Scanner(System.in);
//	while (in.hasNextLine()) {
//		StringBuffer bf = new StringBuffer(in.nextLine());
//		System.out.println(bf.reverse());
//	}
// }
