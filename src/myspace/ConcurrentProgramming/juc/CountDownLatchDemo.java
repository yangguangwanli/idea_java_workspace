package myspace.ConcurrentProgramming.juc;

import java.util.concurrent.CountDownLatch;

/**
 * @Auther: Renjie
 * @Date: 2021/10/9 - 23:36
 * @Description: {PACKAGE_NAME}
 * @Version: 1.0
 */
public class CountDownLatchDemo {
    //6个同学陆续离开教室之后，班长锁门
    public static void main(String[] args) throws InterruptedException {

        //创建CountDownLatch对象，设置初始值
        CountDownLatch countDownLatch = new CountDownLatch(6);
        //6个同学陆续离开教室之后
        for (int i = 0; i < 6; i++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + " 号同学离开了教室");
               //计数 -1
                countDownLatch.countDown();
            }, String.valueOf(i)).start();
        }

        //等待，计数器没有变为0，就一直await()等待，堵塞主线程main线程不往下执行
        countDownLatch.await();
        System.out.println(Thread.currentThread().getName() + " 班长锁门走人了");
    }
}
