package whichdayOfyear;

import java.util.Scanner;

public class WhichdayOfyear {
//			描述
//			根据输入的日期，计算是这一年的第几天。
	//
	//
//			输入描述：
//			输入一行，每行空格分割，分别是年，月，日
	//
//			输出描述：
//			输出是这一年的第几天
//			示例1
//			输入：
//			2012 12 31
//			复制
//			输出：
//			366
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			int year = scanner.nextInt();
			int month = scanner.nextInt();
			int day = scanner.nextInt();
			calculateDate(year, month, day);
		}
		scanner.close();
	}

	public static void calculateDate(int year, int month, int day) {
		int sumDay = 0;
		// 正常月份(index)对应的天数；
		int[] normMonthDay = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
		// 判断是不是闰年，如果是闰年，false；
		boolean isNormYear = (year % 4 == 0) && (year % 100 != 0)  ? false : true;
		// 累加除了最后一个月份的天数；
		for (int i = 1; i < month; i++) {
			// 如果是闰年2月，那么闰年2月应为为29天
			if (i == 2 && !isNormYear) {
				sumDay += 29;
				// 跳过2月的天数相加
				continue;
			}
			sumDay += normMonthDay[i];
		}
		// 加上最后一个月份的天数；
		sumDay += day;
		// 打印答案
		System.out.println(sumDay);
	}
}