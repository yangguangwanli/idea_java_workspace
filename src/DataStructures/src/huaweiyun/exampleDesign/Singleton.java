package huaweiyun.exampleDesign;

public class Singleton {//单例模式的设计
//		1、单例类只能有一个实例
//		2、单例类必须自己创造自己的唯一实例
//		3、单例类必须给其他对象提供这一实例
	
	
	private static Singleton singleton;//确保整个类只有一份
	
	private Singleton() {};//将构造私有化，这样久不能在外部通过new+构造方法再来创造Singleton对象了
		
	public static synchronized Singleton getInstance() {//synchronized确保线程安全
		if(singleton == null){
			singleton = new Singleton();
		}
		return singleton;
	}
		
		
	

}
