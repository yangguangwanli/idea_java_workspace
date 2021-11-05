package sort;

import java.util.Arrays;

public class ShellSort {
//希尔排序的思想，尽量先把大的数排到后面，小的数排到前面
//此为交换法，效率较慢
	public static void main(String[] args) {
		int[] arr = { 8, 9, 1, 7, 2, 3, 5, 4, 6, 0 };
		shellSort(arr);
	}

	public static void shellSort(int[] arr) {
		int temp = 0;
		int count = 0;
		// 根据前面分析，使用循环

		for (int gap = arr.length / 2; gap > 0; gap /= 2) {

			// 希尔排序的第1轮排序
			// 因为第一轮排序是将十个数据分成了5组
			for (int i = gap; i < arr.length; i++) {
				// 遍历各组种所有的元素（共有gap组，每组有个元素，步长为gap）
				for (int j = i - gap; j >= 0; j -= gap) {
					// 如果当前元素大于加上步长后的那个元素，说明需要交换
					if (arr[j] > arr[j + gap]) {
						temp = arr[j];
						arr[j] = arr[j + gap];
						arr[j + gap] = temp;
					}
				}
			}

			System.out.println("希尔排序第" + (++count) + "轮后=" + Arrays.toString(arr));

		}
	}


////希尔排序的第1轮排序
//		// 因为第一轮排序是将十个数据分成了5组
//		for (int i = 5; i < arr.length; i++) {
//			// 遍历各组种所有的元素（共有5组，每组有2个元素，步长为5）
//			for (int j = i - 5; j >= 0; j -= 5) {
//				// 如果当前元素大于加上步长后的那个元素，说明需要交换
//				if (arr[j] > arr[j + 5]) {
//					temp = arr[j];
//					arr[j] = arr[j + 5];
//					arr[j + 5] = temp;
//				}
//			}
//		}
//		
//		System.out.println("希尔排序第一轮后=" + Arrays.toString(arr));

	//对交换式的希尔排序进行优化，移位法
	public static void shellSort2(int[] arr) {
		
		//增加gap，并逐步缩小增量
		for (int gap = arr.length / 2; gap > 0; gap /= 2) {
			//从第gap个元素，逐个对其所在的组进行直接插入排序
			for (int i = gap; i < arr.length; i++) {
				int j = i;//j为要插入的位置和对应的值
				int temp = arr[j];//j位置对应的值
				if(arr[j] < arr[j - gap]) {
					while (j - gap >= 0 && temp < arr[j - gap]) {//循环找位置，仅仅作判断移动，不进行交换
						//移动
						arr[j] = arr[j-gap];
						j -= gap;
					}
					//当退出while循环后，就给temp找到插入的位置
					arr[j] = temp;
					}
				}
			}
		}
	}
	