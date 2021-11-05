package MP3;

import java.util.Scanner;

public class MP3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			int songs = sc.nextInt();
			String commands = sc.nextLine();
			// 遍历命令，找到指针最后位置
			int cur = 1, up = 1;
			// 歌曲列表的底部down与歌曲数量有直接的关系，小于等于4就以歌曲数量为准，大于4就以4为准
			int down = songs <= 4 ? songs : 4;
			// 歌曲小于4的情况
			for (int i = 0; i < commands.length(); i++) {
				char c = commands.charAt(i);
				if (c == 'U') {// 上
					// 特殊上，特殊翻页
					if (cur == 1) {// 特殊上，特殊翻页
						cur = songs;
						up = songs - 3 < 1 ? 1 : songs - 3;// 歌曲小于4的情况
						down = songs;
					} else {// 一般上
						if (cur == up) {// 需要普通翻页
							cur--;
							up--;
							down--;
						} else {// 无需翻页
							cur--;
						}
					}
				} else {// 下
					if (cur == songs) {// 特殊下，特殊翻页
						cur = 1;
						up = 1;
						down = songs <= 4 ? songs : 4;
					} else {// 一般下
						if (cur == down) {// 需要普通翻页
							cur++;
							down++;
							up++;
						} else {// 无需普通翻页
							cur++;
						}
					}
				}
			}
			// 输出
			for (int i = 0; i < down; i++) {// 输出时注意歌曲大小
				System.out.print(up + i);
				if (i != down - 1)
					System.out.print(" ");
			}
			System.out.println();// 输出当前歌曲
			System.out.println(cur);

		}
	}
}