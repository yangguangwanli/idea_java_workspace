package Sort;
//有问题
public class Enum {
	public enum Mycolor {
		red, green, white, yellow
	}

	public static void main(String[] args) {
		Mycolor m = Mycolor.yellow;
		switch (m) {
		case red: 
			System.out.println("这是红色");
			break;
		
		case green: 
			System.out.println("这是绿色");
			break;
		
		case white: 
			System.out.println("这是白色");
			break;
		
		case yellow: 
			System.out.println("这是红色");
			break;
		
		default:
			System.out.println("这是其他颜色");
		}
		System.out.println(m);

	}

}
