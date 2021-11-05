package myspace.ConcurrentProgramming.readwrite;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @Auther: Renjie
 * @Date: 2021/10/10 - 14:54
 * @Description: {PACKAGE_NAME}
 * @Version: 1.0
 */
//读写锁怎么用
    //什么情况发生死锁？
    //读锁：共享锁、写锁：独占锁
//资源类
    class MyCache {
        //创建map集合
    private volatile Map<String,Object> map = new HashMap<>();

    //创建读写锁对象
    private ReadWriteLock rwLock = new ReentrantReadWriteLock();


    //放数据
    public void put(String key, Object value) {
        //加写锁
        rwLock.writeLock().lock();
        System.out.println(Thread.currentThread().getName() + " 正在写操作" + key);

        //暂停一会儿
        try {
            TimeUnit.MICROSECONDS.sleep(300);
            //放数据
            map.put(key,value);
            System.out.println(Thread.currentThread().getName() + " 写完了" + key);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally{
            //释放锁
            rwLock.writeLock().unlock();
        }

    }

    //取数据
    public Object get(String key) {
        //添加读锁
        rwLock.readLock().lock();
        Object result = null;
        System.out.println(Thread.currentThread().getName() + " 正在读取操作" + key);
        try {
            TimeUnit.MICROSECONDS.sleep(300);
            result = map.get(key);
            System.out.println(Thread.currentThread().getName() + " 取完了" + key);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally{
            //释放读锁
            rwLock.readLock().unlock();
        }
       return result;
    }
}

public class ReadWriteLockDemo {
    public static void main(String[] args) {
        MyCache myCache = new MyCache();

        //创建线程放数据
        for (int i = 1; i <= 5; i++) {
            final int num = i;
            new Thread(()->{
                myCache.put(num + "",num + "");
            },String.valueOf(i)).start();
            
        }

        //创建线程取数据
        for (int i = 1; i <= 5; i++) {
            final int num = i;
            new Thread(()->{
                myCache.get(num + "");
            },String.valueOf(i)).start();
        }

    }

}
