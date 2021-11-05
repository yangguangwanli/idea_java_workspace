package Collections;

import java.util.TreeSet;

/**
 * @Auther: Renjie
 * @Date: 2021/10/18 - 23:09
 * @Description: {PACKAGE_NAME}
 * @Version: 1.0
 */
public class Homework4 {
    public static void main(String[] args) {
        TreeSet<Object> treeSet = new TreeSet<>();
        //分析源码
        //add方法，因为TreeSet（）构造器没有传入Comparator接口的匿名内部类
        //所以在底层会把Person转成Comparable类型
        treeSet.add(new Person());//ClassCastException.
        treeSet.add(new Person());
        treeSet.add(new Person());
        treeSet.add(new Person());
    }
}
//类实现Comparable接口即可
class Person implements Comparable{

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}