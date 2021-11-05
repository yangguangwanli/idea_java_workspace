

/**
 * @Auther: Renjie
 * @Date: 2021/11/2 - 16:27
 * @Description: 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 * @Version: 1.0
 */
public class practice {
    public static void main(String[] args) {

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
}


class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode newHead = new ListNode(0,head);
        //pre用以将删除重复节点之后剩余的链表部分连接起来
        //cur指向头节点head，表示当前考察的节点
        ListNode pre = newHead;
        ListNode cur = pre.next;
        while(cur != null){
            int curReaptNum = 0;
            ListNode difNode = cur;
            //此时初始化的时候difNode和cur指向的是同一个节点，因此curReaptNum至少为1
            //找到和cur指向的节点不同的节点
            while(difNode != null && difNode.val == cur.val){
                curReaptNum ++;
                difNode = difNode.next;
            }
            //退出循环difNode指向下一个非重复节点
            //如果curReaptNum的值大于1.则表示cur指向的节点重复出现了
            if(curReaptNum > 1){
                //删除中间重复节点
                pre.next = difNode;
            }else{
                //未重复后移一位即可
                pre = cur;
            }
            //移动指针，考察下一个不重复节点
            cur = difNode;
        }
        return newHead.next;
    }
}
