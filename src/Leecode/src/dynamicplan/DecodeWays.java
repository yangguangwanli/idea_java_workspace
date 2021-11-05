package dynamicplan;

public class DecodeWays {
//	一条包含字母 A-Z 的消息通过以下映射进行了 编码 ：
//
//	'A' -> 1
//	'B' -> 2
//	...
//	'Z' -> 26
//	要 解码 已编码的消息，所有数字必须基于上述映射的方法，反向映射回字母（可能有多种方法）。例如，"11106" 可以映射为：
//
//	"AAJF" ，将消息分组为 (1 1 10 6)
//	"KJF" ，将消息分组为 (11 10 6)
//	注意，消息不能分组为  (1 11 06) ，因为 "06" 不能映射为 "F" ，这是由于 "6" 和 "06" 在映射中并不等价。
//
//	给你一个只含数字的 非空 字符串 s ，请计算并返回 解码 方法的 总数 。
//
//	题目数据保证答案肯定是一个 32 位 的整数。

	public static void main(String[] args) {
		String s = "06";
		System.out.println(numDecodings(s));

	}
	public static int numDecodings(String s) {
	    if (s == null || s.length() == 0) {
	        return 0;
	    }
	    int n = s.length();
	    int[] dp = new int[n + 1];
	    //字符串字符个数为0，1种分组
	    dp[0] = 1;
	    //个数为1，倘如字符不是0就是1种，反之就是0种
	    dp[1] = s.charAt(0) == '0' ? 0 : 1;
	    for (int i = 2; i <= n; i++) {
	    	//只分隔为1个数为一组的情况
	        int one = Integer.valueOf(s.substring(i - 1, i));
	        //第i个位置的字符必须非0字符才可以
	        if (one != 0) {
	            dp[i] += dp[i - 1];
	        }
	        //如果上上个数是0的话，继续循环
	        if (s.charAt(i - 2) == '0') {
	            continue;
	        }
	        //以两个数为一组，这个数值小于等于26（才能表示字母），就可以加上上上个数的种类方法
	        int two = Integer.valueOf(s.substring(i - 2, i));
	        if (two <= 26) {
	            dp[i] += dp[i - 2];
	        }
	    }
	    return dp[n];
	}

}
