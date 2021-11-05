package Exam;

import java.util.*;

public class TenSort {
//  十进制的最低位进行比较
//  正数直接排序,负数需要取绝对值然后进行排序
//  输出排序后的数组,以','隔开;
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while (in.hasNextLine()) {
			String[] strs = in.nextLine().split(",");
			
			//把字符串以整型的形式循环存入List中
			List<Integer> list = new ArrayList<Integer>();
	        for (String num :strs) {
	            list.add(Integer.parseInt(num));
	        }

			// List可以重写排序的比较方法
			list.sort(new Comparator<Integer>() {
				@Override
				public int compare(Integer n1, Integer n2) {
					return truevalue(n1) - truevalue(n2);
				}

				private int truevalue(Integer n) {
					n = Math.abs(n);
					n = n % 10;
					return n;
				}

			});
			String s = list.toString();
			String res = s.substring(1, s.length() - 1).replaceAll(" ", "");
	        System.out.println(res);
		}
	}
}

//	public static void main(String[] args) {
//		Scanner in = new Scanner(System.in);
//        String[] nums = in.nextLine().split(",");
//        in.close();
//
//        ArrayList<Integer> list = new ArrayList<>();
//        for (String num : nums) {
//            list.add(Integer.parseInt(num));
//        }
//        list.sort(new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                return getKey(o1) - getKey(o2);
//            }
//
//            public Integer getKey(int i) {
//                i = i > 0 ? i : -i;
//                return i % 10;
//            }
//        });
//
//        String listStr = list.toString();
//        String res = listStr.substring(1, listStr.length() - 1)
//                .replaceAll(" ", "");
//
//        System.out.println(res);
//    }
//}