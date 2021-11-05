package tongpeifu;

import java.util.*;

public class feidigui {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while (in.hasNext()) {
			String key = in.next();
			String str = in.next();
			//num为指针指向key（通配符描述的字符串）
			int num = 0;
			boolean flag = true;
			//这是一个是与否的问题，可以初始化为true，尽最大的努力去寻找变为false的条件
			for (int i = 0; i < str.length(); i++) {
				if (key.charAt(num) != '?' && key.charAt(num) != '*' && key.charAt(num) != str.charAt(i)) {
					flag = false;
					break;
				}
				if (key.charAt(num) == str.charAt(i) || key.charAt(num) == '?') {
					//往后走
					num++;
					continue;
				}
				if (num + 1 < str.length() && i + 1 < str.length()) {
					if (key.charAt(num + 1) == str.charAt(i + 1)) {
						//双指针指向的下一个字符成功匹配
						num++;
						continue;
					}
				}
				if (key.charAt(num) == '*')
					continue;
			}
			System.out.println(flag);
		}
		in.close();
	}
}
