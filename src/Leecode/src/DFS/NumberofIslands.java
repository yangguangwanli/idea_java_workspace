package DFS;

public class NumberofIslands {
//	给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。

//	岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
//
//	此外，你可以假设该网格的四条边均被水包围
//	输入：grid = [
//	  ["1","1","1","1","0"],
//	  ["1","1","0","1","0"],
//	  ["1","1","0","0","0"],
//	  ["0","0","0","0","0"]
//	]
//	输出：1

	public static void main(String[] args) {

	}
	//初始化二维边界大小和方向
	private int m, n;
	private int[][] direction = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

	public int numIslands(char[][] grid) {
	    if (grid == null || grid.length == 0) {
	        return 0;
	    }
	    //初始化数量
	    m = grid.length;
	    n = grid[0].length;
	    int islandsNum = 0;
	    for (int i = 0; i < m; i++) {
	        for (int j = 0; j < n; j++) {
	        	//如果遇到的不是'0'的这个字符，就对这个点进行深度优先遍历，由点及面，且数量加1
	            if (grid[i][j] != '0') {
	                dfs(grid, i, j);
	                //成功实行一次深度优先搜索，就代表有一个切实的岛屿
	                islandsNum++;
	            }
	        }
	    }
	    return islandsNum;
	}

	private void dfs(char[][] grid, int i, int j) {
		//依旧是在二维数组的限定范围内，grid[i][j] == '0'说明此点是岛屿
	    if (i < 0 || i >= m || j < 0 || j >= n || grid[i][j] == '0') {
	        return;
	    }
	    //置为0，表示已经被访问
	    grid[i][j] = '0';
	    //循环向4个方向延展开
	    for (int[] d : direction) {
	        dfs(grid, i + d[0], j + d[1]);
	    }
	}

}
