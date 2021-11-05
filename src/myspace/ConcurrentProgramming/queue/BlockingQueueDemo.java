package myspace.ConcurrentProgramming.queue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @Auther: Renjie
 * @Date: 2021/10/10 - 16:10
 * @Description: {PACKAGE_NAME}
 * @Version: 1.0
 */
public class BlockingQueueDemo {
    public static void main(String[] args) {
        //创建一个阻塞队列
        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(3);

//        //第一组
//        System.out.println(blockingQueue.add("a"));
//        System.out.println(blockingQueue.add("b"));
//        System.out.println(blockingQueue.add("c"));
//       // System.out.println(blockingQueue.element());
//
//        //System.out.println(blockingQueue.add("w"));
//        System.out.println(blockingQueue.remove());
//        System.out.println(blockingQueue.remove());
//        System.out.println(blockingQueue.remove());
//        System.out.println(blockingQueue.remove());


        System.out.println(blockingQueue.offer("b"));
        System.out.println(blockingQueue.offer("c"));
       // System.out.println(blockingQueue.element());

        //System.out.println(blockingQueue.add("w"));
        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());

    }


}
