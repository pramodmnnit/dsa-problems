package com.dsa.problems.graph;

public class FloodFillAlgorithmByDFS {

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
        int originalColor = images[sr][sc];
        floodFill(images, sr, sc, newColor, originalColor);
        System.out.println("Color filled image: ");
        for (int[] image : images) {
            for (int j = 0; j < images[0].length; j++) {
                System.out.print(image[j] + " ");
            }
            System.out.println();
        }

    }

    private static void floodFill(int[][] images, int sr, int sc, int newColor, int originalColor) {
        if (sr < 0 || sr >= images.length || sc < 0 || sc >= images[0].length || images[sr][sc] != originalColor) {
            return;
        }
        images[sr][sc] = newColor;
        floodFill(images, sr - 1, sc, newColor, originalColor);
        floodFill(images, sr + 1, sc, newColor, originalColor);
        floodFill(images, sr, sc - 1, newColor, originalColor);
        floodFill(images, sr, sc + 1, newColor, originalColor);
    }
}
