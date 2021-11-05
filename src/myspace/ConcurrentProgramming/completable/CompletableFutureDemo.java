package myspace.ConcurrentProgramming.completable;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * @Auther: Renjie
 * @Date: 2021/10/10 - 19:15
 * @Description: {PACKAGE_NAME}
 * @Version: 1.0
 */
public class CompletableFutureDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //异步调用 没有返回值
        CompletableFuture<Void> completableFuture1 = CompletableFuture.runAsync(()->{
            System.out.println(Thread.currentThread().getName() + " completableFuture1");
        });
        completableFuture1.get();


        //异步调用 有返回值
        CompletableFuture<Integer> completableFuture2 = CompletableFuture.supplyAsync(()->{
            System.out.println(Thread.currentThread().getName() + " completableFuture1");
           //模拟异常
            int i = 1 / 0;
           return 1024;
        });
        completableFuture2.whenComplete((t, u)->{
            System.out.println("------t=" + t);//t: 方法的返回值
            System.out.println("------u=" + u);//u: 异常信息
        }).get();
    }
}
