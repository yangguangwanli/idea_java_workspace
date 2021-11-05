

import java.util.Arrays;

//字符串匹配问题：：
//1) 有一个字符串 str1= "BBC ABCDAB ABCDABCDABDE"，和一个子串 str2="ABCDABD" 
//2) 现在要判断 str1 是否含有 str2, 如果存在，就返回第一次出现的位置, 如果没有，则返回-1
//3) 要求：使用 KMP 算法完成判断，不能使用简单的暴力匹配算法


public class KMPAlgorithm {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		String str1 = "BBC ABCDAB ABCDABCDABDE";
		
		String str2 = "ABCDABD";
		//String str2 = "ABCDABD";
		
		int[] next = kmpNext(str2);//
		System.out.println("next=" + Arrays.toString(next));
		
		int index = kmpSearch(str1, str2, next);
		System.out.println("index=" + index);
		
		
	}
	
	/**
	 * str1: 源字符串
	 * str2: 子串
	 * next: 部分匹配表，是字串对应的部分匹配表
	 * 如果是-1 就是没有匹配到，否则返回第一个匹配的位置
	 */
	
	//写出kmp搜索算法
	public static int kmpSearch(String str1, String str2, int[] next) {
		for (int i = 0, j = 0; i < str1.length(); i++) {
			//还需要考虑str1.charAt(i) ！= str2.charAt(j)的情况
			while (j > 0 && str1.charAt(i) != str2.charAt(j)) {
				j = next[j-1];//在不相等的时候重新调整j，j向部分匹配表的前面去找
			
			}
			if (str1.charAt(i) == str2.charAt(j)) {
				j++;//j的意思就是指向待查找的那个指针
			}
			
			if (j == str2.length()) {//找到了
				return i - j + 1;//补一个1，j++了，i还没加
			}
		}
		return -1;
	}
	
	//获取到一个字符串（子串）的部分匹配表
	public static int[] kmpNext(String dest) {
		//创建一个next数组保存部分匹配值
		int[] next = new int[dest.length()];
		next[0] = 0;//如果字符串是长度为1，部分匹配值就是0 
		for (int i = 1, j = 0; i < dest.length(); i++) {
			//当dest.charAt(i) ！= dest.charAt(j)，我们需要从next[j-1]获取新的j
			//直到我们发现有当dest.charAt(i) == dest.charAt(j)这个满足时才退出
			//KMP算法核心点
			while (j > 0 && dest.charAt(i) != dest.charAt(j)) {
				j = next[j-1];//如果发现有不相等的，就从j-1的那个位置更新j
			}
			//当dest.charAt(i) == dest.charAt(j)这个满足时，部分匹配值加1
			if (dest.charAt(i) == dest.charAt(j)) {
				j++;
			}
			next[i] = j;
		}
		return next;
	}
}
