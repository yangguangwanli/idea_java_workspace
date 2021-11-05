package sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

import javax.swing.text.SimpleAttributeSet;



public class BubbleSort {
//冒泡排序
//从小到大排序一个数组，时间复杂度位O(n^2)
	public static void main(String[] args) {
//		int arr[] = { 3, 9, -1, 10, 20 };
		
		//测试冒泡排序速度O(n^2),给80000个数据，测试
		//创建要给80000个随机的数组
		int[] arr = new int[80000];
		for (int i = 0; i < 80000; i++) {
			arr[i] = (int)(Math.random() * 8000000);//生成一个[0,800000)的随机数
		}
		
		Date data1 = new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String data1Str = simpleDateFormat.format(data1);
		System.out.println("排序前的时间是=" + data1Str);
		
		//测试冒泡排序所耗费的时间
		bubbleSort(arr);
		//test
		
		Date data2 = new Date();
		String data2Str = simpleDateFormat.format(data2);
		System.out.println("排序后的时间是=" + data2Str);
		
//		System.out.println("排序后");
//		System.out.println(Arrays.toString(arr));
	}

//将前面的冒泡排序封装成一个方法
	public static void bubbleSort(int[] arr) {
		int temp = 0;
		boolean flag = false;//标识符，表述是否进行过交换
		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = 0; j < arr.length - 1 - i; j++) {//从前往后，每次确定最右边最大的一个数
				// 如果前面的数大于后面的数字，则交换
				if (arr[j] > arr[j + 1]) {
					flag = true;
					temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
//			System.out.printf("第%d趟排序后的数组\n", i+1);
//			System.out.println(Arrays.toString(arr));//数组方法输出
			
			if (!flag) {//在一趟排序中，一次交换都没有发生过
				break;
			}else {
				flag = false;//重置flag！！！进行下次判断
			}
		}
	}
}