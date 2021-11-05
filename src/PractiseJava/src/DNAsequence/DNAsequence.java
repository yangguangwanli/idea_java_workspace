package DNAsequence;

import java.util.Scanner;

public class DNAsequence {

//	描述
//	一个DNA序列由A/C/G/T四个字母的排列组合组成。G和C的比例（定义为GC-Ratio）
//  是序列中G和C两个字母的总的出现次数除以总的字母数目（也就是序列长度）。
//  在基因工程中，这个比例非常重要。因为高的GC-Ratio可能是基因的起始点。
//
//	给定一个很长的DNA序列，以及限定的子串长度N，
//  请帮助研究人员在给出的DNA序列中从左往右找出GC-Ratio最高且长度为N的第一个子串。
//	DNA序列为ACGT的子串有:ACG,CG,CGT等等，但是没有AGT，CT等等
//	输入描述：
//	输入一个string型基因序列，和int型子串的长度
//
//	输出描述：
//	找出GC比例最高的子串,如果有多个则输出第一个的子串
//
//	示例1
//	输入：
//	ACGT
//	2
//	
//	输出：
//	CG
//	
//	说明：
//	ACGT长度为2的子串有AC,CG,GT3个，其中AC和GT2个的GC-Ratio都为0.5，CG为1，故输出CG  
//	示例2
//	输入：
//	AACTGTGCACGACCTGA
//	5
//	
//	输出：
//	GCACG
//	
//	说明：
//	虽然CGACC的GC-Ratio也是最高，但它是从左往右找到的GC-Ratio最高的第2个子串，所以只能输出GCACG。 

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			String s = sc.nextLine();
            //n为指定子串的长度
			int n = sc.nextInt();
			int sum = 0;
			int index = 0;
			for (int i = 0; i < s.length() - n; i++) {
				int count = 0;
				String str = s.substring(i, i+n);
				char arr[] = str.toCharArray();
				for (char c : arr) {
					if(c=='C' || c=='G') {
						count ++;
					}
				}
                //既然做判断直接比较大小即可，不用再计算复杂分数，只要比C和G的个数就可以
				if (count > sum) {
					sum = count;
					index = i;
				}
			}
			System.out.println(s.substring(index, index + n));
		}

	}

}
