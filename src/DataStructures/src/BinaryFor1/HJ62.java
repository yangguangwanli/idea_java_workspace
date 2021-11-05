package BinaryFor1;

import java.util.Scanner;

public class HJ62 {
//把一个十进制整型计算他的二进制的1的个数
	public static void main(String[] args) {
	
		System.out.println("please input a Integer");
		Scanner sc = new Scanner(System.in);//先扫描进来一段字符串	
		
		while(sc.hasNext()){//循环扫描
			int count = 0;//计数1的个数
			int n = sc.nextInt();//把字符串转换为整型
			 String r = Integer.toBinaryString(n);//十进制整型再转换为二进制字符串
             for (int i = 0; i <= r.length() - 1; i++) {
				if (r.charAt(i) == '1') {//遍历这个二进制字符串，找到字符1就记数
					count ++;
				}
			}
            System.out.println(count);//输出
		}
	}
}

//把任意进制字符串转化为十进制整型：Integer.valueOf(str, redix)
//把十进制整型转化为任意进制字符串:toString(int a ,rex)