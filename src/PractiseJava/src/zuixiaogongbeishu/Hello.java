package zuixiaogongbeishu;

import java.util.ArrayList;
//dump
// -Xms     设置初始化内存分配大小，默认本机内存64/1
// -Xmx     设置最大分配内存，默认本机内存1/4
// -XX:PrintGCDetails   //打印GC垃圾回收信息
// -XX:+HeapDumpOnOutOfMemoryError  //OOM DUMP
// Runtime类，查看官方API文档，用来调优的，就是java运行时的一些方法

// -Xms1m -Xmx8m -XX:+HeapDumpOnOutOfMemoryError
public class Hello {
    byte[] b = new byte[1024 * 1024];//1M
    public static void main(String[] args) {
        System.out.println("Hello world");
        ArrayList<Hello> list = new ArrayList<>();
        int count = 0;

        try{
            while (true){
                list.add(new Hello());
                count++;
            }
        }
        catch(Error e){
            System.out.println("count:" + count);
            e.printStackTrace();
        }
//throwable Exception Error
    }
}
