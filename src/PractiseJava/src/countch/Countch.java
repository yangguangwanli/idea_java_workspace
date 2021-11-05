package countch;

import java.util.*;

//描述
//输入一个只包含小写英文字母和数字的字符串，按照不同字符统计个数由多到少输出统计结果，
//如果统计的个数相同，则按照ASCII码由小到大排序输出。
//本题含有多组样例输入
//
//输入描述：
//一个只包含小写英文字母和数字的字符串。
//
//输出描述：
//一个字符串，为不同字母出现次数的降序表示。若出现次数相同，则按ASCII码的升序输出。
//
//示例1
//输入：
//aaddccdc
//1b1bbbbbbbbb
//
//输出：
//cda
//b1
//
//说明：
//第一个样例里，c和d出现3次，a出现2次，但c的ASCII码比d小，所以先输出c，再输出d，最后输出a
public class Countch {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String s = sc.nextLine();
            // 统计字符
            int[] arr = new int[36];
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (c >= 'a' && c <= 'z') {// 字母
                    arr[c - 'a']++;
                } else {// 数字
                    arr[c - '0' + 26]++;
                }
            }
            // 统计结果存入List集合
            List<Node> list = new ArrayList<>();
            for (int i = 0; i < 36; i++) {
                //避免未出现的字符
                if (arr[i] != 0) {
                    //注意这里是i<26 ,表示当时存入的字母
                    if (i < 26) {// 字母
                        list.add(new Node((char) ('a' + i), arr[i]));
                    } else {// 数字
                        list.add(new Node((char) ('0' + i - 26), arr[i]));
                    }
                }
            }
            // 排序
            Collections.sort(list, new Comparator<Node>() {
                public int compare(Node a, Node b) {
                    //compare方法默认比较是第一个值大于第二个值返回正值；第一个值小于第二个值返回
                    //这里需要重写方法，对于不同字母出现次数的降序表示，对出现次数相同的字符进行ASCII码升序排列
                    if (a.v != b.v) {// 根据值排序
                        return b.v - a.v;
                    } else {// 值相等根据ASCII码排序
                        return a.k - b.k;
                    }
                }
            });
            // 输出结果
            for (int i = 0; i < list.size(); i++) {
                //排序完后进行
                System.out.print(list.get(i).k);
            }
            System.out.println();
        }
    }
}

//自己写一个类
class Node {
    char k;
    int v;

    public Node(char k, int v) {
        this.k = k;
        this.v = v;
    }
}