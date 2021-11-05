package zuixiaogongbeishu;

import java.util.Random;
//这是一行单独注释
/*
这是多行注释
*/

/**
 * 这是文档注释
 *
 *
 */
public class JVM {

    public static void main(String[] args) {
        String sss = "herenjiedashaB";

        while (true) {
            sss += sss + new Random().nextInt(88888888) + new Random().nextInt(999999999);
        }
    }
}
