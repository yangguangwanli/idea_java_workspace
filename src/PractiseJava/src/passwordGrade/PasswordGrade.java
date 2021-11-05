package passwordGrade;
//描述

//密码按如下规则进行计分，并根据不同的得分为密码进行安全等级划分。
//
//一、密码长度:
//
//5 分: 小于等于4 个字符
//
//10 分: 5 到7 字符
//
//25 分: 大于等于8 个字符
//
//二、字母:
//
//0 分: 没有字母
//
//10 分: 全都是小（大）写字母
//
//20 分: 大小写混合字母
//
//三、数字:
//
//0 分: 没有数字
//
//10 分: 1 个数字
//
//20 分: 大于1 个数字
//
//四、符号:
//
//0 分: 没有符号
//
//10 分: 1 个符号
//
//25 分: 大于1 个符号
//
//五、奖励:
//
//2 分: 字母和数字
//
//3 分: 字母、数字和符号
//
//5 分: 大小写字母、数字和符号
//
//最后的评分标准:
//
//>= 90: 非常安全
//
//>= 80: 安全（Secure）
//
//>= 70: 非常强
//
//>= 60: 强（Strong）
//
//>= 50: 一般（Average）
//
//>= 25: 弱（Weak）
//
//>= 0:  非常弱
//
//
//对应输出为：
//
//VERY_SECURE
//
//SECURE
//
//VERY_STRONG
//
//STRONG
//
//AVERAGE
//
//WEAK
//
//VERY_WEAK
//
//
//请根据输入的密码字符串，进行安全评定。
//
//注：
//
//字母：a-z, A-Z
//
//数字：0-9
//
//符号包含如下： (ASCII码表可以在UltraEdit的菜单view->ASCII Table查看)
//
//!"#$%&'()*+,-./     (ASCII码：0x21~0x2F)
//
//:;<=>?@             (ASCII码：0x3A~0x40)
//
//[\]^_`              (ASCII码：0x5B~0x60)
//
//{|}~                (ASCII码：0x7B~0x7E)
//
//
//
//提示:
//1 <= 字符串的长度<= 300
//输入描述：
//本题含有多组输入样例。
//每组样例输入一个string的密码
//
//输出描述：
//每组样例输出密码等级
//
//示例1
//输入：
//38$@NoNoNo
//123
//
//输出：
//VERY_SECURE
//WEAK
//
//说明：
//第一组样例密码强度为95分。
//第二组样例密码强度为25分。    
//示例2
//输入：
//Jl)M:+
//
//输出：
//AVERAGE
//
//说明：
//示例2的密码强度为55分
	import java.util.Scanner;
	public class PasswordGrade {
			public static void main(String[] args) {
				Scanner sc = new Scanner(System.in);
				while (sc.hasNextLine()) {
					char[] chars = sc.nextLine().toCharArray();
					int grade = f1(chars) + f2(chars) + f3(chars) + f4(chars);
					if (f2(chars) == 20 && f3(chars) != 0 && f4(chars) != 0) {
						grade += 5;
					} else if (f2(chars) == 10 && f3(chars) != 0 && f4(chars) != 0) {
						grade += 3;
					} else if (f2(chars) == 10 && f3(chars) != 0 && f4(chars) == 0) {
						grade += 2;
					}
					f(grade);
				}
			}

			public static void f(int grade) {
				if (grade >= 90) {
					System.out.println("VERY_SECURE");
				} else if (grade >= 80 && grade < 90) {
					System.out.println("SECURE");
				} else if (grade >= 70 && grade < 80) {
					System.out.println("VERY_STRONG");
				} else if (grade >= 60 && grade < 70) {
					System.out.println("STRONG");
				} else if (grade >= 50 && grade < 60) {
					System.out.println("AVERAGE");
				} else if (grade >= 25 && grade < 50) {
					System.out.println("WEAK");
				} else if (grade >= 0 && grade < 25) {
					System.out.println("VERY_WEAK");
				}
			}

			// 一、密码长度
			public static int f1(char[] chars) {
				if (chars.length >= 8) {
					return 25;
				} else if (chars.length > 4 && chars.length < 8) {
					return 10;
				} else {
					return 5;
				}
			}

			// 二、字母:
			public static int f2(char[] chars) {
				int lcount = 0;
				int scount = 0;
				for (int i = 0; i < chars.length; i++) {
					if (chars[i] >= 'A' && chars[i] <= 'Z') {
						lcount++;
					} else if (chars[i] >= 'a' && chars[i] <= 'z') {
						scount++;
					}
				}
				if (lcount > 0 && scount > 0) {
					return 20;
				} else if (lcount > 0 && scount == 0) {
					return 10;
				} else if (scount > 0 && lcount == 0) {
					return 10;
				} else {
					return 0;
				}
			}

			// 三、数字
			public static int f3(char[] chars) {
				int ncount = 0;
				for (int i = 0; i < chars.length; i++) {
					if (chars[i] >= '0' && chars[i] <= '9') {
						ncount++;
					}
				}
				if (ncount > 1) {
					return 20;
				} else if (ncount == 1) {
					return 10;
				} else {
					return 0;
				}
			}

	// 四、符号（手动把十六进制二进制换算成10进制)
			//符号包含如下： (ASCII码表可以在UltraEdit的菜单view->ASCII Table查看)
			//
			//!"#$%&'()*+,-./     (ASCII码：0x21~0x2F) 十进制是2*16+1~2*16+ 15
			//
			//:;<=>?@             (ASCII码：0x3A~0x40)	3*16+10~4*16
			//
			//[\]^_`              (ASCII码：0x5B~0x60)
			//
			//{|}~                (ASCII码：0x7B~0x7E)
			public static int f4(char[] chars) {
				int fcount = 0;
				for (int i = 0; i < chars.length; i++) {
					if (chars[i] >= 33 && chars[i] <= 47) {
						fcount++;
					} else if (chars[i] >= 58 && chars[i] <= 64) {
						fcount++;
					} else if (chars[i] >= 91 && chars[i] <= 96) {
						fcount++;
					} else if (chars[i] >= 123 && chars[i] <= 126) {
						fcount++;
					}
				}
				if (fcount > 1) {
					return 25;
				} else if (fcount == 1) {
					return 10;
				} else {
					return 0;
				}
			}
		}