package Stringcheck;

import java.util.Scanner;

public class StringcheckDemo2 {

	public static void main(String[] args) {
		 Scanner sc = new Scanner(System.in);
	        while(sc.hasNextLine()){
	            String str1 = sc.nextLine();
	            String str2 = sc.nextLine();
	            int max = 0;
	            String tmp = "";
	            //str2是更长的那个字符串
	            if(str1.length() > str2.length()){
	                tmp = str2;
	                str2 = str1;
	                str1 = tmp;
	            }
	            
	            //找到最大公共长度max
	            for(int i = 0; i < str1.length(); i++){
	                for(int j = i+1; j <= str1.length(); j++){
	                	String common = str1.substring(i,j);//定义公共部分字串
	                    if(str2.contains(common)){//如果长的字符串 包括 长的从i到j的字符
	                    	//max找到最大的共同字串的长度
	                        max = common.length() >= max ? common.length() : max;
	                    }
	                }
	            }
	            
	            //再次遍历长的字符串，当找到最大公共部分，则输出且退出
	            for(int i = 0; i < str1.length(); i++){
	                if(str2.contains(str1.substring(i, i + max))){
	                    System.out.println(str1.substring(i, i + max));
	                    break;
	                }
	            }
	        }
	        sc.close();
	    }
	}