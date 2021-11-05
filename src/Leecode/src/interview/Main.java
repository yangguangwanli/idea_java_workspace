package interview;

//给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
//输入：head = [1,2,3,4,5]
//输出：[5,4,3,2,1]
//
//输入：head = [1,2]
//输出：[2,1]
//
//输入：head = []
//输出：[]
//

/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode() {} ListNode(int val) { this.val = val; } ListNode(int val,
 * ListNode next) { this.val = val; this.next = next; } }
 */

public class Main {

	public static void main(String[] args) {
		ListNode list4 = new ListNode(4);
		ListNode list3 = new ListNode(3, list4);
		ListNode list2 = new ListNode(2, list3);
		ListNode list1 = new ListNode(1, list2);
		list(list1);
		list(reverseList(list1));
	}

	public static void list(ListNode head) {
		if (head == null) {
			return;
		}
		ListNode cur = head;
		System.out.print(cur.val + "->");
		while (cur.next != null) {
			cur = cur.next;
			System.out.print(cur.val + "->");
		}
		System.out.println();
	}

	public static ListNode reverseList(ListNode head) {
		if (head == null) {
			return null;
		}
		//newhead一个新的头节点
		//cur为遍历指针
		ListNode cur = head;
		ListNode newhead = new ListNode(0, null);
		ListNode next = null;
		while (cur != null) {
			//next保存cur.next节点
			next = cur.next;
			//待插入的数据的next节点为上一个插入的节点
			cur.next = newhead.next;
			//新头节点的下一个位置指向插入的节点
			newhead.next = cur;
			//循环进行下一个节点
			cur = next;
		}
		//返回反转后的第一个节点
		return newhead.next;
	}
}

class ListNode {
	public Object reverseList;;
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
