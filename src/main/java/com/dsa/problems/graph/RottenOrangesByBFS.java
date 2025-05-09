package com.dsa.problems.graph;

import java.util.LinkedList;
import java.util.Queue;

public class RottenOrangesByBFS {

    public static void main(String[] args) {
        int[][] mat = {{2, 1, 0, 2, 1},
                {1, 0, 1, 2, 1},
                {1, 0, 0, 2, 1}};
        System.out.println("Time taken to rot all oranges: " + rottenOranges(mat));
        // Output: 2
        int[][] mat2 = {{2, 1, 0, 2, 1}, {0, 0, 1, 2, 1}, {1, 0, 0, 2, 1}};
        System.out.println("Time taken to rot all oranges: " + rottenOranges(mat2));
    }

    private static int rottenOranges(int[][] mat) {
        int row = mat.length;
        int col = mat[0].length;
        int elapsedTime = 0;
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (mat[i][j] == 2) {
                    queue.add(new int[]{i, j});
                }
            }
        }
        int[][] directions = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean hasFreshOrange = false;
            for (int i = 0; i < size; i++) {
                int[] current = queue.poll();
                for (int[] direction : directions) {
                    assert current != null;
                    int newRow = current[0] + direction[0];
                    int newCol = current[1] + direction[1];
                    if (newRow >= 0 && newRow < row && newCol >= 0 && newCol < col && mat[newRow][newCol] == 1) {
                        mat[newRow][newCol] = 2;
                        queue.add(new int[]{newRow, newCol});
                        hasFreshOrange = true;
                    }
                }
            }
            if (hasFreshOrange) {
                elapsedTime++;
            }
        }
        for (int[] ints : mat) {
            for (int j = 0; j < col; j++) {
                if (ints[j] == 1) {
                    return -1;
                }
            }
        }
        return elapsedTime;
    }
}
