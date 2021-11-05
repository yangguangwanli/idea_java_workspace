package meihuazhuang;

import java.util.Arrays;
import java.util.Scanner;
//难题！！！
public class Meihuazhuang {
//	描述
//	Redraiment是走梅花桩的高手。Redraiment可以选择任意一个起点，从前到后，
//	但只能从低处往高处的桩子走。他希望走的步数最多，你能替Redraiment研究他最多走的步数吗？
//
//	本题含有多组样例输入
//
//
//	输入描述：
//	输入多组数据，1组有2行，第1行先输入数组的个数，第2行再输入梅花桩的高度
//
//	输出描述：
//	一组输出一个结果
//
//	示例1
//	输入：
//	6
//	2 5 1 5 4 5 
//	3
//	3 2 1
//	
//	输出：
//	3
//	1
//	
//	说明：
//	6个点的高度各为 2 5 1 5 4 5
//	如从第1格开始走,最多为3步, 2 4 5
//	从第2格开始走,最多只有1步,5
//	而从第3格开始走最多有3步,1 4 5
//	从第5格开始走最多有2步,4 5
//	所以这个结果是3 
	
	//分析：最多的步数对应第几格的意义在于，这一位置后面有个数最多的比它大的数
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			int n = sc.nextInt();
			int[] arr = new int[n];
			for (int i = 0; i < arr.length; i++) {
				arr[i] = sc.nextInt();
			}

			// dp[i]表示以 nums[i] 开始的最长上升序列的长度
			// 状态转移方程为：采用从后往前的查找思路，dp[i] = dp[j]+1 (m>i)前提找到的第一个比它大的sum[j]的dp[j]+1
			int[] dp = new int[n];
			Arrays.fill(dp, 1);
			int maxLen = 1;
			for (int i = 0; i < arr.length; i++) { // 2 5 1 5 4 5
				for (int j = 0; j < i; j++) {
					if (arr[i] > arr[j]) {
						dp[i] = Math.max(dp[i], dp[j] + 1); // 借助dp[j]来更新dp[i]
					}
				}
				maxLen = Math.max(maxLen, dp[i]);

			}
			System.out.println(maxLen);
		}
	}
}
