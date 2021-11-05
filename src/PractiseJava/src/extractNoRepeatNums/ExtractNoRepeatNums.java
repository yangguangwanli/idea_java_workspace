package extractNoRepeatNums;
import java.util.*;
//提取不重复的字符串，倒序输出
public class ExtractNoRepeatNums {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNextLine()) {
            StringBuffer sb = new StringBuffer(sc.nextLine());
            sb.reverse();
            String res = new String();
            //注意contains后面是字符串，不能是字符，得用subString
            for(int i = 0; i < sb.length(); i++){
            	//如果不包括那个字符串就后面加上
                if( !res.contains(sb.substring(i,i+1))){
                    res += sb.substring(i,i+1);
                }
            }
           System.out.println(res);
        }
    }
}