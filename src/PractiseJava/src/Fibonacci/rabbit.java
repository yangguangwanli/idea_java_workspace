package Fibonacci;
//描述

//有一只兔子，从出生后第3个月起每个月都生一只兔子，小兔子长到第三个月后每个月又生一只兔子，
//假如兔子都不死，问每个月的兔子总数为多少？
//
//本题有多组数据
//
//输入描述：
//输入int型表示month
//
//输出描述：
//输出兔子总数int型
//
//输入：
//9
//输出：
//34

import java.util.Scanner;

public class rabbit {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int a = in.nextInt();
            if (a == 1 || a == 2) {
                System.out.println(1);
                continue;
            }

            System.out.println(sumRabbits(a));
            System.out.println(calculate2(a));
            System.out.println(iterate2(a));
        }
    }

    private static int sumRabbits(int month) {
        if (month <= 2) return 1;
        return sumRabbits(month - 1) + sumRabbits(month - 2);
    }

    //去重递归
    public static int calculate2(int num) {
        int[] arr = new int[num + 1];
        return recurse(arr, num );
    }

    private static int recurse(int[] arr, int num) {
        if (num == 0) {
            return 0;
        }
        if (num == 1) {
            return 1;
        }
        //存储上一次计算过的那个数，如果有就直接返回
        if (arr[num] != 0) {
            return arr[num];
        }
        arr[num] = recurse(arr, num - 1) + recurse(arr, num - 2);
        return arr[num];
    }

    //双指针迭代
    public static int iterate2(int num) {
        if (num == 0) {
            return 0;
        }
        if (num == 1) {
            return 1;
        }
        int low = 0, high = 1;
        for (int i = 2; i <= num; i++) {
            int sum = low + high;
            low = high;
            high = sum;
        }
        return high;

    }
}

