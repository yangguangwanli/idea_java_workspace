package huankongpinzi;

import java.util.Scanner;

public class Huankongpinzi {
//	有这样一道智力题：“某商店规定：三个空汽水瓶可以换一瓶汽水。
//	小张手上有十个空汽水瓶，她最多可以换多少瓶汽水喝？”答案是5瓶，
//	方法如下：先用9个空瓶子换3瓶汽水，喝掉3瓶满的，喝完以后4个空瓶子，
//	用3个再换一瓶，喝掉这瓶满的，这时候剩2个空瓶子。然后你让老板先借给你一瓶汽水，
//	喝掉这瓶满的，喝完以后用3个空瓶子换一瓶满的还给老板。
//	如果小张手上有n个空汽水瓶，最多可以换多少瓶汽水喝？

//	思路：
//	1、现在手上有多少个空瓶子？如果是大于3个的话又会分成两种情况
//	第一种情况是被3整除的，另一种是有余数剩下的
//	2、换回来的瓶子又有多少个？不断的循环，如果是剩下2个瓶子，那么还可以换一个。
//	所以K+1
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			int n = sc.nextInt();// n为空瓶数
			int k = 0;// K为可以换的瓶数
			while (n >= 3) {
				if (n % 3 == 0) {
					k = k + n / 3;
					n = n / 3;// 换来的汽水喝掉的空瓶数
				}
				if (n % 3 != 0) {
					k = k + n / 3;
					int t = n % 3;
					n = n / 3 + t;// 注意这里n只代表单次循环需要返回的空瓶子值
				}
			}
			if (n == 2) {
				k = k + 1;
			}
			System.out.println(k);
		}
	}
}
