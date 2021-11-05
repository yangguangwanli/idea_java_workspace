package myspace.ConcurrentProgramming.forkjoin;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

/**
 * @Auther: Renjie
 * @Date: 2021/10/10 - 18:50
 * @Description: {PACKAGE_NAME}
 * @Version: 1.0
 */

class Mytask extends RecursiveTask<Integer> {

    //拆分插值不能超过10
    private static final Integer VALUE = 10;
    private int begin;//拆分开始值
    private int end; //拆分结束值
    private int result; //返回结果

    //创建有参构造
    public Mytask(int begin, int end) {
        this.begin = begin;
        this.end = end;
    }

    //拆分和合并过程（二分递归）
    @Override
    protected Integer compute() {
        //判断相机啊两个数值是否大于0
        if ((end - begin) <= VALUE) {
            //相加操作操作
            for (int i = begin; i <= end; i++) {
                result = result + i;
            }
        } else {//进一步拆分
            //获取中间值
            int middle = (begin + end) / 2;
            //拆分左边
            Mytask task01 = new Mytask(begin, middle);
            //拆分右边
            Mytask task02 = new Mytask(middle + 1, end);
            task01.fork();
            task02.fork();
            //合并结果
            result = task01.join() + task02.join();
        }

        return result;
    }
}

public class ForkJoinDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //创建Mytask对象(任务：从1加到100，返回结果)
        Mytask mytask = new Mytask(0, 100);
        //创建分支合并池对象
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        ForkJoinTask<Integer> forkJoinTask = forkJoinPool.submit(mytask);

        //获取最终合并之后的结果
        Integer result = forkJoinTask.get();
        System.out.println(result);
        //关闭对象
        forkJoinPool.shutdown();
    }
}

