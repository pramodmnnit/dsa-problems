package com.dsa.problems.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BreadthFirstSearch {

    public static void main(String[] args) {
        List<List<Integer>> adjacencyList = new ArrayList<>(6);
        for (int i = 0; i < 6; i++) {
            adjacencyList.add(new ArrayList<>());
        }
        createAdjacencyList(adjacencyList);
        List<Integer> result = new ArrayList<>();
        boolean[] visited = new boolean[6];
        for (int i = 0; i < 6; i++) {
            if (!visited[i]) {
                bfs(i, adjacencyList, visited, result);
            }
        }
        System.out.println("BFS traversal: " + result);
    }

    private static void bfs(int i, List<List<Integer>> adjacencyList, boolean[] visited, List<Integer> result) {
        visited[i] = true;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(i);

        while(!queue.isEmpty()) {
            int current = queue.poll();
            result.add(current);
            for (int j : adjacencyList.get(current)) {
                if (!visited[j]) {
                    visited[j] = true;
                    queue.add(j);
                }
            }
        }
    }

    private static void createAdjacencyList(List<List<Integer>> adjacencyList) {
        adjacencyList.get(0).add(1);
        adjacencyList.get(0).add(2);
        adjacencyList.get(1).add(0);
        adjacencyList.get(2).add(0);
        adjacencyList.get(3).add(4);
        adjacencyList.get(4).add(3);
        adjacencyList.get(5).add(4);

        for (int i = 0; i < adjacencyList.size(); i++) {
            System.out.println("Adjacency list of vertex " + i + ": " + adjacencyList.get(i));
        }
    }
}
