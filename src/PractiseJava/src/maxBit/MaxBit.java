package maxBit;

import java.util.Scanner;

public class MaxBit {
//	描述
//	求一个byte数字对应的二进制数字中1的最大连续数，例如3的二进制为00000011，最大连续2个1
//
//	本题含有多组样例输入。
//
//	输入描述：
//	输入一个byte数字
//
//	输出描述：
//	输出转成二进制之后连续1的个数
//
//	示例1
//	输入：
//	3
//	5
//
//	输出：
//	2
//	1
//	
//	说明：
//	3的二进制表示是11，最多有2个连续的1。
//	5的二进制表示是101，最多只有1个连续的1。
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while (in.hasNextInt()) {
			int num = in.nextInt();
			int res = 0;
			int temp = 0;
			//二进制编码右移位，最终全为0，跳出循环
			while (num != 0) {
				//位运算，eg 00001101 按位‘与’，00000001，有一个就加上，并且保存结果
				if ((num & 1) == 1) {
					temp++;
					//res保存较大次数
					res = Math.max(res, temp);
				} else {
					// 遇到 0 temp归 0 重新开始计数
					temp = 0;
				}
				// 右移一位
				num >>= 1;
			}
			System.out.println(res);
		}
	}
}

//    public static void main(String[] args){
//        Scanner in = new Scanner(System.in);
//        while(in.hasNextInt()){
//            String str = Integer.toBinaryString(in.nextInt());
//			  //以‘0’为分隔符，放入字符串数组，找到长度最大的那个
//            String s[] = str.split("0");
//            int max = 0;
//            for(int i = 0; i < s.length; i++)
//                if(max < s[i].length())
//                    max = s[i].length();
//            System.out.println(max);
//        }
//        in.close();
//    }
//}
