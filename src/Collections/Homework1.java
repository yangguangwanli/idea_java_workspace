package Collections;

import com.sun.org.apache.bcel.internal.generic.NEW;

import java.util.ArrayList;

/**
 * @Auther: Renjie
 * @Date: 2021/10/18 - 17:39
 * @Description: {PACKAGE_NAME}
 * @Version: 1.0
 */
public class Homework1 {
   public static void main(String[] args) {
      ArrayList arrayList = new ArrayList<>();
      arrayList.add(new News("News1:啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊"));
      arrayList.add(new News("News2：bbbbbbbbbbbbb"));

      int size = arrayList.size();
      //这里是倒序遍历，输出用get方法
      for(int i = size - 1; i >= 0; i--){
         News news = (News) arrayList.get(i);
        // System.out.println(arrayList.get(i));
         System.out.println(processTitle(news.getTitle()));
      }
   }
   //专门写一个方法，处理现实新闻标题process处理,如果长度大于15就截取输出
   public static String processTitle(String title){
      if (title == null) {
         return "";
      }
      if (title.length() > 15){
         return  title.substring(0,15) + "...";//取到0-14，一个15个字符,[0,14)
      }else{
         return title;
      }
   }

}
class News{
   private String title;
   private String content;

   public News(String title) {
      this.title = title;
   }

   public String getTitle() {
      return title;
   }

   public String getContent() {
      return content;
   }

   public void setTitle(String title) {
      this.title = title;
   }

   public void setContent(String content) {
      this.content = content;
   }

   @Override
   public String toString() {
      return "News{" +
              "title='" + title + '\'' +
              '}';
   }
}