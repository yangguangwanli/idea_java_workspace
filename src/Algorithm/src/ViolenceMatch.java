

public class ViolenceMatch {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		String str1 = "硅硅谷 尚硅谷你上硅谷 尚硅谷你尚硅你谷你尚硅谷你好";
		String str2 = "尚硅谷你尚硅你";
		int index = violenceMatch(str1, str2);
		System.out.println("index=" + index);
	}
	
	
	//暴力匹配算法实现
	//缺点：每回都要回溯，性能过低
	public static int violenceMatch(String str1, String str2) {
		char[] s1 = str1.toCharArray();
		char[] s2 = str2.toCharArray();
		
		//默认2为更短的那个字符串
		int s1Len = s1.length;
		int s2Len = s2.length;
		
		int i = 0;//i索引指向s1
		int j = 0;//j索引指向s2
		while (i < s1Len && j < s2Len) {//保证匹配时不越界
			
			if (s1[i] == s2[j]) {//匹配ok
				i++;
				j++;
			}else {//未能匹配成功
				//如果匹配失败，即s1[i] ！= s2[j]
				//则令i=i - (j - 1),j = 0;
				i = i - (j - 1);
				j = 0;
			}
		}
		//判断是否匹配成功
		if (j == s2Len) {
			return i - j;//返回找到的那个下标
		}else {
			return -1;
		}
		
	}
}
