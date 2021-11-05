package Sort;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

//(已完成）

public class StudentSort {
//两列数据的组合排序
//
//将编号为1-n的n个人首先按身高进行递增排序，如果身高相等，则按体重递增排序
//如果身高、体重都一样，则按编号进行排序，最终输出排序好的编号。
//
//输入
//
//第一行： n 
//
//第二行：n个人的身高
//
//第三行：n个人的体重
//
//输出排序好的编号

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			int n = sc.nextInt();
			int[] height = new int[n];
			int[] weight = new int[n];
			for (int i = 0; i < n; i++) {
				height[i] = sc.nextInt();
			}
			for (int i = 0; i < n; i++) {
				weight[i] = sc.nextInt();
			}

			List<Man> list = new ArrayList<>();
			for (int i = 0; i < n; i++) {
					list.add(new Man(i, height[i], weight[i]));
				}
			// 重写比较方法
			list.sort(new Comparator<Man>() {
				@Override
				public int compare(Man m1, Man m2) {
					if (m1.height != m2.height) {
						return m1.height - m2.height;
					} else if (m1.weight != m2.weight) {
						return m1.weight - m2.weight;
					} else {
						return m1.no - m2.no;
					}
				}
			});
			for (int i = 0; i < list.size(); i++) {
				System.out.print((list.get(i).no + 1) + " ");
			}
		}
	}

}

class Man {
	int no, height, weight;

	Man(int n, int h, int w) {
		no = n;// 编号
		height = h;// 身高
		weight = w;// 体重
	}
}