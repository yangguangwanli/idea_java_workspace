package myspace.ConcurrentProgramming.juc;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @Auther: Renjie
 * @Date: 2021/10/9 - 23:50
 * @Description: {PACKAGE_NAME}
 * @Version: 1.0
 */
//集齐七颗龙珠召唤神龙

public class CyclicBarrierDemo {
    //固定值
    private static final int NUMBER = 7;

    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(NUMBER,()->{
            System.out.println("集齐七颗龙珠召唤神龙");
        });

        //集齐七颗龙珠的过程
        for (int i = 1; i <= 7; i++) {
            new Thread(()->{
                //等待
                try {
                    System.out.println(Thread.currentThread().getName() + " 星龙珠GET！！");
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }


            },String.valueOf(i)).start();
        }

    }
}
