package JVMnote;


public class test {

	public static void main(String[] args) {
		//返回虚拟机试题使用的最大内存
		long max = Runtime.getRuntime().maxMemory();//1024 * 1024
		//返回JVM的初始化总内存
		long total = Runtime.getRuntime().totalMemory();
		
		System.out.println("max=" + max + "字节\t" + (max/(double)1024/1024) + 	"MB");
		System.out.println("total=" + max + "字节\t" + (total/(double)1024/1024) + 	"MB");
	
		
		//默认情况下：分配的总内存总是电脑内存的1/4，而初始化的内存：1/64
	}
//OOM：
	//1、尝试扩大内存看结果
	//2、分析内存，看一下哪个地方出现了问题（专业工具）
	
	//-Xmx1024m -Xmx1024m -XX:+PrintGCDetails
	
	
}
