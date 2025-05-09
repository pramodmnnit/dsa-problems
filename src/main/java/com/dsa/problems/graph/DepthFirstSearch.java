package com.dsa.problems.graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class DepthFirstSearch {

    public static void main(String[] args) {
        List<List<Integer>> adjacencyList = new ArrayList<>(5);
        for (int i = 0; i < 5; i++) {
            adjacencyList.add(new ArrayList<>());
        }
        createAdjacencyList(adjacencyList);
        List<Integer> result = new ArrayList<>();
        boolean[] visited = new boolean[5];
        dfs(adjacencyList, visited, result);
        System.out.println("DFS traversal: " + result);
    }

    private static void dfs(List<List<Integer>> adjacencyList, boolean[] visited, List<Integer> result) {
        visited[0] = true;
        Stack<Integer> stack = new Stack<>();
        stack.add(0);
        while (!stack.isEmpty()) {
            int current = stack.pop();
            result.add(current);
            for (int j : adjacencyList.get(current)) {
                if (!visited[j]) {
                    visited[j] = true;
                    stack.add(j);
                }
            }
        }
    }

    public static void createAdjacencyList(List<List<Integer>> adjacencyList) {
        adjacencyList.get(0).add(1);
        adjacencyList.get(0).add(2);
        adjacencyList.get(1).add(0);
        adjacencyList.get(1).add(3);
        adjacencyList.get(2).add(0);
        adjacencyList.get(2).add(4);
        adjacencyList.get(3).add(1);
        adjacencyList.get(4).add(2);

        for (int i = 0; i < adjacencyList.size(); i++) {
            System.out.println("Adjacency list of vertex " + i + ": " + adjacencyList.get(i));
        }
    }
}
