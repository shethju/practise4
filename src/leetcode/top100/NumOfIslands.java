package leetcode.top100;

// https://leetcode.com/problems/number-of-islands/
public class NumOfIslands {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int numIslands(char[][] grid) {
        int count = 0;
        int rows = grid.length;
        if (rows == 0) return count;
        int columns = grid[0].length;
        for (int i=0; i < rows; i++) {
        		for (int j=0; j < columns; j++) {
        			if (grid[i][j] == '1') {
        				dfs(grid, i, j);
        				++count;
        			}
        		}
        }
        return count;
    }
	
	private void dfs(char[][] grid, int row, int column) {
		int numcolumns = grid[0].length - 1;
        int numrows = grid.length -1;
        if (row < 0 || row > numrows || column < 0 || column > numcolumns || grid[row][column] != '1') return;
        grid[row][column] = 0;
        dfs(grid, row -1, column);
        dfs(grid, row +1, column);
        dfs(grid, row, column - 1);
        dfs(grid, row, column + 1);
	}

}
