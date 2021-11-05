package Sort;

public class selectionSort {
//给输入的参数进行由大到小的整数排序
	public static void main(String[] args){
		int a[] = new int [args.length];
		for(int i=0; i<a.length; i++) {
			a[i] = Integer.parseInt(args[i]);
		}
		selecSort(a);
		print(a);
	}
	
////这是选择排序算法的实现
//	private static void selecSort(int a[]) {
//		for(int i=0; i<a.length; i++) {
//			for(int j=i+1; j<a.length; j++) {
//			if(a[j] < a[i]) {
//				int tmp;
//				tmp = a[i];
//				a[i] = a[j];
//				a[j] = tmp;
//				}
//			}		
//		}
//	}

	//这是优化后的选择算法的实现
		private static void selecSort(int a[]) {
			int k , tmp;
			for(int i=0; i<a.length; i++) {
			    k = i;
				for(int j=k+1; j<a.length; j++) {
					if(a[j] < a[k]) {
					k = j;//如果后面小，直接做交换，选出后面最小的数
				}	 	//k的意义为：记录后面最小数的位置
			}
				if(k != i) {//只把后面最小的数与被比较的数做一次交换
			        tmp =a[i];
					a[i] = a[k];
					a[k] = tmp;
				}
		}
	}
	
	
	public static void print(int a[]) {
		for(int i=0; i<a.length; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println();
	}
}
