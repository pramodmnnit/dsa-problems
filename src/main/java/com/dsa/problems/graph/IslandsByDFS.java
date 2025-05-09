package com.dsa.problems.graph;

public class IslandsByDFS {

    public static void main(String[] args) {

        char[][] grids = {
                {'L', 'L', 'W', 'W', 'W'},
                {'W', 'L', 'W', 'W', 'L'},
                {'L', 'W', 'W', 'L', 'L'},
                {'W', 'W', 'W', 'W', 'W'},
                {'L', 'W', 'L', 'L', 'W'}
        };

        System.out.println("Number of islands: " + countIslands(grids));
    }

    private static int countIslands(char[][] grids) {
        int row = grids.length;
        int col = grids[0].length;
        boolean[][] visited = new boolean[row][col];
        int count = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grids[i][j] == 'L' && !visited[i][j]) {
                    dfs(grids, visited, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    public static void dfs(char[][] grids, boolean[][] visited, int i, int j) {
        if (i < 0 || i >= grids.length || j < 0 || j >= grids[0].length || visited[i][j] || grids[i][j] == 'W') {
            return;
        }
        visited[i][j] = true;
        int[] rNbr = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] cNbr = {-1, 0, 1, -1, 1, -1, 0, 1};
        for (int k = 0; k < 8; k++) {
            dfs(grids, visited, i + rNbr[k], j + cNbr[k]);
        }

    }
}
