package Recursion;

public class recursion {
//递归
	public static void main(String[] args) {
		test(9);

	}
	public static void test(int n) {
		if(n > 2) {
			test(n - 1);
		}
		System.out.println("n=" + n);
	}

}
