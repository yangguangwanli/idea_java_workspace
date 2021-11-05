package nonredundant;

import java.util.Scanner;
//题目：输入一个int型整数，按照从右向左的阅读顺序，返回一个不含重复数字的新的整数

//输入描述:
//输入一个int型整数
//
//输出描述:
//按照从右向左的阅读顺序，返回一个不含重复数字的新的整数
//
//输入
//9876673
//输出
//37689
public class Nonredundant {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			String s = sc.nextLine();
			int[] a = new int[10];//默认十个全为0的空数组
			for (int i = s.length() - 1; i >= 0; i--) {//反向输出
				//s.charAt(i) - '0'  因为计算机作运算的时候都是以二进制做运算
				//所以为了防止边界溢出，这里的 - '0'  意味着做差，减去一个固定的数就能保证在10个数以内
				//还是放入数组内，下标默认是顺序递增的
				//数组值为0意味着没出现，没出现就打印
				//打印之后，值标记为1，说明此值已存在
				if (a[s.charAt(i) - '0'] == 0) {
					System.out.print(s.charAt(i));
					a[s.charAt(i) - '0'] = 1;
				}
			}
	}
}
}


//  有点难理解
//	Scanner sc = new Scanner(System.in);
//	while (sc.hasNext()) {
//	String s = sc.nextLine();
//	int[] a = new int[10];
//	for (int i = s.length() - 1; i >= 0; i--) {
//		if (a[s.charAt(i) - '1'] == 0) {//
//			System.out.print(s.charAt(i));
//			a[s.charAt(i) - '1'] = 1;
//		}
//	}
//	}


//第二种方法
//String s = sc.nextLine();
//String s1 = "";
//for(int i = s.length() - 1; i >= 0; i--) {//反向循环找值
//	//如果字符串s1不包括取出来的那个子字符串（注意需要把字符类型转换为字符串类型）
//	//s1就依次加进去那个值
//	String ss = String.valueOf(s.charAt(i));//定义待添加的字符串
//	if( !s1.contains(ss)) {//如果已经包括就不添加，换句话说，如果里面没有才去添加
//		s1 = s1 + ss;
//	}
//}
//System.out.println(s1);