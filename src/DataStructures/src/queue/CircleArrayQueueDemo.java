package queue;

import java.util.Scanner;

public class CircleArrayQueueDemo {

	public static void main(String[] args) {
		// 测试一把
		// 创建一个队列
		CircleArrayQueue queue = new CircleArrayQueue(4);
		char key = ' '; // 接收用户输入
		Scanner sc = new Scanner(System.in);
		boolean loop = true;
		// 输出一个菜单
		while (loop) {
			System.out.println("s(show): 显示队列");
			System.out.println("e(exit): 退出程序");
			System.out.println("a(add): 添加数据到队列");
			System.out.println("g(get): 从队列取出数据");
			System.out.println("h(head): 查看队列头的数据列");
			key = sc.next().charAt(0);// 接收一个字符
			switch (key) {
			case 's': {
				queue.showQueue();
				break;
			}
			case 'e': {// 退出
				sc.close();
				loop = false;
				break;
			}
			case 'a': {
				System.out.println("输入一个数字:");
				int value = sc.nextInt();
				queue.addQueue(value);
				break;
			}
			case 'g': {
				try {
					int res = queue.getQueue();
					System.out.printf("取出的数据是%d\n", res);
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println(e.getMessage());// 就是getQueue写的异常信息
				}
				;
				break;
			}
			case 'h': {// 查看队列头的数据
				try {
					int res = queue.headQueue();
					System.out.printf("取出的数据是%d\n", res);
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println(e.getMessage());// 就是getQueue写的异常信息
				}
				;
				break;
			}
			default:
				throw new IllegalArgumentException("Unexpected value: " + key);
			}
		}
		System.out.println("程序退出");

	}

}

class CircleArrayQueue{
	private int maxSize;// 表示数组的最大容量
	private int front;
	//front 变量的含义做一个调整： front 就指向队列的第一个元素, 也就是说 arr[front] 就是队列的第一个元素
	//front 的初始值 = 0
	private int rear;
	//rear 变量的含义做一个调整：rear 指向队列的最后一个元素的后一个位置. 因为希望空出一个空间做为约定.
	//rear 初始值为0
	private int[] arr;// 该数据用于存放数据，模拟队列
	
	public CircleArrayQueue(int arrMaxSize) {
		maxSize = arrMaxSize;
		arr = new int[maxSize];
	}
	
		// 判断队列是否满
		public boolean isFull() {
			return (rear + 1) % maxSize == front;
		}
		
		// 判断队列是否为空
		public boolean isEmpty() {
			return rear == front;
		}
		
		// 添加数据到队列
		public void addQueue(int n) {
			// 判断队列是否满
			if (isFull()) {
				System.out.println("队列满，不能加入数据");
				return;
			}
			arr[rear] = n;
			rear = (rear + 1) % maxSize;
		}
		
		// 获取队列的数据，出队列
		public int getQueue() {
			// 判断队列是否空
			if (isEmpty()) {
				// 通过抛出异常处理
				throw new RuntimeException("队列空，不能取出数据");
			}
			// 这里需要分析出 front 是指向队列的第一个元素
			// 1. 先把 front 对应的值保留到一个临时变量
			// 2. 将 front 后移, 考虑取模
			// 3. 将临时保存的变量返回
			int value = arr[front];
			front = (front + 1) % maxSize;
			return value;
		}
		
		// 显示队列的所有数据
		public void showQueue() {
			// 遍历
			if (isEmpty()) {
				System.out.println("队列为空，没有数据");
			}
			// 思路：从 front 开始遍历，遍历多少个元素
			// 动脑
			for (int i = front; i < front + size(); i++) {
				System.out.printf("arr[%d]=[%d]\n", i % maxSize, arr[i % maxSize]);
			}
		}
		
		// 求出当前队列有效数据的个数
		public int size() {
		// rear = 2
		// front = 1
		// maxSize = 3
		return (rear + maxSize - front) % maxSize;
		}
		
		// 显示队列的头数据，注意不是取数据
		public int headQueue() {
			// 判断
			if (isEmpty()) {
				// 通过抛出异常处理
				throw new RuntimeException("队列空，不能取出数据");
			}
			return arr[front];
		}
		
		
	}