package Exam;

import java.util.*;
//leecode 38题
//后面一个数组描述前一个数组的值的个数和值
//1
//11
//21
//1211
//111221

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNextLine()) {
			int n = sc.nextInt();
			System.out.println(myway(n));
		}
	}

	private static String myway(int n) {
		//临界底线函数
		if (n == 0) {
			return "";
		}
		if (n == 1) {
			return "1";
		}
		//方法就是只对上一个数组进行操作,从左到右循环描述它的个数和值
		String str = myway(n - 1);
		StringBuffer sb = new StringBuffer();
		int l = 0;
		int r = 1;
		
		for (; r < str.length(); r++) {
			//左边的值不等于右边的那个值,就加上左边的值,左边指针指向右边
			if (str.charAt(l) != str.charAt(r)) {
				int count = r - l;
				//都是增加相同连续的值
				sb.append(count).append(str.charAt(l));
				l = r;//作为是否添加连续值的标志
			}
		}
		//指针最后必须重合,不然就还剩下最后一个内容没有添加进去,不上最后一块连续的内容
		//r遍历上一个整个数组的某一块内容都没发现有不相等的,所以直接加长度和l的值
		if (l != r) {
			int count = r - l;
			sb.append(count).append(str.charAt(l));
		}
		return sb.toString();
	}

	// 外观函数
	public static String count(int n) {
		if (n == 0) {
			return "";
		}
		if (n == 1) {
			return "1";
		}
		int left = 0;
		int right = 1;
		String str = count(n - 1);
		StringBuffer sb = new StringBuffer();
		for (; right < str.length(); right++) {
			if (str.charAt(left) != str.charAt(right)) {
				int count = right - left;
				sb.append(count).append(str.charAt(left));
				left = right;
			}
		}
		if (left != right) {
			int count = right - left;
			sb.append(count).append(str.charAt(left));
		}
		return sb.toString();

	}
}