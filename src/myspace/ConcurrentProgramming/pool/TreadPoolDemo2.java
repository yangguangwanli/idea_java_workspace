package myspace.ConcurrentProgramming.pool;

import java.util.concurrent.*;

/**
 * @Auther: Renjie
 * @Date: 2021/10/10 - 18:23
 * @Description: {PACKAGE_NAME}
 * @Version: 1.0
 */

//自定义线程池
public class TreadPoolDemo2 {
    public static void main(String[] args) {
        ExecutorService threadpool = new ThreadPoolExecutor(
                2,//常驻线程数量
                5,//最大线程数量
                2L,//存活时间
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(3),//阻塞队列
                Executors.defaultThreadFactory(),//线程工厂
                new ThreadPoolExecutor.AbortPolicy()//拒绝策略
        );
        try {
            //10个顾客(线程)请求
            for (int i = 1; i <= 20; i++) {
                //执行
                threadpool.execute(() -> {
                    System.out.println(Thread.currentThread().getName() + " 办理业务");
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //关闭线程
            threadpool.shutdownNow();
        }

    }
}
