package myspace.ConcurrentProgramming.juc;

import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * @Auther: Renjie
 * @Date: 2021/10/10 - 0:03
 * @Description: {PACKAGE_NAME}
 * @Version: 1.0
 */

//6辆汽车，停3个停车位
public class SemaphoreDemo {
    public static void main(String[] args) {
        //创建Semaphore，设置许可数量
        Semaphore semaphore = new Semaphore(3);
        
        //模拟6辆汽车
        for (int i = 1; i <= 6; i++) {
            new Thread(()->{
                try {
                    //抢占，获取许可满了后其他线程就阻塞状态
                    semaphore.acquire();

                    System.out.println(Thread.currentThread().getName() + " 抢到了车位");

                    //设置随机停车时间
                    TimeUnit.SECONDS.sleep(new Random().nextInt(5));//生成5以内的一个随机整数

                    System.out.println(Thread.currentThread().getName() + " ----------离开了车位");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally{
                    //释放，最后释放这个许可，给其他线程使用；等待的线程开启争夺
                    semaphore.release();
                }
            },String.valueOf(i)).start();
        }
   
    }
}
