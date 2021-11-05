package sort;

import java.util.Arrays;

public class QuickSort {

	public static void main(String[] args) {
		int[] arr = { -9, 78, 0, 23, -567, 70, -1, 900, 4561 };
		quickSort(arr, 0, arr.length - 1);
		System.out.println("arr=" + Arrays.toString(arr));
	}

	public static void quickSort(int[] arr, int left, int right) {
		int l = left;
		int r = right;

		// pivot 中轴
		int pivot = arr[(left + right) / 2];
		int temp = 0;
		// while循环的目的是让 比pivot小的值放到左边
		// 比pivot 大的值放在右边
		while (l < r) {
			// 在pivot的左边一直找，找到大于等于pivot的值，才退出，这时候l保存的是一个大于等于pivot的元素的下标
			while (arr[l] < pivot) {
				l += 1;
			}
			// 在pivot的右边一直找，找到小于等于pivot的值，才退出，这时候r保存的是一个小于等于pivot的元素的下标
			while (arr[r] > pivot) {
				r -= 1;
			}
			// l >= r 说明pivot的左右两值，已经按照左边全部是
			// 小于pivot的值，右边全部是大于等于pivot的值
			if (l >= r) {
				break;
			}

			// 交换
			temp = arr[l];
			arr[l] = arr[r];
			arr[r] = temp;

			// 如果交换完后，发现这个arr[l] == pivot值相等 r--,前移,目的是退出循环
			if (arr[l] == pivot) {
				r -= 1;
			}
			// 如果交换完后，发现这个arr[r] == pivot值相等 l++.后移，目的是退出循环
			if (arr[r] == pivot) {
				l += 1;
			}
		}

		// 如果 l == r ,双向走一位，必须l++ ，r--,否则会出现栈溢出
		if (l == r) {
			l += 1;
			r -= 1;
		}
		// 向左递归
		if (left < r) {
			quickSort(arr, left, r);
		}
		// 向右递归
		if (right > l) {
			quickSort(arr, l, right);
		}
	}
}
