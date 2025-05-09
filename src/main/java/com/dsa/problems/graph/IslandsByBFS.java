package com.dsa.problems.graph;

import java.util.LinkedList;
import java.util.Queue;

public class IslandsByBFS {

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
                    bfs(grids, visited, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    private static void bfs(char[][] grids, boolean[][] visited, int i, int j) {
        if (i < 0 || i >= grids.length || j < 0 || j >= grids[0].length || visited[i][j] || grids[i][j] == 'W') {
            return;
        }
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{i, j});
        visited[i][j] = true;
        int[] rNbr = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] cNbr = {-1, 0, 1, -1, 1, -1, 0, 1};
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            for (int k = 0; k < 8; k++) {
                int newRow = current[0] + rNbr[k];
                int newCol = current[1] + cNbr[k];
                if (newRow >= 0 && newRow < grids.length && newCol >= 0 && newCol < grids[0].length && !visited[newRow][newCol] && grids[newRow][newCol] == 'L') {
                    queue.add(new int[]{newRow, newCol});
                    visited[newRow][newCol] = true;
                }
            }
        }
    }

}
