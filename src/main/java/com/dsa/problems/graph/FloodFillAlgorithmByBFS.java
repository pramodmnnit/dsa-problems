package com.dsa.problems.graph;

import java.util.LinkedList;
import java.util.Queue;

public class FloodFillAlgorithmByBFS {

    private static void bfs(int[][] images, int sr, int sc, int newColor) {
        int[][] direction = {
                {-1, 0}, {1, 0}, {0, -1}, {0, 1}
        };

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{sr, sc});
        int originalColor = images[sr][sc];
        while (!queue.isEmpty()) {
            int[] data = queue.poll();
            int row = data[0];
            int col = data[1];
            images[row][col] = newColor;
            for (int[] dir : direction) {
                int newRow = row + dir[0];
                int newCol = col + dir[1];
                if (newRow >= 0 && newRow < images.length && newCol >= 0 && newCol < images[0].length && images[newRow][newCol] == originalColor) {
                    queue.add(new int[]{newRow, newCol});
                }
            }
        }

    }

    public static void main(String[] args) {

        int[][] images = {
                {
                        1, 1, 1, 0
                }, {
                0, 1, 1, 1
        },
                {
                        1, 0, 1, 1
                }
        };

        int sr = 1, sc = 2, newColor = 2;
        bfs(images, sr, sc, newColor);
        System.out.println("Color filled image: ");
        for (int[] image : images) {
            for (int j = 0; j < images[0].length; j++) {
                System.out.print(image[j] + " ");
            }
            System.out.println();
        }

    }
}
