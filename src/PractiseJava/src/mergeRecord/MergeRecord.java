package mergeRecord;

import java.util.*;

public class MergeRecord {

	/**
	 * 数据表记录包含表索引和数值（int范围的正整数），请对表索引相同的记录进行合并
	 * 即将相同索引的数值进行求和运算，输出按照key值升序进行输出。
	 *
	 * 输入描述： 先输入键值对的个数 然后输入成对的index和value值，以空格隔开
	 *
	 * 输出描述： 输出合并后的键值对（多行）
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		//接收数据个数
		int num = Integer.parseInt(scanner.nextLine());
		//初始化，用treeMap保存
		Map<Integer, Integer> tree = new TreeMap<>();
		while (num > 0) {
			//扫描每行数据，并用" "为界分隔开
			String kv = scanner.nextLine();
			String[] s = kv.split(" ");
			//如果传入的数据小于两个，没输入value或者没有输入了，就继续循环
			if (s.length != 2) {
				continue;
			}
			//如果tree的key集合中有元素重复，则put这个key的value合并
			if (tree.containsKey(Integer.parseInt(s[0]))) {
				tree.put(Integer.parseInt(s[0]), tree.get(Integer.parseInt(s[0])) + Integer.parseInt(s[1]));
			} else {
				//key值没有重复，则直接把新的key-value，put进去
				tree.put(Integer.parseInt(s[0]), Integer.parseInt(s[1]));
			}
			//数量--
			num--;
		}
		//遍历key值的集合，打印key value
		for (Integer i : tree.keySet()) {
			System.out.println(i + " " + tree.get(i));
		}
	}
}

//简单的偏方，值得学习！
//public static void main(String[] args){
//    Scanner sc = new Scanner(System.in);
//    
//    long row = sc.nextInt();
//    int[] result = new int[row];
//    for(int i=0;i<row;i++){
//        int index = sc.nextInt();
//        int value = sc.nextInt();
//        //循环接收数据，合并同类型key数据的值
//        result[index] = result[index]+value;
//    }
//    for(int i = 0;i < row; i++){
//        if(result[i] != 0){
//            System.out.println( i + " " + result[i]);
//        }
//    }
//}
//}