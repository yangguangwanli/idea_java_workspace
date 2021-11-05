package compareMGT;

import java.util.Scanner;

public class CompareMGT {
//			任给一个数组，元素有20M，1T，300G之类的，其中1T=1000G，1G=1000M
//			按从小到大输出结果
//			
//          例如：
//          输入：3
//			20M
//			1T
//			300G
//			输出：
//			20M
//			300G
//			1T
	private static String[] sort(String[] strs) {
		for (int i = 0; i < strs.length - 1; i++) {
			for (int j = 0; j < strs.length - i - 1; j++) {
				// M G T
				// 前面比后面大就交换，冒泡排序法
				if (compare(strs[j], strs[j + 1])) {
					String tem = strs[j];
					strs[j] = strs[j + 1];
					strs[j + 1] = tem;
				}
			}
		}
		return strs;
	}

	// 重写比较大小的方法
	private static boolean compare(String s1, String s2) {
		int ss1 = turnString(s1);
		int ss2 = turnString(s2);
		return ss1 > ss2;
	}

	// 返还大小比较
	private static int turnString(String str) {
		//取单位一样的纯数值
		if ("M".equals(String.valueOf(str.charAt(str.length() - 1)))) {
			return Integer.parseInt(str.substring(0, str.length() - 1));
		} else if ("G".equals(String.valueOf(str.charAt(str.length() - 1)))) {
			return Integer.parseInt(str.substring(0, str.length() - 1)) * 1000;
		} else if ("T".equals(String.valueOf(str.charAt(str.length() - 1)))) {
			return Integer.parseInt(str.substring(0, str.length() - 1)) * 1000000;
		}
		return 0;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		while (sc.hasNext()) {
			String[] s = new String[n];
			for (int i = 0; i < n; i++) {
				s[i] = sc.next();
			}
			String[] result = sort(s);

			for (int i = 0; i < result.length; i++) {
				System.out.println(result[i]);
			}
		}
	}
}