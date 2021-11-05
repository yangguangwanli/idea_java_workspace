package twentyPoints;

import java.util.*;

public class way2 {
	static int[] nums = new int[4];
	static boolean[] visit = new boolean[4];//初始标志数组均为false
	static int flag = 0;//标志是否成功找到
	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		while (in.hasNext()) {
			String[] a = in.nextLine().split(" ");
			for (int i = 0; i < 4; i++) {
				nums[i] = Integer.parseInt(a[i]);
			}
			// 上面都是接收数据
			dfs(0, 0);
			System.out.println( flag ==1 );
		}

	}

	// 传入下标和tmp，tmp是前面n个数字之和
	static boolean dfs(int index, float tmp) {
		// 陈列最终条件，遍历到最后一个数字，并且前index个数的和刚好为24
		if (tmp == 24 && index == 4) {
			//达到这个目标之后才证明结束
            flag = 1;
			return true;
		}
		
		for (int i = 0; i < 4; i++) {
			//如果这个数字没有被处理，就先忽略这个数，先置为true再置为false
			//在dfs中就不会处理自身这个数据
			if (visit[i] == false) {
				visit[i] = true;
				//对下一个数开始向后进行dfs，+ 、 - 、 * 、 / ，开辟四条路径，任意一个能走通返回true就整体返回ture
				if (dfs(index + 1, tmp + nums[i]) || dfs(index + 1, tmp - nums[i]) || dfs(index + 1, tmp * nums[i])
						|| dfs(index + 1, tmp / nums[i])) {
					return true;
				}
				//没找到再把标志位改回，待下一次别的数据作为引用判断
				visit[i] = false;
			}
		}
		return false;
	}
}