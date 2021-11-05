package linkedlist;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

public class SingleLinkedListDemo {

	public static void main(String[] args) {
		// test
		// 先创建节点
		HeroNode hero1 = new HeroNode(1, "宋江", "及时雨");
		HeroNode hero2 = new HeroNode(5, "卢俊义", "玉麒麟");
		HeroNode hero3 = new HeroNode(3, "吴用", "智多星");
		HeroNode hero4 = new HeroNode(9, "林冲", "豹子头");

		HeroNode hero5 = new HeroNode(2, "刘备", "皇叔");
		HeroNode hero6 = new HeroNode(8, "曹操", "枭雄");
		HeroNode hero7 = new HeroNode(6, "孙权", "小孩");
		HeroNode hero8 = new HeroNode(4, "司马懿", "赢家");

		// 先创建一个链表

		SinggleLinkedList singgleLinkedList1 = new SinggleLinkedList();
		singgleLinkedList1.addByOrder(hero1);
		singgleLinkedList1.addByOrder(hero2);
		singgleLinkedList1.addByOrder(hero3);
		singgleLinkedList1.addByOrder(hero4);

		SinggleLinkedList singgleLinkedList2 = new SinggleLinkedList();
		singgleLinkedList2.addByOrder(hero5);
		singgleLinkedList2.addByOrder(hero6);
		singgleLinkedList2.addByOrder(hero7);
		singgleLinkedList2.addByOrder(hero8);

		// 测试逆序打印单链表
		System.out.println("第一个链表是：");
		singgleLinkedList1.list();
		System.out.println("第二个链表是：");
		singgleLinkedList2.list();
		SinggleLinkedList L1 = new SinggleLinkedList();
//		while (true) {
//			L1.addByOrder(merge(singgleLinkedList1.getHead(), singgleLinkedList2.getHead()));
//		}

		//测试下单链表的反转功能
		System.out.println("原来链表的情况~~");
        singgleLinkedList2.list();	
        //反转单链表
        System.out.println("反转单链表~~");
        reversetList(singgleLinkedList2.getHead());
        singgleLinkedList2.list();
		/*
		 * // 加入按照编号的顺序 singgleLinkedList.addByOrder(hero1);
		 * singgleLinkedList.addByOrder(hero4); singgleLinkedList.addByOrder(hero3);
		 * singgleLinkedList.addByOrder(hero2);
		 * 
		 * singgleLinkedList.list();
		 * 
		 * // 测试修改节点的代码 HeroNode newHeroNode = new HeroNode(2, "小卢", "玉麒麟~~~");
		 * singgleLinkedList.update(newHeroNode);
		 * 
		 * System.out.println("修改后的链表情况~~");
		 * 
		 * // 显示列表 singgleLinkedList.list();
		 * 
		 * //测试求单链表有效节点的个数 System.out.println("有效的节点个数为：" +
		 * getLength(singgleLinkedList.getHead()));
		 * 
		 * //测试看看是否得到倒数第K个节点 HeroNode res =
		 * findLastindexNode(singgleLinkedList.getHead(), -1); System.out.println("res="
		 * + res);
		 * 
		 * 
		 * // // 删除一个节点 // singgleLinkedList.del(1); // singgleLinkedList.del(4); //
		 * singgleLinkedList.del(2); // singgleLinkedList.del(3); // // // 显示列表 //
		 * System.out.println("删除后的链表情况~~"); // singgleLinkedList.list();
		 */

	}

	// 使用方式2：使用栈这个数据结构，将各个节点压入到栈中，然后利用栈的先进后出的特点，就实现了逆序打印
	public static void reversePrint(HeroNode head) {
		if (head.next == null) {
			return;// 空链表不打印
		}
		// 创建一个栈，将各个节点压入栈
		Stack<HeroNode> stack = new Stack<HeroNode>();
		HeroNode cur = head.next;
		// 将链表的所有节点压入栈
		while (cur != null) {
			stack.push(cur);
			cur = cur.next;
		}
		// 将栈中的节点进行打印
		while (stack.size() > 0) {
			System.out.println(stack.pop());// stack的特点：先进后出
		}
	}

	// 合并两个单链表，合并之后按照编号顺序排列由小到大排列(未完成)
	public static HeroNode merge(HeroNode head1, HeroNode head2) {
		if (head1.next == null && head2.next == null) {
			return null;
		}
		HeroNode cur1 = head1.next;
		HeroNode cur2 = head2.next;
		HeroNode list = new HeroNode(0, "", "");
		if (head1.next == null) {
			return head2;
		}
		if (head2.next == null) {
			return head1;
		}

		if (cur1.no < cur2.no) {
			list = cur1;
			cur1 = cur1.next;
			list.next = merge(cur1, cur2);
		} else {
			list = cur2;
			cur2 = cur2.next;
			list.next = merge(cur1, cur2);
		}
		return list;
	}

	//判断链表是否存在环(set add方法：添加不了就返回false)
	public static boolean hasCycle(HeroNode head){
		Set<HeroNode> set = new HashSet<>();
		while(head != null){
			if(!set.add(head)){
				return true;
			}
			head = head.next;
		}
		return false;
	}

	//双指针:快指针走两步，满指针走一步，重合即有环
	public static boolean hasCycle2(HeroNode head){
		if(head == null || head.next == null){
			return false;
		}
		HeroNode slow = head;
		HeroNode quick = head.next;
		while (slow != quick){
			if (quick == null || quick.next == null){
				return false;
			}
				slow = slow.next;
				quick = quick.next.next;
		}
		return true;
	}


	// 将单链表反转
	public static void reversetList(HeroNode head) {
		// 如果当前链表为空。或只有一个节点，则无需反转，直接返回
		if (head.next == null || head.next.next == null) {
			return;
		}
		// 定义一个辅助指针（变量），帮助我们遍历原来的链表
		HeroNode cur = head.next;
		HeroNode next = null;// 用来指向当前节点【cur】的下一个节点
		HeroNode reverseHead = new HeroNode(0, "", "");
		// 遍历原来的链表，每遍历一个节点，就将其去除，并放在新的链表reverseHead的最前端
		while (cur != null) {
			next = cur.next;// 先暂时保存当前节点的下一个节点，因为后面需要使用
			cur.next = reverseHead.next;// 将cur的下一个节点指向新的链表的最前端、
			reverseHead.next = cur;// 把cur连接到新的链表上
			cur = next;// 让cur后移
		}
		// 将head.next指向reverseHead,如此就实现了单链表的反转
		head.next = reverseHead.next;
	}

	// 查找单链表中倒数第K个节点【新浪面试题】
	// 思路如下：
	// 1、编写一个方法，接收head节点，同时接收一个index
	// index表示倒数index个节点
	// 3、先把链表从头到尾遍历，得到链表总的长度
	// 4、得到size后我们从链表第一个开始遍历（size-index），就可以得到
	public static HeroNode findLastindexNode(HeroNode head, int index) {
		// 判断列表是否为空
		if (head.next == null) {
			return null;// 没有找到
		}
		// 第一次遍历得到链表的长度（节点个数）
		int size = getLength(head);
		// 第二次遍历 size-index 位置，就是我们倒数的第K个节点
		// 先做一个数据的校验
		if (index <= 0 || index > size) {
			return null;
		}
		// 定义给辅助变量，for 循环到倒数的index
		HeroNode cur = head.next;
		for (int i = 0; i < size - index; i++) {
			cur = cur.next;
		}
		return cur;
	}

	// 方法：获得单链表的节点的个数（如果是带头节点的不需要统计头节点）
	// head 链表的头节点，返回的就是有效节点的个数
	public static int getLength(HeroNode head) {
		if (head.next == null) {
			return 0;
		}
		int length = 0;
		// 定义辅助变量
		HeroNode cur = head.next;
		while (cur != null) {
			length++;
			cur = cur.next;// 遍历
		}
		return length;
	}
}

//定义SinggleLinkedList来管理我们的英雄
class SinggleLinkedList {
	// 先初始化一个头节点，头节点不要动
	private HeroNode head = new HeroNode(0, "", "");

	// 添加节点到单项链表
	// 当不考虑编号顺序时
	// 1、找到当前列表的最后节点
	// 2、将最后这个节点的next指向新的节点

	// 返回头节点
	public HeroNode getHead() {
		return head;
	}

	public void setHead(HeroNode head) {
		this.head = head;
	}

	public void add(HeroNode heroNode) {

		// 因为head节点不能动，所以借助一个辅助遍历temp
		HeroNode temp = head;
		// 遍历列表，找到最后
		while (true) {
			if (temp.next == null) {
				break;
			}
			// 如果没有找到最后,就将temp后移
			temp = temp.next;
		}
		// 当退出这个while循环时，意为temp就指向了链表的最后
		// 就像最后这个节点的next指向新的节点
		temp.next = heroNode;
	}

	// 第二种添加英雄的方式，根据排名将英雄插入到指定位置
	// 如果有这个排名，则显示添加失败，并给出显示
	public void addByOrder(HeroNode heroNode) {
		// 因为头节点不能动，因此我们仍然通过一个辅助指针（变量）来帮助找到添加的位置
		// 因为是单链表，因为我们找的temp是位于添加位置的前一个节点，否则插入不了
		HeroNode temp = head;
		boolean flag = false;// flag标志添加的编号是否存在，默认为false
		while (true) {
			if (temp.next == null) {// 说明temp已经在链表最后了
				break;//
			}
			if (temp.next.no > heroNode.no) {// 位置找到了，就在temp后面插入
				break;
			} else if (temp.next.no == heroNode.no) {// 说明希望添加的heroNode的编号已经存在
				flag = true;
				break;
			}
			temp = temp.next;// 后移，遍历当前链表
		}
		// 判断flag的值
		if (flag) {// 不能添加，说明编号存在
			System.out.printf("准备插入的英雄编号%d已经存在了，不能加入\n", heroNode.no);
		} else {
			// 插入到链表中，temp的后面
			heroNode.next = temp.next;
			temp.next = heroNode;
		}

	}

	// 修改节点信息，根据no编号来修改，即no编号不能改
	public void update(HeroNode newHeroNode) {
		// 判断是否为空
		if (head.next == null) {
			System.out.println("链表为空！");
			return;
		}
		// 找到需要需要修改的节点，根据弄编号
		// 定义一个辅助变量
		HeroNode temp = head.next;
		boolean flag = false;// 表示是否找到了该节点
		while (true) {
			if (temp == null) {
				break;// 已经遍历完链表
			}
			if (temp.no == newHeroNode.no) {
				// 找到
				flag = true;
				break;
			}
			temp = temp.next;
		}
		// 根据flag判断是否找到要修改的节点
		if (flag == true) {
			temp.name = newHeroNode.name;
			temp.nickname = newHeroNode.nickname;
		} else {// 没有找到
			System.out.printf("没有找到编号为 %d 的节点，不能修改\n", newHeroNode.no);

		}

	}

	// 删除节点
	// 思路
	// 1、head节点不能动，因此我们需要一个temp辅助接点找到待删除节点的前一个节点
	// 2、说明我们在比较时，是temp.next和需要删除的节点的no比较
	public void del(int no) {
		HeroNode temp = head;
		boolean flag = false;
		while (true) {
			if (temp.next == null) {
				System.out.println("已经到了链表最后了");
				break;
			}
			if (temp.next.no == no) {
				// 找到的待删除节点的前一个节点temp
				flag = true;
				break;
			}
			temp = temp.next;// temp后移，遍历
		}

		// 判断flag
		if (flag) {// 找到则删除
			temp.next = temp.next.next;
		} else {
			System.out.printf("要删除的 %d 节点不存在\n", no);
		}

	}

	// 显示列表[遍历]
	public void list() {
		// 判断链表是否为空
		if (head.next == null) {
			System.out.println("链表为空");
			return;
		}
		// 因为头节点不能动，需要一个辅助变量遍历
		HeroNode temp = head.next;
		while (true) {
			if (temp.next == null) {
				break;
			}
			// 输出节点信息
			System.out.println(temp);// HeroNode里面已经重写了tostring方法，循环输出除最后一个的所有英雄
			// 如果没有找到最后,就将temp后移
			// temp后移
			temp = temp.next;
		}
		System.out.println(temp);// 输出最后一个英雄
	}
}

//定义HeroNode,每个Hero对象就是一个节点
class HeroNode {
	public int no;
	public String name;
	public String nickname;
	public HeroNode next;// 指向下一个节点

	// 构造器
	public HeroNode(int no, String name, String nickname) {
		this.no = no;
		this.name = name;
		this.nickname = nickname;
	}
	// 为了显示方便，重写toString方法

	@Override
	public String toString() {
		return "HeroNode [no=" + no + ", name=" + name + ", nickname=" + nickname + "]";
	}
}
