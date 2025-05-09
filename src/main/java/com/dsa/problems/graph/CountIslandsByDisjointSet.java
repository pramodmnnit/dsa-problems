package com.dsa.problems.graph;

import java.util.HashSet;
import java.util.Set;

/***
 * You are given an n, m which means the row and column of the 2D matrix,
 * and an array of size k denoting the number of operations. Matrix elements are 0
 * if there is water or 1 if there is land. Originally, the 2D matrix is all 0 which means
 * there is no land in the matrix. The array has k operator(s) and
 * each operator has two integers A[i][0], A[i][1] means
 * that you can change the cell matrix[A[i][0]][A[i][1]] from sea to island.
 * Return how many islands are there in the matrix after each operation. Y
 * ou need to return an array of size k.
 * Note: An island means a group of 1s such that they share a common side.
 * Input Format: n = 4 m = 5 k = 4 A = {{1,1},{0,1},{3,3},{3,4}}
 * Output: 1 1 2 2
 */


public class CountIslandsByDisjointSet {
    private final int[] parent;
    private final int[] rank;

    public static void main(String[] args) {
        int n = 4, m = 5, k = 4;
        int[][] grids = new int[n][m];
        int[][] A = {{1, 1}, {0, 1}, {3, 3}, {3, 4}};
        int[] result = new int[A.length];
        CountIslandsByDisjointSet dj = new CountIslandsByDisjointSet(n * m);
        int counter = 0;
        for (int[] operation : A) {
            grids[operation[0]][operation[1]] = 1;
            int count = countIslands(grids);
            result[counter++] = count;
        }
        for (int res : result) {
            System.out.print(res + " ");
        }
    }

    public CountIslandsByDisjointSet(int size) {
        parent = new int[size];
        rank = new int[size];
        for (int i = 0; i < size; i++) {
            parent[i] = i;
            rank[i] = 1;
        }
    }

    public int find(int i) {
        if (parent[i] != i) {
            parent[i] = find(parent[i]);
        }
        return parent[i];
    }

    public void union(int i, int j) {
        int parentI = find(i);
        int parentJ = find(j);
        if (parentI != parentJ) {
            if (rank[parentI] < rank[parentJ]) {
                parent[parentI] = parentJ;
            } else if (rank[parentI] > rank[parentJ]) {
                parent[parentJ] = parentI;
            } else {
                parent[parentI] = parentJ;
                rank[parentJ]++;
            }
        }
    }

    private static int countIslands(int[][] grids) {
        int row = grids.length;
        int col = grids[0].length;
        IslandsByDisjointSet dj = new IslandsByDisjointSet(row * col);
        int[][] direction = {
                {-1, 0}, {0, -1}, {0, 1}, {1, 0}
        };
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grids[i][j] == 1) {
                    for (int[] dir : direction) {
                        int nr = i + dir[0];
                        int nc = j + dir[1];
                        if (nr >= 0 && nr < row && nc >= 0 && nc < col && grids[nr][nc] == 1) {
                            dj.union(i * col + j, nr * col + nc);
                        }
                    }
                }
            }
        }
        Set<Integer> islands = new HashSet<>();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grids[i][j] == 1) {
                    islands.add(dj.find(i * col + j));
                }
            }
        }
        return islands.size();
    }
}
