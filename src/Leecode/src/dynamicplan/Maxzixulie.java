package dynamicplan;
//最长子序列
import java.util.Arrays;

public class Maxzixulie {

	public static void main(String[] args) {

	}

//  求最大连续子序列的和
//  用f[i]表示以第i个数a[i]结尾的最大子序列和。
//  那么f[i]的状态转移方程也很好得出，对于a[i]是单独算还是加入前面的f[i-1]
//  即：f[i]=max(f[i-1]+a[i],a[i])
	public int lengthOfLIS(int[] nums) {
		int[] dp = new int[nums.length];
		// dp全用1填充
		// dp[i]表示以 nums[i] 开始的最长上升序列的长度
		Arrays.fill(dp, 1);
		int maxLen = 1;
		for (int i = 0; i < nums.length; i++) { // 2 5 1 5 4 5
			for (int j = 0; j < i; j++) {
				//nums[i]为后面的那个数，nums[j]循环遍历i之前的数值
				if (nums[i] > nums[j]) {
					dp[i] = Math.max(dp[i], dp[j] + 1); // 借助dp[j]来更新dp[i]
				}
			}
			maxLen = Math.max(maxLen, dp[i]);
		}
		return maxLen;
	}
	
//  求最大连续子序列的和
//  用f[i]表示以第i个数a[i]结尾的最大子序列和。
//  那么f[i]的状态转移方程也很好得出，对于a[i]是单独算还是加入前面的f[i-1]
//  即：f[i]=max(f[i-1]+a[i],a[i])
	
//	问：为什么会想到用f[i]表示以第i个数a[i]结尾的最大子序列和？
//	连续的子序列的和，这是关键，只有f[i]包含了a[i]，递推才可以进行下去，不然就不连续了。
	public static int maxSum1(int[] nums) {
		int sum = 0;
		int ans = nums[1];//初始化ans，开始一次有效的比较
		for (int i = 0; i < nums.length; i++) {
			sum = Math.max(sum + nums[i], nums[i]);
			ans = Math.max(ans, sum);
		}
		return ans;
	}
	
//  贪心思想
//	假设a[l]...a[r]的和为 sum
//	如果 sum > 0，则说明 sum 对结果有增益效果，则 sum 保留
//	如果 sum < 0，则说明 sum 对结果无增益效果，需要舍弃
//  那么对于第i个数来说，我们查看他之前的sum，如果sum<0，那么当前的最大连续子序列和就是它本身（舍弃前面的）
//  如果sum>0，那么当前的最大和就是sum+a[i]  （sum保留了）
//  sum=0的情况都保留和丢弃都可以
	public static int maxSum2(int[] nums) {
		int sum = 0;
		int ans = nums[1];
		for (int i = 1; i < nums.length; i++) {
			if(sum >= 0) {
				//当前的最大和就是sum+a[i]  （sum保留了）
				sum += nums[i];
			}else {
				//sum < 0，则说明 sum 对结果无增益效果，需要舍弃
				sum = nums[i];
			}
			//保存sum最大值
			ans = Math.max(ans, sum);
		}
		return ans;
	}
	
}
