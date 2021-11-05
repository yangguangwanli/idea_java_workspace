

public class Count3Quit2 {

	public static void main(String[] args) {
		KidCircle kc = new KidCircle(500);//500个小孩拉成圈
		int countNum = 0;//计数器，0、1、2、3 -> 0、1、2、3  ..这样
		Kid k = kc.first;
		while(kc.count > 1) {
			countNum ++;
			if(countNum == 3) {
				countNum = 0;
				kc.delete(k);
			}
			k = k.right;
		}
		System.out.println(kc.first.id);
	}
}

class Kid {
	int id;
	Kid left;
	Kid right;
}

class KidCircle {
	int count = 0;
	Kid first, last;

	KidCircle(int n) {//用n个小孩拉成个圈儿
		for (int i = 0; i < n; i++) {
			add();
		}
	}

	void add() {
		Kid k = new Kid();//新添加的小孩为k，加在结尾后面
		k.id = count;
		if (count <= 0) {
//只有自己一个小孩，四个变量均赋值给自己，左手、右手、开头、结尾四个（小孩）变量
			first = k;
			last = k;
			k.left = k;
			k.right = k;
		} else {
//已经有了小孩了
			last.right = k;
			k.left = last;
			k.right = first;
			first.left = k;
			last = k;
		}
	count ++;

	}
//实际在实现双向回环链表
	void delete(Kid k) {
		if (count <= 0) {//没有小孩了
			System.out.print("NO KIDS");
			return;
		} else if (count == 1) {//只有一个小孩，直接删
			first = last = null;
		} else {//k左边小孩的右手拉住了k的右手，k右边小孩的左手拉住了k的左手
			k.left.right = k.right;
			k.right.left = k.left;
//自动释放k的存储空间
			if (k == first) {
				first = k.right;
			} else if (k == last) {
				last = k.left;
			}
		}
		count--;
	}
}