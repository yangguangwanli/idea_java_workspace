package Sort;


public class Arraypase {
//  1,2;3,4,5;6,7,8    
//  这行字符串进行先以；分割，再以，分隔，打印出
//	1.0 2.0 
//	3.0 4.0 5.0 
//	6.0 7.0 8.0
//  这样
	public static void main(String[] args) {
		double [][] d;//定义二维数组，根据题目要求发现是double类型
		String s = "1,2;3,4,5;6,7,8";//传入字符串
		String[] sFirst = s.split(";");//先分隔，传入字符串数组
		d = new double[sFirst.length][];//初始化一维的长度
		
		for (int i = 0; i < sFirst.length; i++) {
			//每一个一维的数组里用，分隔符分隔，传入字符串数组
			String [] sSecand = sFirst[i].split(",");
			//一维数组的每个数据初始化二维数组的长度
			d[i] =new double[sSecand.length];
			//循环放置数据
			//每个分隔后的字符串数据强制转化为double类型，并导入
			for(int j = 0; j < sSecand.length; j++) {
				d[i][j] = Double.parseDouble(sSecand[j]);
			}
		}
		//循环输出，注意格式
		for (int i = 0; i < d.length; i++) {
			for (int j = 0; j < d[i].length; j++) {
				System.out.print(d[i][j] + " ");
			}
			//每组一维数据另起一行
			System.out.println();
		}
	}
}
