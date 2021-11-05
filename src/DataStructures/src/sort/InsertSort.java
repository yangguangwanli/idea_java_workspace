package sort;

import java.util.Arrays;
public class InsertSort {

	public static void main(String[] args) {
		int[] arr = { 101, 34, 119, 1, -1, 89 };
		InsertSortr(arr);
	}

	// 插入排序
	//简单插入排序存在的问题，当需要插入的数是较小的数的时候，后移的次数明显增多，对效率有影响
	public static void InsertSortr(int[] arr) {
		// 使用逐步推导的方式来讲解，便于理解
		// 初始轮{101, 34, 119, 1}; =>{34, 101, 119, 1}
		for (int i = 1; i < arr.length; i++) {

			// 定义待插入的数
			// 先定下第一个数为有序列表，依次为后面的无序的每一个数找位子并插入
			int insertVal = arr[i];
			int inserIndex = i - 1;// 即arr[1]前面这个数的下标

			// 给insertVal 找到插入的位置
			// 说明： 1、inserIndex >= 0 保证再给insertVal找位置时，不越界
			// 2、insertVal < arr[inserIndex] 表示待插入的数还没有找到插入的位置
			// 3、就需要将arr[insertIndex] 后移
			while (inserIndex >= 0 && insertVal < arr[inserIndex]) {
				arr[inserIndex + 1] = arr[inserIndex];
				inserIndex--;
			}
			// 当退出while循环时候，说明插入的位置找到，insertIndex + 1
			arr[inserIndex + 1] = insertVal;

			System.out.println("第" + i + "轮插入后");
			System.out.println(Arrays.toString(arr));
		}
	}
}