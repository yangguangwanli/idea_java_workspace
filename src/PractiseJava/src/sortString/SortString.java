package sortString;

import java.util.*;

public class SortString {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			String str = sc.nextLine();
			// 1.使用list集合，将字符串中a-z，A-Z之间的字符按照排序顺序添加到list集合中。
			List<Character> list = new ArrayList<Character>();
			// 使用双层循环，外层循环负责添加从A到Z
			for (int i = 'A'; i <= 'Z'; i++) { 
				// 内层循环遍历字符串
				for (int j = 0; j < str.length(); j++) { 
					// 当字符串中字符是小写a-z或者大写A-Z等价，大写转小写需要加32
					if (str.charAt(j) == i || str.charAt(j) == i + 32) {
						list.add(str.charAt(j));
					}
				}
			}
			
			// 2.遍历字符串，找到字符不是a-z,A-Z之间的字符。并将该字符插入到list集合对应位置。
			for (int k = 0; k < str.length(); k++) {
				char c = str.charAt(k);
				if (!(c >= 'a' && c <= 'z' || c >= 'A' && c <= 'Z')) {
					//插入c字符到位置k，后面的顺序顺序移动
					list.add(k, c);
				}
			}
			
			// 3.遍历list集合，使用StringBuilder添加。输出字符串。
			StringBuilder sb = new StringBuilder(str.length());
			//一个个字符取出到StringBuilder，再输出
			for (Character e : list) {
				sb.append(e);
			}
			System.out.println(sb.toString());
		}
	}
}