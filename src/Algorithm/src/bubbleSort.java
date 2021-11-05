


//冒泡排序法
public class bubbleSort {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		Date[] days = new Date[5];
		days[0] = new Date(2006, 5, 4);
		days[1] = new Date(2006, 7, 4);
		days[2] = new Date(2008, 5, 4);
		days[3] = new Date(2004, 5, 9);
		days[4] = new Date(2004, 5, 4);
		
		bubbleSort(days);
		
		for (int i=0; i<days.length; i++) {
			System.out.println(days[i]);
		}
	}
	//冒泡排序法
	public static Date[] bubbleSort(Date[] a) {
		int len = a.length;
		for(int i = len-1;i>=1;i--) {
			for(int j = 0;j<=i-1;j++) {
				if(a[j].compare(a[j+1]) > 0) {
					Date temp = a[j];
					a[j] = a[j+1];
					a[j+1] = temp;
				}
			}
		}
		return a;
	}
}

class Date{
	int year, month, day;
	Date(int y,int m,int d){
		year = y; month = m ;day = d;
	}
	
	//比较日期的前后，日期大的返回1；日期小的返回-1
	public int compare(Date date) {
		return year > date.year ? 1
				: year < date.year ? -1
				: month > date.month ? 1
				: month < date.month ? -1
				: day > date.day ? 1
				: day < date.day ? -1 : 0;
	}



public String toString() {
	return "Year:Month:Day -- " + year + "-" + month + "-" + day;
}
}