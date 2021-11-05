package myspace.Interview;

import com.sun.org.apache.bcel.internal.generic.NEW;

import java.util.*;

/**
 * @Auther: Renjie
 * @Date: 2021/10/13 - 16:20
 * @Description: {PACKAGE_NAME}
 * @Version: 1.0
 * <p>
 * //外观函数
 * 给定一个正整数 n ，输出外观数列的第 n 项。
 * <p>
 * 「外观数列」是一个整数序列，从数字 1 开始，序列中的每一项都是对前一项的描述。
 * <p>
 * 你可以将其视作是由递归公式定义的数字字符串序列：
 * <p>
 * countAndSay(1) = "1"
 * countAndSay(n) 是对 countAndSay(n-1) 的描述，然后转换成另一个数字字符串。
 * 前五项如下：
 * <p>
 * 1.     1
 * 2.     11
 * 3.     21
 * 4.     1211
 * 5.     111221
 * 第一项是数字 1
 * 描述前一项，这个数是 1 即 “ 一 个 1 ”，记作 "11"
 * 描述前一项，这个数是 11 即 “ 二 个 1 ” ，记作 "21"
 * 描述前一项，这个数是 21 即 “ 一 个 2 + 一 个 1 ” ，记作 "1211"
 * 描述前一项，这个数是 1211 即 “ 一 个 1 + 一 个 2 + 二 个 1 ” ，记作 "111221"
 */

public class Practice {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            System.out.println();
        }

    }


}


class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    class Solution12 {
        public ListNode removeNthFromEnd(ListNode head, int n) {
            ListNode newhead = new ListNode(0, head);
            Deque<ListNode> stack = new LinkedList<>();
            ListNode cur = newhead;
            while (cur != null) {
                stack.push(cur);
                cur = cur.next;
            }
            //弹出链表最后面n个元素，找到它的前一个位置的元素
            for (int i = 0; i < n; i++) {
                stack.pop();
            }
            //剩余的栈取栈顶元素，找到这前一个位置的节点，让它指向下下一个节点即可
            ListNode pre = stack.peek();
            pre.next = pre.next.next;
            ListNode res = newhead.next;
            return res;

        }
    }

    class Solution11 {
        public ListNode deleteDuplicates(ListNode head) {
            if (head == null) {
                return head;
            }
            ListNode newhead = new ListNode(0, head);
            ListNode cur = newhead.next;
            while (cur.next != null) {
                if (cur.val == cur.next.val) {
                    cur.next = cur.next.next;
                } else {
                    cur = cur.next;
                }
            }
            return newhead.next;
        }

        public ListNode deleteDuplicates121(ListNode head) {
            ListNode newHead = new ListNode(0);
            newHead.next = head;
            //pre用以将删除重复结点之后剩余的链表部分连接起来
            //cur指向头结点head，表示当前考察的结点

            ListNode pre = newHead;
            ListNode cur = pre.next;
            while (cur != null) {
                //记录重复节点的次数,difNode记录和当前考察结点不同的结点位置
                int curReaptNum = 0;
                ListNode difNode = cur;
                //此时初始化的时候difNode和cur指向的是同一个节点，因此curReaptNum至少为1
                //找到和cur指向的节点值不同的节点
                while (difNode != null && difNode.val == cur.val) {
                    curReaptNum++;
                    difNode = difNode.next;
                }
                //循环后difNode指向下一个非重复节点
                //如果curReaptNum的值大于1，则表示cur指向的节点重复出现了
                if (curReaptNum > 1) {
                    //删除中间的重复节点
                    pre.next = difNode;
                } else {//没有重复出现，就把pre指向cur即可
                    pre = cur;
                }
                //移动指针，考察当前节点
                cur = difNode;
            }
            return newHead.next;
        }
    }
}