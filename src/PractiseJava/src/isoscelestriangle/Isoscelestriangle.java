package isoscelestriangle;

import java.util.Scanner;

public class Isoscelestriangle {//等腰直角三角形
	
//	n 个互不相同的坐标点 (x_i,y_i)(x i ,yi​)，坐标值都为整数，存在 int[][] points 中，
//	问由这些点可以组成多少个等腰直角三角形，其中最大的等腰直角三角形的面积是多少？
//
//	输入：第一行是一个整数 n，表示有 n 个点，接下来的 n 行数据表示 n 个 (x,y) 坐标点，x 和 y 之间用空格隔开。
//	3
//	1 1
//	1 2
//	2 1
//	输出：第一个数字表示有多少个等腰直角三角形，第二个表示最大的等腰直角三角形面积（保留两位小数）。
//
//	1
//	1 0.50

	
	// 判断是否是等腰三角形
	//是就返回面积,不是就返回-1
	public static double isRT(int x1, int y1, int x2, int y2, int x3, int y3) {
		double a = getInstance(x1, y1, x2, y2);
		double b = getInstance(x1, y1, x3, y3);
		double c = getInstance(x2, y2, x3, y3);

		// a 作为底边
		if (a > b && a > c) {
			// 判定等腰直角:1:等腰 2:勾股定理
			//double类型的"=="需要用math.abs(c-b) < 0.1来表达
			if (Math.abs(c - b) < 0.1 && Math.abs(Math.pow(b, 2) + Math.pow(c, 2) - Math.pow(a, 2)) < 0.1) {
				return c * b * 0.5;
			}
			return -1.0;
		}
		// b 作为底边
		if (b > a && b > c) {
			if (Math.abs(c - a) < 0.1 && Math.abs(Math.pow(a, 2) + Math.pow(c, 2) - Math.pow(b, 2)) < 0.1) {
				return c * a * 0.5;
			}
			return -1.0;
		}
		// c 作为底边
		if (c > a && c > b) {
			if (Math.abs(a - b) < 0.1 && Math.abs(Math.pow(a, 2) + Math.pow(b, 2) - Math.pow(c, 2)) < 0.1) {
				return a * b * 0.5;
			}
			return -1.0;
		}
		// 无法构成等腰直角三角形
		return -1.0;

	}

	private static double getInstance(int x1, int y1, int x2, int y2) {
		return Math.sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2));
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[][] points = new int[n][2];
		for (int i = 0; i < n; i++) {
			//对应横坐标
			points[i][0] = in.nextInt();
			//对应纵坐标
			points[i][1] = in.nextInt();
		}
		
		// 处理数据
		int count = 0;
		double maxS = 0.0;
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				for (int k = j + 1; k < n; k++) {
					//循环给入三个点
					double s = isRT(points[i][0], points[i][1], points[j][0], points[j][1], points[k][0], points[k][1]);
					if (s > 0.0) {//s不为-1就说明是一个等腰直角三角形
						count++;
						maxS = Math.max(maxS, s);//取最大面积
					}
				}
			}
		}

		// 输出数据
		System.out.println(count + " " + String.format("%.2f", maxS));//保留两位小数
		System.out.printf("%d %.2f", count, maxS);
	}
}
