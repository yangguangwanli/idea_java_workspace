package dynamicplan;

import java.util.List;

import java.util.Scanner;



public class ss {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
		int n = sc. nextInt();
		System.out.println(climbStairs(n));
		}

	}

//	class Solution {
	    public static int climbStairs(int n) {
	    	if (n <= 2 && n >= 0) {
				return n;
			}
	    	return climbStairs(n-1) + climbStairs(n-2);
	}
	    
	    
	    public static int climbStairs2(int n) {
	        if (n <= 2) {
	            return n;
	        }
	        int pre2 = 1, pre1 = 2;
	        for (int i = 2; i < n; i++) {
	            int cur = pre1 + pre2;
	            pre2 = pre1;
	            pre1 = cur;
	        }
	        return pre1;
	    }

}