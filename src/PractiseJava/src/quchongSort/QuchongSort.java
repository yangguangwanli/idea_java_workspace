package quchongSort;

import java.util.Scanner;

public class QuchongSort {
	// 明明想在学校中请一些同学一起做一项问卷调查，为了实验的客观性，
	// 他先用计算机生成了N个1到1000之间的随机整数（N≤1000）
	// 对于其中重复的数字，只保留一个，把其余相同的数去掉，
	// 不同的数对应着不同的学生的学号。然后再把这些数从小到大排序，
	// 按照排好的顺序去找同学做调查。请你协助明明完成“去重”与“排序”的工作

//	思路： 1、输入n个数，然后后面是具体的这n个数的值。
//	2、输出他们的排序从小到大，并且没有重复
//	3、先把输入的N个数写进一个数组a存起来
//	4、一共有1000个数，则实际最大是1000，构造b数组大小为1000。
//	Input Param
//
//	n 输入随机数的个数
//	inputArray n个随机整数组成的数
//
//	Return Value
//	OutputArray 输出处理后的随机整数
//
//	输入描述:
//	输入多行，先输入随机整数的个数，再输入相应个数的整数
//
//	输出描述:
//	返回多行，处理后的结果
//
//	输入例子1:
//	11
//	10
//	20
//	40
//	32
//	67
//	40
//	20
//	89
//	300
//	400
//	15
//
//	输出例子1:
//	10
//	15
//	20
//	32
//	40
//	67
//	89
//	300
//	400
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			int n = sc.nextInt();//记录第一个数据
			int[] a = new int[n];//记录下输入的数组
			for (int i = 0; i < n; i++) {
				a[i] = sc.nextInt();
			}
			
			//由小到大输出
			int[] c = Test(a);
			for (int i = 0; i < c.length; i++) {
				if (c[i] == 1) {
					System.out.println(i);
				}
			}
		}
	}
	
	//因为默认的数组的下标大小是依次递增,范围也在值的范围,所以自动排序
	//核心思想是,把值的大小存放进数组的下标,值作为是否有这个数的标志
	public static int[] Test(int[] a) {
		int[] b = new int[1000];
		for (int i = 0; i < 1000; i++) {//先把每个1000的数值范围由b数组来表示，初始化为0
			b[i] = 0;
		}//不用初始化也可以，因为默认new出来的值就是0
		
		
		for (int i = 0; i < a.length; i++) {
			//再把每个值存入下标，值记为1，标志这里存在值
			//覆盖了重复默认去重
			b[a[i]] = 1;
		}
		return b;
	}
}
