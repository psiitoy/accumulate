package org.sprintdragon.algorithm.lc;

public class Title200 {

    public static void main(String[] args) {
        char[][] a = {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };
        Title200 test = new Title200();
        System.out.println(test.numIslands(a));
    }

    public int numIslands(char[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int island = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (visited[i][j] == false && grid[i][j] == '1') {
                    dfs(grid, i, j, visited);
                    island++;
                }
            }
        }
        return island;
    }

    public void dfs(char[][] grid, int row, int column, boolean[][] visited) {
        if (row < 0 || column < 0 || row >= grid.length || column >= grid[0].length) {
            return;
        }
        if (visited[row][column]) {
            return;
        } else {
            visited[row][column] = true;
        }
        if (grid[row][column] == '0') {
            return;
        }
        dfs(grid, row - 1, column, visited);
        dfs(grid, row + 1, column, visited);
        dfs(grid, row, column - 1, visited);
        dfs(grid, row, column + 1, visited);
    }

}
