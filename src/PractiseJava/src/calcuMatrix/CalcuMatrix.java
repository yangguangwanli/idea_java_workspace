package calcuMatrix;

import java.util.*;

public class CalcuMatrix {
//输入描述：
//	输入多行，先输入要计算乘法的矩阵个数n，每个矩阵的行数，列数，总共2n的数，最后输入要计算的法则
//	计算的法则为一个字符串，仅由左右括号和大写字母（'A'~'Z'）组成，保证括号是匹配的且输入合法！
//
//	输出描述：
//	输出需要进行的乘法次数
//
//	示例1
//	输入：
//	3
//	50 10
//	10 20
//	20 5
//	(A(BC))
//	
//	输出：
//	3500
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			// 处理输入
			int n = sc.nextInt();
			//初始化二维数组，存放两个数据
			int[][] arr = new int[n][2];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < 2; j++) {
					//循环存入行数和列数
					arr[i][j] = sc.nextInt();
				}
			}
			//接收矩阵乘法表达式
			String s = sc.next();
			// 计算量估算
			//Deque双端队列，new两个个链表
			//一个存储计算的数据，一个存放其他标识符号
			Deque<int[]> num = new LinkedList<>();
			Deque<Character> ops = new LinkedList<>();
			int sum = 0;
			for (int i = 0; i < s.length(); i++) {
				char c = s.charAt(i);
				if (c >= 'A' && c <= 'Z') {// 矩阵
					//压入对应存储的一维数据，这个一维数据存放着一个行数，一个列数
					num.push(arr[c - 'A']);
				} else if (c == '(') {// 左括号
					//遇到左括号压入符号栈
					ops.push('(');
				} else {// 右括号
					//弹出两个数据，注意num1是后弹出的那个
					int[] num2 = num.pop();
					int[] num1 = num.pop();
					//两个矩阵的计算次数为第一个矩阵的行*列*第二个矩阵的列（第二个矩阵的行和第一个矩阵的列相等）
					//如果A1的行列数是p x q，A2的行列数是q x r。那么对于A1xA2而言，乘法执行次数为：p * q * r次
					sum += num1[0] * num1[1] * num2[1];
					//压入这个两个矩阵的乘积结果，就是p x r的一个整型数组
					num.push(new int[] { num1[0], num2[1] });
					//弹出左括号（左括号抛弃）
					ops.pop();
				}
			}
			// 输出结果
			System.out.println(sum);
		}
	}
}
