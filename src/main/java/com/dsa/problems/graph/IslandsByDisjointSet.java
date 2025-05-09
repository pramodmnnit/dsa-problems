package com.dsa.problems.graph;

import java.util.HashSet;
import java.util.Set;

public class IslandsByDisjointSet {

    private final int[] parent;
    private final int[] rank;

    public IslandsByDisjointSet(int size) {
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
        IslandsByDisjointSet dj = new IslandsByDisjointSet(row * col);
        int[][] direction = {
                {-1, -1}, {-1, 0}, {-1, 1}, {
                0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}
        };
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grids[i][j] == 'L') {
                    for (int[] dir : direction) {
                        int nr = i + dir[0];
                        int nc = j + dir[1];
                        if (nr >= 0 && nr < row && nc >= 0 && nc < col && grids[nr][nc] == 'L') {
                            dj.union(i * col + j, nr * col + nc);
                        }
                    }
                }
            }
        }
        Set<Integer> islands = new HashSet<>();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grids[i][j] == 'L') {
                    islands.add(dj.find(i * col + j));
                }
            }
        }
        return islands.size();
    }
}
