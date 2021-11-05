package sort;

import java.util.Arrays;

public class SelectSort {
//选择排序，把次循环比较的最小值由小到大放进数组
//选择排序法相比冒泡排序会缩短时间
	public static void main(String[] args) {
		int[] arr = {101, 34, 119, 1 };
		System.out.println("排序前");
		System.out.println(Arrays.toString(arr));
		selectSort(arr);
		
		System.out.println("排序后");
		System.out.println(Arrays.toString(arr));
	}

	public static void selectSort(int[] arr) {
		// 使用逐步推导的方式来。讲解选择排序
		//时间复杂度也是O（n^2）
		for (int i = 0; i < arr.length - 1; i++) {
			int minIndex = i;// 初始化最小值的下标
			int min = arr[i];// 初始化假定最小值是第一个元素
			for (int j = i + 1; j < arr.length; j++) {
				if (min > arr[j]) {// 说明假定的最小值不是最小
					min = arr[j];// 重置min
					minIndex = j;// 重置minIndex
				}
			}

			// 将最小值，放在arr[0],即交换
			if (minIndex != i) {
				arr[minIndex] = arr[i];
				arr[i] = min;//把后面最小的值给到每次开始的那个位置
			}

//			System.out.println("第" + (i + 1) + "轮后~~~");
//			System.out.println(Arrays.toString(arr));
		}
	}

}