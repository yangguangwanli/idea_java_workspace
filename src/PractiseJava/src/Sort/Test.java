package Sort;

public class Test {
//找字符串出现过几次子字符串
	public static void main(String[] args) {
		String s = "jacvaasdasdasjavasdasdasdasjavajavaasdSADFASD87java";
		String stoFind = "java";
		int count = 0;
		int index = -1;
		while (s.indexOf(stoFind) != -1) {//不为-1就是找到了有指定的子字符串
			index = s.indexOf(stoFind);//记录出现的位置
			//循环向后切割
			//substring(int i)返回子字符串从第几个位置开始往后的子字符串
			s = s.substring(index + stoFind.length());
			count ++;
		}
		System.out.println(count);
	}
}
