package Collections;

import com.sun.xml.internal.bind.v2.model.core.MapPropertyInfo;

import java.util.*;

/**
 * @Auther: Renjie
 * @Date: 2021/10/18 - 19:39
 * @Description: {PACKAGE_NAME}
 * @Version: 1.0
 */
public class Homework3 {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap();
        map.put("jack", 650);
        map.put("tom", 1200);
        map.put("smith", 2900);

        map.put("jack", 2600);
        System.out.println(map);

        for (String s : map.keySet()) {
            map.put(s, map.get(s) + 100);
        }
        System.out.println(map);

        for (String s : map.keySet()) {
            System.out.println(s);
        }
        for (String s : map.keySet()) {
            System.out.println(map.get(s));
        }
        //遍历entrySet
        Set entrySet = map.entrySet();
        //迭代器
        Iterator iterator = entrySet.iterator();
        while (iterator.hasNext()) {
            Map.Entry entry =  (Map.Entry) iterator.next();
            System.out.println(entry.getKey() + "-" + entry.getValue());
        }

        System.out.println("======遍历所以的工资======");
        Collection values = map.values();
        for (Object v : values){
            System.out.println("工资=" + v);
        }
    }
}

/*Homework4
* 试分析HashSet和TreeSet分别如何实现去重操作
* 1、HashSet的去重机制：hashcode()+equals(),底层先通过存入对象
* 进行运算得到一个hash值，通过hash值得到对应的索引，如果发现table索引所在的位置，
* 没有数据，就直接存放，如果有数据，就进行equals比较[遍历比较]，如果比较后，不相同，就加入，否则就不加入
*2、treeset的去重机制：如果你传入了一个Comparator匿名对象，就使用实现的compare去重，如果方法返回为0，就认为是相同的数据
* 就不添加，如果没有传入一个comparator匿名对象，则以你添加的对象实现的Comparable接口的compareTo去重
*
*
* */