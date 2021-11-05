package myspace.ConcurrentProgramming.syn;
import java.util.*;

public class TheFirstInterview {
    public static void main(String[] args) {

        Collection col = new ArrayList();
        col.add(new Book("三国演义", "罗贯中", 10.1));
        col.add(new Book("小李飞刀", "古龙", 5.1));
        col.add(new Book("红楼梦", "曹雪芹", 34.6));
        //col.iterater()是默认指向迭代器的头部的，是个常指针
        Iterator iterator = col.iterator();
        while(iterator.hasNext()){
            Object obj = iterator.next();
            System.out.println(obj);
        }

        List<Object> list = new LinkedList<Object>();
        list.add(0,"ABC");



        //增强for就是一个简化版的迭代器遍历
        for (Object book : col){
            System.out.println(book);
        }
    }
}
class Book{
    private String name ; //
    private String author ; //
    private double price ; //

    public Book(String name, String author, double price) {
        this.name = name;
        this.author = author;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public double getPrice() {
        return price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", price=" + price +
                '}';
    }
}