

public class demo 
{
	
	public static void main(String[] args)
	{
		byte a = 127;//占1个字节，一个字节8位
		short b = 128;//占两2个字节
		int c= 128;//占4个字节
		long d = 128;//占8个字节
		

		char e = '中';//占两个字节；16位表示正数
		short s;//占两个字节；去掉符号位只有15位表示数值
		s = (short)e;//把大范围的数据赋值给小范围，需要强制转换
		int i = e;//自动转换，int占4个字节
		
		System.out.println(c+"在编码表中的序号是:"+i);
		
//		char a = 20013;
		
//		System.out.println("20013在编码表中的序号是:"+a);
		
	}

}

/*
 * String类常用方法 public char charAt(int index) 返回字符串中第index个字符
 * 
 * public int length() 返回字符串长度
 * 
 * public int indexOf(String str) 返回字符串中str的第一个位置
 * 
 * public int indexOf(String str, int fromIndex) 返回字符串中从fromIndex开始出现str的第一个位置
 * 
 * public boolean equals(String another) 比较字符串与another是否一样，不忽略大小写
 * 
 * public boolean equalsIgnoreCase(String another) 比较字符串与another是否一样（忽略大小写）
 * 
 * public String replace(char oldChar, char NewChar) 在字符串中用newChar字符替换oldChar字符
 * 
 */

/*
 * String类常用方法 public boolean startsWith(String prefix) 判断字符串是否以prefix字符串开头
 * 
 * public boolean endsWith(String suffix) 判断字符串是否以suffix字符串开头
 * 
 * public String toUpperCase() 返回一个字符串为该字符串的大写形式
 * 
 * public String toLowerCase() 返回一个字符串为该字符串的小写形式
 * 
 * public String substring(int beginIndex) 返回字符串从beginIndex开始到结尾的子字符串
 * 
 * public String substring(int beginIndex, int endIndex)
 * 返回字符串从beginIndex开始到以endIndex结尾的子字符串
 * 
 * public String trim() 返回将该字符串去掉开头和结尾空格后的字符串
 */

/*
 * 静态重载方法 public static String valueOf（...） 可以将基础数据类型转化为字符串
 * 
 * public String[] split(String regex) 可以将一个字符串按照指定的分隔符分隔，返回分隔后的字符串数组
 */

