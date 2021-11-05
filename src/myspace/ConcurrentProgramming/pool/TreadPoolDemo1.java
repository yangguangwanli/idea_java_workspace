package myspace.ConcurrentProgramming.pool;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Auther: Renjie
 * @Date: 2021/10/10 - 17:29
 * @Description: {PACKAGE_NAME}
 * @Version: 1.0
 */
//演示线程池三种常见分类
public class TreadPoolDemo1 {
    public static void main(String[] args) {
        //一池五线程
        //5个窗口
        ExecutorService threadPool1 = Executors.newFixedThreadPool(5);

        //一池一线程
        ExecutorService threadPool2 = Executors.newSingleThreadExecutor();

        //一池可扩容线程
        ExecutorService threadPool3 = Executors.newCachedThreadPool();

        try {
            //10个顾客(线程)请求
            for (int i = 1; i <= 20; i++) {
                //执行
                threadPool1.execute(()->{
                    System.out.println(Thread.currentThread().getName() + " 办理业务");
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //关闭线程
            threadPool1.shutdownNow();
        }

    }
}
