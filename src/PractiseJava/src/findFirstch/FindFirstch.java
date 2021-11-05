package findFirstch;

import org.omg.Messaging.SyncScopeHelper;

import java.util.Scanner;
//找到一段字符串中从左到右只出现过一次的字符（备注ASCII一共128个字符）

public class FindFirstch {

	@SuppressWarnings("all")
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			String s = sc.nextLine();
			char[] arr = s.toCharArray();

			// 对ASCII码对照表128个字符均进行计数
			int[] count = new int[128];
			for (int i = 0; i < s.length(); i++) {
				// (int) arr[i]表示ASCII码对照表的十进制
				count[(int) arr[i]]++;
			}

			// 把i放到外层可以判断
			int i = 0;
			for (; i < s.length(); i++) {
				if (count[(int) arr[i]] == 1) {
					System.out.println(arr[i]);
					break;
				}
			}

			// 用i来判断是否存在只出现一次的字符，
			// i == s.length()说明循环完都没有找到那个只出现一次的字符
			System.out.println(-1);
			if (i == s.length()) {
			}
			System.out.println("1234556677889900");
			System.out.println();

		}
	}
}