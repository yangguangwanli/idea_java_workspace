package dynamicplan;

public class robII {
//强盗在环形街区抢劫
//其实就是把环拆成两个队列，一个是从0到n-1，另一个是从1到n，然后返回两个结果最大的
	public static void main(String[] args) {

	}
	
	
	public int rob(int[] nums) {
	    if (nums == null || nums.length == 0) {
	        return 0;
	    }
	    int n = nums.length - 1;//n为下标
	    if (n == 0) {
	        return nums[0];
	    }
	    return Math.max(rob(nums, 0, n - 1), rob(nums, 1, n));
	}

	private int rob(int[] nums, int first, int last) {
	    int pre2 = 0, pre1 = 0;
	    for (int i = first; i <= last; i++) {
	        int cur = Math.max(pre1, pre2 + nums[i]);
	        pre2 = pre1;
	        pre1 = cur;
	    }
	    return pre1;
	}
}



class Solution1 {
	public int rob(int[] nums) {
		int len = nums.length;
		if (len == 1) {
			return nums[0];
		} else if (len == 2) {
			return Math.max(nums[0], nums[1]);
		}
		return Math.max(robR(nums, 0, len - 2) , robR(nums, 1, len - 1));
	}

	//问题转换就是抢劫还是不抢劫前两个房屋的问题
	private int robR(int[] nums, int start, int end) {
		int fir = nums[start];
		//初始化
		int sec = Math.max(nums[start], nums[start + 1]);
		for (int i = start + 2; i <= end; i++) {
			int tem = sec;//保存sec
			sec = Math.max(nums[i] + fir, sec);
			fir = tem;
		}
		return sec;
	}
}
