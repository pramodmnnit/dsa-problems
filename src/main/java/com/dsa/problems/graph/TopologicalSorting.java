package com.dsa.problems.graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class TopologicalSorting {

    public static void main(String[] args) {
        int size = 6;
        List<List<Integer>> adjacencyList = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            adjacencyList.add(new ArrayList<>());
        }
        createAdjacencyList(adjacencyList);
        for (int i = 0; i < size; i++) {
            System.out.println("Adjacency list of vertex " + i + ": " + adjacencyList.get(i));
        }
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[size];
        for (int i = 0; i < size; i++) {
            if (!visited[i]) {
                topologicalSort(adjacencyList, visited, stack, i);
            }
        }
        System.out.println("Topological Sort: ");
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }

    private static void topologicalSort(List<List<Integer>> adjacencyList, boolean[] visited, Stack<Integer> stack, int i) {
        visited[i] = true;
        for (int j : adjacencyList.get(i)) {
            if (!visited[j]) {
                topologicalSort(adjacencyList, visited, stack, j);
            }
        }
        stack.push(i);
    }

    private static void createAdjacencyList(List<List<Integer>> adjacencyList) {
        adjacencyList.get(2).add(3);
        adjacencyList.get(3).add(1);
        adjacencyList.get(4).add(0);
        adjacencyList.get(4).add(1);
        adjacencyList.get(5).add(0);
        adjacencyList.get(5).add(2);
    }
}
