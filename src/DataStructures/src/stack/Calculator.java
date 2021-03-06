package stack;

public class Calculator {

	public static void main(String[] args) {
		// 完成表达式运算
		String expression = "700+2*6-2";
		ArrayStack2 numStack = new ArrayStack2(10);
		ArrayStack2 operStack = new ArrayStack2(10);
		// 定义需要的相关变量
		int index = 0;// 用于扫描
		int num1;
		int num2;
		int oper;
		int res;
		char ch = ' ';// 将每次扫描得到的char保存到ch中
		// 开始while循环的扫描expression
		String keepNum = "";// 用于拼接多位数
		while (true) {
			// 依次得到expression的每一个字符
			ch = expression.substring(index, index + 1).charAt(0);
			// 判断ch是什么，然后做相应的处理
			if (operStack.isOper(ch)) {// 如果是运算符
				// 判断当前的符号栈是否为空
				if (!operStack.isEmpty()) {
					// 如果符号栈有操作符，就进行比较，如果当前的操作符的优先级或者等于栈中的操作符
					// 就从数栈中pop两个数，在符号栈中怕pop出一个符号，进行运算，得到结果入数栈，然后让当前的操作符入符号栈
					if (operStack.priorty(ch) <= operStack.priorty(operStack.peek())) {
						num1 = numStack.pop();
						num2 = numStack.pop();
						oper = operStack.pop();
						res = numStack.cal(num1, num2, oper);
						// 把运算结果入数栈
						numStack.push(res);
						// 把当前的操作符压入符号栈
						operStack.push(ch);
					} else {
						// 如果当前的操作符的优先级大于栈中的操作符，就直接入符号栈
						operStack.push(ch);
					}
				} else {
					// 如果为空直接入符号栈
					operStack.push(ch);// 1 + 3
				}
			} else {// 如果是数字，则直接入数栈
				// numStack.push(ch - 48);// ASIC码中存的实际是从48（代表字符0）开始存的
				// 分析思路
				// 1、当处理多位数时，不能发现是一个属就立即入栈，因为可能是多位数
				// 2、在处理数，需要向expression的表达式的index后再看一位，如果是数就继续扫描，如果是运算符就入栈
				// 3、因此我们需要定义一个变量字符串，用于拼接

				// 处理多位数，先拼接
				keepNum += ch;

				// 如果ch已经是expression的最后一位，就直接入栈
				if (index == expression.length() - 1) {
					numStack.push(Integer.parseInt(keepNum));
				} else {

					// 判断下一个字符是不是数字，如果是数字，就继续扫描，如果是运算符，则入栈
					// 注意这里是看后一位，不是index++
					// subSequence(index+1, index+2).charAt(0) 意思为：找到index的下一位

					if (operStack.isOper(expression.subSequence(index + 1, index + 2).charAt(0))) {
						// 如果后意为是运算符，则入栈keepNum = ""
						numStack.push(Integer.parseInt(keepNum));
						// 重要，注意清空keepNum
						keepNum = "";
					}
				}

			}
			// 让index + 1，并判断是否扫描到expression 的最后，
			index++;
			if (index >= expression.length()) {
				break;
			}
		}
		// 当表达式扫描完毕，就顺序的从数栈和符号栈中pop出相应的数和符号，并运行
		while (true) {
			// 如果符号栈为空，则计算到最后的结果，数栈中只有一个数字【结果】
			if (operStack.isEmpty()) {
				break;
			}
			num1 = numStack.pop();
			num2 = numStack.pop();
			oper = operStack.pop();
			res = numStack.cal(num1, num2, oper);
			// 把运算结果入数栈
			numStack.push(res);
		}
		// 将数栈最后的数pop出来，就是结果
		int res2 = numStack.pop();
		System.out.printf("表达式 %s = %d", expression, res2);
	}
}

//先创建一个栈，直接copy
//定义ArrayStack2定义栈，需要扩展功能
class ArrayStack2 {
	private int maxSize;// 栈的大小
	private int[] stack;// 数组模拟栈
	private int top = -1;// top表示数组，初始化为-1

	// 构造器
	public ArrayStack2(int maxSize) {
		this.maxSize = maxSize;
		stack = new int[this.maxSize];
	}

	// 增加一个方法，可以返回当前栈顶的数据，但是不是真的pop
	public int peek() {
		return stack[top];
	}

	// 栈满
	public boolean isFull() {
		return top == maxSize - 1;// 如果top == maxSize -1 true返回true，否则均为false

	}

	// 栈空
	public boolean isEmpty() {
		return top == -1;
	}

	// 入栈-push
	public void push(int value) {
		// 先判断栈是否满
		if (isFull()) {
			System.out.println("栈满");
			return;
		}
		top++;
		stack[top] = value;
	}

	// 出栈-pop，将栈顶的数据返回
	public int pop() {
		// 先判断栈是否为空
		if (isEmpty()) {
			// 抛出异常
			throw new RuntimeException("栈空,没有数据");
		}
		int value = stack[top];
		top--;
		return value;
	}

	// 显示栈的情况[遍历栈],遍历时，需要从栈顶开始显示数据
	public void list() {
		if (isEmpty()) {
			System.out.println("栈空，没有数据");
			return;
		}
		// 从栈顶开始取数据
		for (int i = top; i >= 0; i--) {
			System.out.printf("stack[%d]=%d\n", i, stack[i]);
		}
	}

	// 返回运算符的优先级，优先级由程序员来确定，优先级由数字表示
	// 数字越大，则优先级就越高
	public int priorty(int oper) {
		if (oper == '*' || oper == '/') {
			return 1;
		} else if (oper == '+' || oper == '-') {
			return 0;
		} else {
			return -1;// 假定目前的表达式只有加减乘除这四种优先级
		}
	}

	// 判断是不是一个运算符
	public boolean isOper(char val) {
		return val == '+' || val == '-' || val == '*' || val == '/';
	}

	// 计算方法
	public int cal(int num1, int num2, int oper) {
		int res = 0;// res用于存放计算的结果
		switch (oper) {
		case '+':
			res = num1 + num2;
			break;
		case '-':
			res = num2 - num1;// 注意顺序
			break;
		case '*':
			res = num1 * num2;
			break;
		case '/':
			res = num2 / num1;
			break;
		default:
			break;
		}
		return res;
	}
}