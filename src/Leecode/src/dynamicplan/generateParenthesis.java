package dynamicplan;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: Renjie
 * @Date: 2021/11/2 - 12:33
 * @Description: {PACKAGE_NAME}
 * @Version: 1.0
 */
public class generateParenthesis {

    public static List<String> generateParenthesis1(int n) {
        //问题转化为：给一个字符串循环循环添加左括号或右括号的事情
        //分析：用二叉树，左边插入左括号，右边插入右括号，然后取出满足条件的所有字符串
        //根据题目分析得出：字符串有以下特征：1、左括号数量等于右括号，2、字符串的总括号数量等于n * 2
        //因此对于这个问题就是：
        // 【第一个位置放左括号去解决剩下2n - 1个括号排列问题】和【第一个位置放右括号去剩下解决2n - 1个括号排列问题】
        //再递归之后的括号插入问题。最后的边界就是插入的  字符串的总括号数量等于n * 2   才加入集合中
        //剪枝：添加判断左右递归的条件
        List<String> list = new ArrayList<>();
        if (n <= 0) {
            return list;
        }
        if (n == 1) {
            list.add("()");
            return list;
        }
        dfs1(n, "", list, 0, 0);
        return list;

    }

    private static void dfs1(int n, String str, List<String> list, int left, int right) {
        //        if(left > n || right > left){
//            return;
//        }

        if (str.length() == 2 * n) {
            list.add(str);
            return;
        }
        //字符串的添加顺序是从右边插入，因此一定是左括号优先插入
        //只能在左括号数量 < n 才向左递归
        if (left < n) {
            dfs1(n, str + "(", list, left + 1, right);//向左递归
        }
        //只能在右括号数量 < 左括号数量 才向右递归
        if (right < left) {
            dfs1(n, str + ")", list, left, right + 1);//向右递归
        }
            //        dfs(n, path + "(", res, left + 1, right);
            //        dfs(n, path + ")", res, left, right + 1);

    }


    public static void main(String[] args) {
        System.out.println(generateParenthesis1(3));
    }
}