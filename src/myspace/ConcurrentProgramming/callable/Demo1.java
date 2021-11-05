package myspace.ConcurrentProgramming.callable;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @Auther: Renjie
 * @Date: 2021/10/9 - 22:58
 * @Description: {PACKAGE_NAME}
 * @Version: 1.0
 */

//比较两个接口
//实现Runnable接口
class Mythread1 implements Runnable {
    @Override
    public void run() {

    }
}

class Mythread2 implements Callable {
//为了实现callable必须重写call()方法
    @Override
    public Object call() throws Exception {
        System.out.println(Thread.currentThread().getName() + " come in callable");
        return 200;
    }
}

public class Demo1 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //Runnable接口创建线程
        new Thread(new Mythread1(),"AA").start();

        //直接替换会报错
        //new Thread(new Mythread2(),"BB").start();
        //需要找一个类，即跟Runnable，又跟Callable有关
        //Runnable接口的实现类:FutureTask，它的构造方法可以传递Callable

        //写类实现
        FutureTask<Integer> futureTask1 = new FutureTask<Integer>(new Mythread2());

        //lam表达式
        FutureTask<Integer> futureTask2 = new FutureTask<Integer>(()->{
            System.out.println(Thread.currentThread().getName() + " come in callable");
            return 1024;
        });

        //创建一个线程
        new Thread(futureTask2,"luck").start();
        new Thread(futureTask1,"mary").start();

//        while (!futureTask2.isDone()){
//            System.out.println("wait.......");
//        }

        //调用FutureTask的GET方法
        System.out.println(futureTask2.get());

        System.out.println(futureTask1.get());

        System.out.println(Thread.currentThread().getName() + " come over");

    }
}
