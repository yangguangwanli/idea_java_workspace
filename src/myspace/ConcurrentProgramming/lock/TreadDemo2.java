package myspace.ConcurrentProgramming.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Auther: Renjie
 * @Date: 2021/10/9 - 20:43
 * @Description: {PACKAGE_NAME}
 * @Version: 1.0
 */
class ShareResource {
    //定义标志位
    private int flag = 1;//AA:1、BB:2、CC:3
    //创建Lock锁
    private ReentrantLock lock = new ReentrantLock();
    //创建三个condition
    private Condition c1 = lock.newCondition();
    private Condition c2 = lock.newCondition();
    private Condition c3 = lock.newCondition();

    //打印5次，参数第几轮
    public void print5(int loop) throws InterruptedException {
        //上锁
        lock.lock();
        try {
            //判断
            while (flag != 1) {
                c1.await();
            }
            //干活
            for (int i = 1; i <= 5; i++) {
                System.out.println(Thread.currentThread().getName() + "\t::\t" + i + "\t:轮数:\t" + loop);
            }
            //唤醒
            flag = 2;
            c2.signal();
        } finally {
            //释放锁
            lock.unlock();
        }
    }

    public void print10(int loop) throws InterruptedException {
        //上锁
        lock.lock();
        try {
            while (flag != 2) {
                c2.await();
            }
            for (int i = 1; i <= 10; i++) {
                System.out.println(Thread.currentThread().getName() + "\t::\t" + i + "\t:轮数:\t" + loop);
            }
            flag = 3;
            c3.signal();
        } finally {
            //释放锁
            lock.unlock();
        }
    }

    public void print15(int loop) throws InterruptedException {
        //上锁
        lock.lock();
        try {
            while (flag != 3) {
                c3.await();
            }
            for (int i = 1; i <= 15; i++) {
                System.out.println(Thread.currentThread().getName() + "\t::\t" + i + "\t:轮数:\t" + loop);
            }
            flag = 1;
            c1.signal();
        } finally {
            //释放锁
            lock.unlock();
        }
    }
}


public class TreadDemo2 {
    public static void main(String[] args) {
        ShareResource shareResource = new ShareResource();
        new Thread(() -> {
            for (int i = 1; i <= 10; i++) {
                try {
                    shareResource.print5(i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "AA").start();

        new Thread(() -> {
            for (int i = 1; i <= 10; i++) {
                try {
                    shareResource.print10(i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "BB").start();

        new Thread(() -> {
            for (int i = 1; i <= 10; i++) {
                try {
                    shareResource.print15(i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "CC").start();
    }
}
