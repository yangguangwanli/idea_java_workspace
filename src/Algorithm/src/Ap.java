

public class Ap {
    /*编写一个方法，返回一个都变了型二维数组，数组中的元素通过解析字符串参数获得。
    如字符串参数："1,2;3,4;5,6;7,8"
    对应数组为：
    d[0,0]=1.0  d[0,1]=2.0
    d[1.0]=3.0 d[1.1]=4.0 d[1.2]=5.0
    d[2.0]=6.0 d[2.1]=7.0 d[2.2]=8.0
     */
    public static void main(String[] args) {//先拆开一维，再拆二维
        double[][] d;
        String s = "1,2;3,4,5;6,7,8";//传入字符串
        String[] sFirst = s.split(";");//先用；分隔
        d = new double[sFirst.length][];//定义二维数组的一维的长度，为；隔开的sFirst一维数组的长度

        for (int i = 0; i < sFirst.length; i++) {
            String[] sSecond = sFirst[i].split(",");//用，隔开，形成数组
            d[i] = new double[sSecond.length];//定义第二维的长度
            for (int j = 0; j < sSecond.length; j++) {
                d[i][j] = Double.parseDouble(sSecond[j]); //double转换，赋值给d[i][j]
            }
        }

        for (int i = 0; i < d.length; i++) {
            for (int j = 0; j < d[i].length; j++) {
                System.out.print("d[" + i + "][" + j + "]=" + d[i][j] + " ");//打印
            }
            System.out.println();//空行
        }
    }
}

//如果要求有输入输出
