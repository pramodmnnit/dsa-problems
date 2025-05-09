package com.dsa.problems.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class DetectCycleByTopologicalSort {

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
        int[] inDegrees = new int[4];
        int visited = 0;
        for (List<Integer> integers : adjacencyList) {
            for (Integer integer : integers) {
                inDegrees[integer]++;

            }
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < inDegrees.length; i++) {
            if (inDegrees[i] == 0) {
                queue.add(i);
            }
        }
        while (!queue.isEmpty()) {
            int current = queue.poll();
            visited++;
            for (int j : adjacencyList.get(current)) {
                inDegrees[j]--;
                if (inDegrees[j] == 0) {
                    queue.add(j);
                }
            }
        }
        if (visited == v) {
            System.out.println("Cycle is not present in the graph");
        } else {
            System.out.println("Cycle is present in the graph");
        }

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
