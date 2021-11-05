

import java.util.Scanner;

//前面我们讲过了二分查找算法，是使用递归的方式，下面我们讲解二分查找算法的非递归方式
//2) 二分查找法只适用于从有序的数列中进行查找(比如数字和字母等)，将数列排序后再进行查找
//3) 二分查找法的运行时间为对数时间 O(㏒₂n) ，即查找到需要的目标位置最多只需要㏒₂n 步，假设从[0,99]的
//队列(100 个数，即 n=100)中寻到目标数 30，则需要查找步数为㏒₂100 , 即最多需要查找 7 次( 2^6 < 100 < 2^7)

public class BinarySearchNoRecur {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		// 测试
		int[] arr = { 1, 3, 8, 10, 11, 67, 100 };
		@SuppressWarnings("resource")
		int index = binarySearch(arr,  new Scanner(System.in).nextInt());
		System.out.println("index=" + index);//
	}

	// 二分查找的非递归实现
	/**
	 *
	 * @param arr    待查找的数组, arr 是升序排序
	 * @param target 需要查找的数
	 * @return 返回对应下标，-1 表示没有找到
	 */
	public static int binarySearch(int[] arr, int target) {
		int left = 0;
		int right = arr.length - 1;
		while (left <= right) { // 说明继续查找
			//手动二分法
			int mid = (left + right) / 2;
			if (arr[mid] == target) {
				return mid;
			//如果目标值小于中间值，说明在左边，赋值中间计算值给右手
			} else if (arr[mid] > target) {
				right = mid - 1;// 需要向左边查找
			} else {
			//如果目标值大于中间值，说明在右边，赋值中间计算值给右手
				left = mid + 1; // 需要向右边查找
			}
		}
		return -1;
	}

}
