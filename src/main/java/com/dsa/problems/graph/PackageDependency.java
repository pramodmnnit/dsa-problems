package com.dsa.problems.graph;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class PackageDependency {

    public static void main(String[] args) {
        Map<String, List<String>> adjacencyList = new HashMap<>();
        adjacencyList.put("A", List.of("B"));
        adjacencyList.put("B", List.of());
        adjacencyList.put("C", List.of("A"));
        adjacencyList.put("D", List.of("A", "B", "C"));
        System.out.println("Adjacency List:");
        for (Map.Entry<String, List<String>> entry : adjacencyList.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
        Stack<String> stack = new Stack<>();
        Map<String, Boolean> visited = new HashMap<>();
        for (String key : adjacencyList.keySet()) {
            visited.put(key, false);
        }
        for (String key : adjacencyList.keySet()) {
            if (!visited.get(key)) {
                topologicalSort(adjacencyList, visited, stack, key);
            }
        }
        System.out.println("Package installation Order: ");
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }

    public static void topologicalSort(Map<String, List<String>> adjacencyList, Map<String, Boolean> visited, Stack<String> stack, String key) {
        visited.put(key, true);
        for (String neighbor : adjacencyList.get(key)) {
            if (!visited.get(neighbor)) {
                topologicalSort(adjacencyList, visited, stack, neighbor);
            }
        }
        stack.push(key);
    }

}
