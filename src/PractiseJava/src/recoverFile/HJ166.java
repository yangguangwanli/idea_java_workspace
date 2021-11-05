package recoverFile;
import java.util.*;
//有6条配置命令，它们执行的结果分别是：

//命   令	执   行
//reset				reset what
//reset board		board fault
//board add			where to add
//board delete		no board at all
//reboot backplane	impossible
//backplane abort	install first
//he he				unknown command
//注意：he he不是命令。
//
//为了简化输入，方便用户，以“最短唯一匹配原则”匹配：
//1、若只输入一字串，则只匹配一个关键字的命令行。
//例如输入：r，根据该规则，匹配命令reset，执行结果为：reset what；
//输入：res，根据该规则，匹配命令reset，执行结果为：reset what；
//2、若只输入一字串，但本条命令有两个关键字，则匹配失败。
//例如输入：reb，可以找到命令reboot backpalne，但是该命令有两个关键词，所有匹配失败，执行结果为：unknown command
//3、若输入两字串，则先匹配第一关键字，如果有匹配但不唯一，继续匹配第二关键字，如果仍不唯一，匹配失败。
//例如输入：r b，找到匹配命令reset board 和 reboot backplane，执行结果为：unknown command。
//
//4、若输入两字串，则先匹配第一关键字，如果有匹配但不唯一，继续匹配第二关键字，如果唯一，匹配成功。
//例如输入：b a，无法确定是命令board add还是backplane abort，匹配失败。
//5、若输入两字串，第一关键字匹配成功，则匹配第二关键字，若无匹配，失败。
//例如输入：bo a，确定是命令board add，匹配成功。
//6、若匹配失败，打印“unknown command”
//
//输入描述：
//多行字符串，每行字符串一条命令
//
//输出描述：
//执行结果，每条命令输出一行
//
//示例1
//输入：
//reset
//reset board
//board add
//board delet
//reboot backplane
//backplane abort
// 
//输出：
//reset what
//board fault
//where to add
//no board at all
//impossible
//install first

//1.先判断输入字符串的长度，长度为1时，只匹配关键词为1的字符串，
//比如输入r只能匹配reset，同理长度为2的只能匹配关键词长度为2的字符串，比如输入r b
//只能匹配reset board和reboot backplane。
//2.如果匹配出的结果不唯一，也就是匹配到两个，则匹配不成功。
//比如输入r b，匹配reset board和reboot backplane，用计数器可以解决，此时输出 unknown command
public class HJ166 {
	//字符串匹配：1.先看匹配串是一个字符还是两个字符，一个字符时，看匹配的字符是单字符还是双字符，单字符可以，双字符不行
	//2.匹配串是两个字符时，看匹配了几个，只能匹配一个的话，算成功。大于一种，算不成功
	    public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);
	        //hashmap数据结构保存，key-value形式保存
	        //存放数据
	        Map<String, String> map = new HashMap<>();
	        map.put("reset","reset what");
	        map.put("reset board","board fault");
	        map.put("board add","where to add");
	        map.put("reboot backplane","impossible");
	        map.put("backplane abort","install first");
	        map.put("board delete","no board at all");
	        map.put("noMatch","unknown command");
	        //构建一个字符串类型hashset（看作为数组集合）
	        Set<String[]> str = new HashSet<>();
	        //把每一个key的字符串用" "分开，再存入str中
	        //存入形式是：str[0]放第一个空格左边的数组集合，str[1]放的是第一个空格右边的数组集合
	        for (String s : map.keySet()) {
	            str.add(s.split(" "));
	        }

	        while (sc.hasNext()){
	        	//把输入的字符串用" "分开，保存再字符串数组中
	            String[] arr = sc.nextLine().split(" ");
	            //初始化res，和数量
	            String res = "noMatch";
	            int count = 0;
	            //循环对保存在str的数据遍历
	            for (String[] s: str) {
	            	//如果输入的单词个数与数组存放的单词个数不匹配，则继续大循环
	                if (arr.length == 1){
	                    if (s.length == 2)
	                        continue;
	                    //输入的单词个数与数组存放的单词个数都为1，则判断首单词能否成功匹配
	                    else {
	                        if (s[0].startsWith(arr[0]))
	                        	//成功则把key传回
	                            res = s[0];
	                    }
	                }
	                ////如果输入的单词个数与数组存放的单词个数不匹配，则继续大循环
	                if (arr.length==2){
	                    if (s.length==1)
	                        continue;
	                    //输入的单词个数与数组存放的单词个数都为2，则判断两个首单词能否成功匹配
	                    else{
	                        if (s[0].startsWith(arr[0]) && s[1].startsWith(arr[1])) {
	                        	//若成功匹配则成功返回正确结果key
	                            res = s[0] + " " + s[1];
	                            //count用于判断是否成功得到一次值
	                            count++;
	                        }
	                    }
	                }
	            }
	            //0，1适用，后续重复得到成功的匹配数据不再算数
	            System.out.println(count > 1 ? "unknown command" : map.get(res));
	        }
	    }
	}
