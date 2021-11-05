

public class count3Quit1 {
//数三取一，定义500个数然后数三取一，求得剩下的最后一个数是第几个数？
	public static void main(String[] args) {
		//初始化500个人手拉手
		boolean[] arr = new boolean[500];
		for (int i=0; i<arr.length; i++) {
			arr[i] = true;
		}
		
		int leftCount = arr.length;//定义剩下的数
		int countNum = 0;//初始化定义一个计数器
		int index = 0;//位置
		
		while(leftCount > 1) {//剩下的人数大于就不断地数数
			if(arr[index] == true) {//说明还在圈里
				countNum ++;
				if(countNum == 3) {//每逢三归零重新数，一人退出置为false
					countNum = 0;
					arr[index] = false;
					leftCount --;
				}
			}
			index ++;//位置网上递增
			if(index == arr.length) {//数到500了归零
				index =0;
			}
		}
		for(int i=0; i<arr.length; i++) {//循环找到那个还是true的数字，打印它的位置
			if(arr[i] == true) {
				System.out.println(i);
			}
		}
	}
}
