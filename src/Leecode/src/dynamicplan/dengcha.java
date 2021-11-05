package dynamicplan;
//待复查
public class dengcha {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根

	}

	public int numberOfArithmeticSlices(int[] nums) {
		if (nums.length == 0 || nums == null) {
			return 0;
		}
		int n = nums.length;
		int[] dp = new int[n + 1];
		for (int i = 0; i < n; i++) {
			if (nums[i] - nums[i - 1] == nums[i - 1] - nums[i - 2]) {
				dp[i] = dp[i - 1] + 1;
			}
		}
		int total = 0;
		for (int cnt : dp) {
			total += cnt;
		}
		return total;
	}
}
