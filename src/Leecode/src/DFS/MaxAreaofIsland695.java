package DFS;

public class MaxAreaofIsland695 {
//	给你一个大小为 m x n 的二进制矩阵 grid 。

//	岛屿 是由一些相邻的 1 (代表土地) 构成的组合，这里的「相邻」要求两个 1 必须在 水平或者竖直的四个方向上 相邻
//	你可以假设 grid 的四个边缘都被 0（代表水）包围着。
//
//	岛屿的面积是岛上值为 1 的单元格的数目。
//	
//	计算并返回 grid 中最大的岛屿面积。如果没有岛屿，则返回面积为 0

	public static void main(String[] args) {

	}
	//定义全局变量m和n，作为二维数组的边界
	private int m, n;
	//初始化四个方向，上下左右
	private int[][] direction = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

	public int maxAreaOfIsland(int[][] grid) {
	    if (grid == null || grid.length == 0) {
	        return 0;
	    }
	    //m为行数，n为列数
	    m = grid.length;
	    n = grid[0].length;
	    //最大面积初始化为0
	    int maxArea = 0;
	    for (int i = 0; i < m; i++) {
	        for (int j = 0; j < n; j++) {
	        	//遍历这片海洋的每个点，找到最大的岛屿
	            maxArea = Math.max(maxArea, dfs(grid, i, j));
	        }
	    }
	    return maxArea;
	}
//	对grid[i][j]这个点的深度优先算法
	private int dfs(int[][] grid, int i, int j) {
		//  边界条件，前四个不用说，必须在二维数组地图内
		//  grid[i][j] == 0说明这个点位是水，或者已经访问过
	    if (i < 0 || i >= m || j < 0 || j >= n || grid[i][j] == 0) {
	        return 0;
	    }
	    //把这个点置为0，标志此点已访问过
	    grid[i][j] = 0;
	    //初始面积置为1
	    int area = 1;
	    //由这个点引申依次轮询加上四个方向的深度优先返回的结果，最终返回值就是"每个岛屿"的面积
	    for (int[] d : direction) {
	        area += dfs(grid, i + d[0], j + d[1]);
	    }
	    return area;
	}

}
