package test;

import java.util.*;

//描述
//输入一个只包含小写英文字母和数字的字符串，按照不同字符统计个数由多到少输出统计结果，
//如果统计的个数相同，则按照ASCII码由小到大排序输出。
//本题含有多组样例输入
//
//输入描述：
//一个只包含小写英文字母和数字的字符串。
//
//输出描述：
//一个字符串，为不同字母出现次数的降序表示。若出现次数相同，则按ASCII码的升序输出。
//
//示例1
//输入：
//aaddccdc
//1b1bbbbbbbbb
//
//输出：
//cda
//b1
//
//说明：
//第一个样例里，c和d出现3次，a出现2次，但c的ASCII码比d小，所以先输出c，再输出d，最后输出a
class node {
	int t;// t:代表出现的次数
	char v;// v：表示ASCII码

	public node(int t, char v) {
		this.t = t;
		this.v = v;
	}
}

public class Temp {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			String s = sc.nextLine();
			int[] arr = new int[36];
			for (int i = 0; i < s.length(); i++) {
				char ch = s.charAt(i);
				if (ch >= 'a' && ch <= 'z') {
					arr[ch - 'a']++;
				} else if (ch >= '0' && ch <= '9'){
					arr[ch - '0' + 26]++;
				}
			}

			List<node> list = new ArrayList<>();
			for (int i = 0; i < 36; i++) {
				if (arr[i] != 0) {
					if (i < 26) {
						list.add(new node(arr[i], (char) (i + 'a')));
					} else {
						list.add(new node(arr[i], (char) (i - 26 + '0')));
					}
				}
			}
			// Comparator别忘加new！！！
			Collections.sort(list, new Comparator<node>() {
				public int compare(node n1, node n2) {
					// 出现次数不同以出现次数降序排列
					if (n1.t != n2.t) {
						return n2.t - n1.t;
					} else {
						// 出现次数相同以其字符的ASCII码大小升序比较
						return n1.v - n2.v;
					}
				}
			});

			for (int i = 0; i < list.size(); i++) {
				System.out.print(list.get(i).v);
			}
			System.out.println();
		}

	}
}