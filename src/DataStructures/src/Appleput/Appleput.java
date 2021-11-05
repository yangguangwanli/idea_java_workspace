package Appleput;


import java.util.Scanner;

public class Appleput {
//	题目描述
//	把m个同样的苹果放在n个同样的盘子里，允许有的盘子空着不放，
//	问共有多少种不同的分法？（用K表示）5，1，1和1，5，1 是同一种分法。
//	数据范围：0<=m<=10，1<=n<=10。
//	本题含有多组样例输入。
//
//	输入描述：
//	输入两个int整数
//
//	输出描述：
//	输出结果，int型

	// 分析：
//	放苹果分为两种情况，一种是有盘子为空，一种是每个盘子上都有苹果。
//	令(m,n)表示将m个苹果放入n个盘子中的摆放方法总数。
//	1.假设有一个盘子为空，则(m,n)问题转化为将m个苹果放在n-1个盘子上，即求得(m,n-1)即可
//	2.假设所有盘子都装有苹果，则每个盘子上至少有一个苹果，即最多剩下m-n个苹果，问题转化为将m-n个苹果放到n个盘子上
//	即求(m-n，n)

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		Scanner sc = new Scanner(System.in);
		while(sc.hasNextInt()){
			System.out.println(count(sc.nextInt(), sc.nextInt()));
		}
		sc.close();

	}

	public static int count(int m, int n) {
		if (m < 0 || n <= 0) {
			return 0;
		// 细分为苹果数为1或盘子数为一的情况返回1
		}
		if (m == 1 || n == 1 || m == 0) {
			return 1;
		}
		// 将事件无线细分
		return count(m, n - 1) + count(m - n, n);
//			1.假设有一个盘子为空，则(m,n)问题转化为将m个苹果放在n-1个盘子上，即求得(m,n-1)即可
//			2.假设所有盘子都装有苹果，则每个盘子上至少有一个苹果，即最多剩下m-n个苹果，问题转化为将m-n个苹果放到n个盘子上
//			即求(m-n，n)
//			就转换为了以上两种情况
	}
}
