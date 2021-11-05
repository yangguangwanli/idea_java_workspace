package myspace.ConcurrentProgramming.syn;
//第一：创建资源类，定义属性和操作方法

/**
 * @Auther: Renjie
 * @Date: 2021/10/9 - 19:25
 * @Description: {PACKAGE_NAME}
 * @Version: 1.0
 */
class Share {
    //初始值
    private int number = 0;

    //+1的方法
    public synchronized void incr() throws InterruptedException {
        //第二部  判断、干活 通知
        while (number != 0) {//不为0不+1，等待
            //如果写if只会判断一次，导致虚假唤醒问题，所以要用while
            this.wait();//在哪里睡就在哪里醒来，
        }

        //如果number值是0，就+1操作
        number++;
        System.out.println(Thread.currentThread().getName() + "::" + number);
        //通知其他线程
        this.notifyAll();
    }

    //-1的方法
    public synchronized void decr() throws InterruptedException {
        //判断
        while (number != 1) {
            this.wait();
        }
        //干活
        number--;
        System.out.println(Thread.currentThread().getName() + "::" + number);
        //通知其他的线程
        this.notifyAll();
    }
}

    public  class TreadDemo1 {
        public static void main(String[] args) {
            //第三步 创建多个线程，调用资源类的操作方法
            Share share = new Share();
            //创建线程
            new Thread(() -> {
                for (int i = 1; i < 10; i++) {
                    try {
                        share.incr();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }, "AA").start();

            new Thread(() -> {
                for (int i = 1; i < 10; i++) {
                    try {
                        share.decr();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }, "BB").start();

            new Thread(() -> {
                for (int i = 1; i < 10; i++) {
                    try {
                        share.incr();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }, "CC").start();

            new Thread(() -> {
                for (int i = 1; i < 10; i++) {
                    try {
                        share.decr();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }, "DD").start();


        }
}