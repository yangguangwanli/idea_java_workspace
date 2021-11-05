package doublepointer;
//Input:

//s = "abpcplea", d = ["ale","apple","monkey","plea"]
//
//Output:
//"apple"

//题目描述：删除 s 中的一些字符，使得它构成字符串列表 d 中的一个字符串，找出能构成的最长字符串
//如果有多个相同长度的结果，返回字典序的最小字符串
import java.util.List;
//我们可以使用双指针来判断一个字符串是否为另一个字符串的子序列
public class LongestWord {

	public static void main(String[] args) {

	}
	public String findLongestWord(String s, List<String> d) {
	    String longestWord = "";
	    for (String target : d) {
	        int l1 = longestWord.length(), l2 = target.length();
	        //如果有多个相同长度的结果，返回字典序的最小字符串:(l1 == l2 && longestWord.compareTo(target) < 0)
	        //longestWord.compareTo(target) < 0,意为longestWord的字典序比target更小
	        if (l1 > l2 || (l1 == l2 && longestWord.compareTo(target) < 0)) {
	            continue;
	        }
	        if (isSubstr(s, target)) {
	            longestWord = target;
	        }
	    }
	    return longestWord;
	}

	//写一个判断target是否是字符串s的子序列
	//通过删除字符串 s 中的一个字符能得到字符串 t，可以认为 t 是 s 的子序列
	private boolean isSubstr(String s, String target) {
	    int i = 0, j = 0;
	    while (i < s.length() && j < target.length()) {
	        if (s.charAt(i) == target.charAt(j)) {
	        	//j表明target的字符在s字符串中匹配的个数
	            j++;
	        }
	        i++;
	    }
	    //若完全匹配，则返回ture
	    return j == target.length();
	}

}
