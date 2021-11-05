package doublepointer;

import java.util.*;

//反转字符串中的元音字符
//使用双指针，一个指针从头向尾遍历，一个指针从尾到头遍历，当两个指针都遍历到元音字符时，交换这两个元音字符。
//为了快速判断一个字符是不是元音字符，我们将全部元音字符添加到集合 HashSet 中，从而以 O(1) 的时间复杂度进行该操作
public class Doublepointer {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根

	}

	private final static HashSet<Character> vowels = new HashSet<>(
			Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));

	public String reverseVowels(String s) {
		if (s == null)
			return null;
		int i = 0, j = s.length() - 1;
		char[] result = new char[s.length()];
		while (i <= j) {
			//一个从开头，一个从队尾
			char ci = s.charAt(i);
			char cj = s.charAt(j);
			//判断是否包括，不包括就顺序放入字符
			if (!vowels.contains(ci)) {
				result[i++] = ci;
			} else if (!vowels.contains(cj)) {
				result[j--] = cj;
			} else {
				//如果是元音字母就交换添加那个字符
				result[i++] = cj;
				result[j--] = ci;
			}
		}
		return new String(result);
	}
}
