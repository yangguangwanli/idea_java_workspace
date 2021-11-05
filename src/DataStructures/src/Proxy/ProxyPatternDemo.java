package Proxy;

public class ProxyPatternDemo {

	public static void main(String[] args) {
		Image image = new ProxyImage("uml_proxy.jpg");//创建代理对象
		
		//第一次调用：图片先从磁盘中加载
		image.display();
		System.out.println("---------------------------");
		//第二次加载：图片无需从磁盘加载
		image.display();
		
		
		System.out.println("---------------------------");
		image.display();
		System.out.println("---------------------------");
		image.display();
		System.out.println("---------------------------");
		image.display();
		System.out.println("---------------------------");
		image.display();
	
	}

}
