package Collections;

import javax.lang.model.element.VariableElement;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * @Auther: Renjie
 * @Date: 2021/10/18 - 18:33
 * @Description: {PACKAGE_NAME}
 * @Version: 1.0
 */
class Car{
    private String name;
    private double price;

    public Car(String name, double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}

public class Homework2 {
    public static void main(String[] args) {
        ArrayList<Object> arrayList = new ArrayList<>();
        Car car1 = new Car("宝马",400000);
        Car car2 = new Car("宾利",5000000);

        arrayList.add(car1);
        arrayList.add(car2);
        System.out.println(arrayList);

        arrayList.remove(car1);
        System.out.println(arrayList);

        System.out.println(arrayList.contains(car1));

        System.out.println(arrayList.size());

        System.out.println(arrayList.isEmpty());

//        arrayList.clear();
//
//        System.out.println(arrayList);

        arrayList.addAll(arrayList);

        System.out.println(arrayList);

        System.out.println(arrayList.containsAll(arrayList));

//        arrayList.removeAll(arrayList);
//        System.out.println(arrayList);

        for (Object o : arrayList) {
            System.out.println(o);
        }
        System.out.println("======以下为迭代器处理=====");
        Iterator<Object> iterator = arrayList.iterator();
        while (iterator.hasNext()) {
            Object next =  iterator.next();
            System.out.println(next);
            
        }
        
    }
}
