package myspace.ConcurrentProgramming.syn;

import java.util.concurrent.TimeUnit;

/**
 * @Auther: Renjie
 * @Date: 2021/10/9 - 22:28
 * @Description: 模拟死锁的发生过程
 * @Version: 1.0
 */


public class DeadLock {
    //创建两个对象
    static Object a = new Object();
    static Object b = new Object();

    public static void main(String[] args) {
        new Thread(()->{
            synchronized (a){
                System.out.println(Thread.currentThread().getName() + " Hold Lock A，try to get LOCK B");
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (b){
                    System.out.println(Thread.currentThread().getName() + "Successfully get LOCK B");
                }
            }
        },"AA").start();

        new Thread(()->{
            synchronized (b){
                System.out.println(Thread.currentThread().getName() + " Hold Lock B，try to get LOCK A");
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (a){
                    System.out.println(Thread.currentThread().getName() + "Successfully get LOCK A");
                }
            }
        },"BB").start();
    }
}
