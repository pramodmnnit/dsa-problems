package com.dsa.problems.graph;

import java.util.ArrayList;
import java.util.List;

public class DetectCycleByDFS {

    public static void main(String[] args) {
        int v = 4;
        int[][] edges = {
                {0, 1}, {0, 2}, {1, 2}, {2, 0}, {2, 3}
        };
        List<List<Integer>> adjacencyList = new ArrayList<>(4);
        constructAdjacencyList(adjacencyList, v, edges);
        System.out.println("Adjacency List:");
        for (int i = 0; i < adjacencyList.size(); i++) {
            System.out.println("Adjacency list of vertex " + i + ": " + adjacencyList.get(i));
        }
        boolean[] visited = new boolean[v];
        boolean[] recStack = new boolean[v];
        boolean isCyclePresent = isCyclePresent(adjacencyList, visited, recStack);
        if (isCyclePresent) {
            System.out.println("Cycle is present in the graph");
        } else {
            System.out.println("Cycle is not present in the graph");
        }

    }

    private static boolean isCyclePresent(List<List<Integer>> adjacencyList, boolean[] visited, boolean[] recStack) {
        for (int i = 0; i < adjacencyList.size(); i++) {
            if (!visited[i]) {
                if (isCycleUtil(adjacencyList, visited, recStack, i)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean isCycleUtil(List<List<Integer>> adjacencyList, boolean[] visited, boolean[] recStack, int i) {
        visited[i] = true;
        recStack[i] = true;

        for (int j : adjacencyList.get(i)) {
            if (!visited[j]) {
                if (isCycleUtil(adjacencyList, visited, recStack, j)) {
                    return true;
                }
            } else if (recStack[j]) {
                return true;
            }
        }
        recStack[i] = false;
        return false;
    }

    private static void constructAdjacencyList(List<List<Integer>> adjacencyList, int v, int[][] edges) {
        for (int i = 0; i < v; i++) {
            adjacencyList.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            int u = edge[0];
            int v1 = edge[1];
            adjacencyList.get(u).add(v1);
        }
    }
}
