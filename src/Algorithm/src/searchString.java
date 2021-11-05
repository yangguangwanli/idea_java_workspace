

public class searchString {
//寻找A字符串在B字符串出现的次数
	public static void main(String[] args) {
		String s = "sunjavajavahttpjavaokjavahaha001javajavajeeeeejavaoraclejava";
		String sToFind = "oracle";
		int count = 0;
		int index = -1;
		while (s.indexOf(sToFind) != -1) {
			//indexOf方法返回第一次出现后面子串的第一个位置
			index = s.indexOf(sToFind);
			//位置加上自身的长度
			s = s.substring(index + sToFind.length());
			//找到一次
			count++;
		}
		System.out.println(count);
	}
}
