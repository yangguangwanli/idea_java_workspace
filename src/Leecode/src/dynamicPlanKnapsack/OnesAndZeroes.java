package dynamicPlanKnapsack;
//474. 一和零
public class OnesAndZeroes {
////给你一个二进制字符串数组 strs 和两个整数 m 和 n 。
//
//请你找出并返回 strs 的最大子集的长度，该子集中 最多 有 m 个 0 和 n 个 1 。
//
//如果 x 的所有元素也是 y 的元素，集合 x 是集合 y 的 子集

//	这是一个多维费用的 0-1 背包问题，有两个背包大小，0 的数量和 1 的数量
	public static void main(String[] args) {
		

	}
	public int findMaxForm(String[] strs, int m, int n) {
	    if (strs == null || strs.length == 0) {
	        return 0;
	    }
	    //dp[i][j]表示这个字符串子集有i个'0'，j个'1'的最大长度
	    int[][] dp = new int[m + 1][n + 1];
	    for (String s : strs) {    // 每个字符串只能用一次，遍历每一个字符串
	        int ones = 0, zeros = 0;
	        for (char c : s.toCharArray()) {//对每一个字符串的0和1计数
	            if (c == '0') {
	                zeros++;
	            } else {
	                ones++;
	            }
	        }
	        //计完数后从后向
	        for (int i = m; i >= zeros; i--) {
	            for (int j = n; j >= ones; j--) {
	                dp[i][j] = Math.max(dp[i][j], dp[i - zeros][j - ones] + 1);
	            }
	        }
	    }
	    return dp[m][n];
	}



	//假设农场中成熟的母牛每年都会生 1 头小母牛，并且永远不会死。第一年有 1 只小母牛
	// 从第二年开始，母牛开始生小母牛。每只小母牛 3 年之后成熟又可以生小母牛。给定整数 N，求 N 年后牛的数量

	public static int cowNumber(int n){
		if(n <= 2){
			return n;
		}
		int resNum = 0;
		int pre1 = 1;
		int pre2 = 1;
		for (int i = 3; i <= n; i++) {
			resNum = pre1 + pre2;
			pre2 = pre1;
			pre1 = resNum;
		}
		return pre1;
	}
}
