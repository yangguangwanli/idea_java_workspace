package dynamicplan;
import java.util.*;
//题目描述：求从矩阵的左上角到右下角的最小路径和，每次只能向右和向下移动。
public class Minroad {

	public static void main(String[] args) {

	}
	
public int minPathSum(int[][] grid) {
	if (grid.length == 0 || grid[0].length == 0) {
		return 0;
	}
	int m = grid.length;
	int n = grid[0].length;
	//dp意为从int[i][j]矩阵的左上角到右下角的最小路径和
	int[] dp = new int[n];
	for (int i = 0; i < m; i++) {
		for (int j = 0; j < n; j++) {
			if(j == 0) {
				//在第一列的话只能从上侧走到这个位置
				dp[j] = dp[j];
			}else if (i == 0) {
				//在第一行的话只能由右侧走到这个位置
				dp[j] = dp[j-1];
			}else {
				//取最小值
				dp[j] = Math.min(dp[j - 1], dp[j]);
			}
			//循环加路径的值
			dp[j] += grid[i][j]; 
		}
	}
	
	return dp[n - 1];
	}
}
