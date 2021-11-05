package Maze;

/*
 * 定义一个二维数组N*M（其中2<=N<=10;2<=M<=10），

//如5 × 5数组下所示： 
//int maze[5][5] = 
 { 0, 1, 0, 0, 0,
   1, 1, 1, 0, 0,
   0, 0, 0, 0, 0, 
   1, 1, 1, 0, 0,
   0, 0, 1, 0, 0};
 * 它表示一个迷宫，其中的1表示墙壁，0表示可以走的路， 只能横着走或竖着走，不能斜着走，要求编程序找出从左上角到右下角的最短路线。
 * 入口点为[0,0],既第一格是可以走的路。
 * 
 * 输入描述： 输入两个整数，分别表示二维数组的行数，列数。再输入相应的数组， 其中的1表示墙壁，0表示可以走的路。数据保证有唯一解,
 * 不考虑有多解的情况，即迷宫只有一条通道。
 * 
 * 输入： 5 5 0 1 0 0 0 0 1 1 1 0 0 0 0 0 0 0 1 1 1 0 0 0 0 1 0
 * 
 * 输出： (0,0) (1,0) (2,0) (2,1) (2,2) (2,3) (2,4) (3,4) (4,4)
 *
 */
import java.util.Scanner;
import java.util.Stack;

//定义一个点
class Point {
	int x;
	int y;

	Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class MazeDemo {
	private static int rows;
	private static int cols;
	private static Stack<Point> tempPath = new Stack<>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			rows = sc.nextInt();// 输入行数
			cols = sc.nextInt();// 输入列数
			int[][] map = new int[rows][cols];// 生成二维数组
			for (int i = 0; i < rows; i++) {
				for (int j = 0; j < cols; j++) {
					map[i][j] = sc.nextInt();// 先列后行的填入数值，生成迷宫
				}
			}
			mazeTrack(map, 0, 0);// 输入迷宫和起始位置（0，0）
		}
	}

	// 定义静态迷宫找路方法，传入迷宫和点位参数数据
	public static void mazeTrack(int[][] map, int x, int y) {
		Point p = new Point(x, y);// 创建这个点
		tempPath.push(p);// tempPath栈压入P点
		map[x][y] = 1;// 初始化此点的值为1，标志这个点已经走过
		if (x == rows - 1 && y == cols - 1) {// 右下角的位置坐标为（row - 1，cols - 1）
			for (Point point : tempPath) {// 用点遍历这个栈，循环输出路径
				System.out.println("(" + point.x + "," + point.y + ")");
			}
		}
		
		if (x + 1 < rows && map[x + 1][y] == 0) { // 横坐标在数组之内且这个点的右边还可以走
			mazeTrack(map, x + 1, y);// 往右走一步
		}

		if (x + 1 < rows && map[x - 1][y] == 0) { // 横坐标在数组之内且这个点的左边还可以走
			mazeTrack(map, x - 1, y);// 往左走一步
		}
		if (y + 1 < cols && map[x][y + 1] == 0) { // 纵坐标在数组之内且这个点的下边还可以走
			mazeTrack(map, x, y + 1);// 往下走一步
		}
		if (y + 1 < cols && map[x][y - 1] == 0) { // 纵坐标在数组之内且这个点的上边还可以走
			mazeTrack(map, x, y - 1);// 往上走一步
		}
		map[x][y] = 0;//再还原
		tempPath.pop();// 弹出路径
	}
}
