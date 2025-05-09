package com.dsa.problems.graph;

public class DisjointUnionFind {
    int[] parent;

    public DisjointUnionFind(int size) {
        parent = new int[size];
        for (int i = 0; i < size; i++) {
            parent[i] = i;
        }
    }

    public int find(int i) {
        if (parent[i] == i) {
            return i;
        }
        return find(parent[i]);
    }

    public void union(int i, int j) {
        int parentI = find(i);
        int parentJ = find(j);
        if (parentI != parentJ) {
            parent[parentI] = parentJ;
        }
    }

    public static void main(String[] args) {
        int size = 5;
        DisjointUnionFind uf = new DisjointUnionFind(size);
        uf.union(1, 2);
        uf.union(3, 4);
        System.out.println(" 3 & 4 are connected: " + (uf.find(3) == uf.find(4)));
        System.out.println(" 1 & 2 are connected: " + (uf.find(1) == uf.find(2)));
        System.out.println(" 1 & 3 are connected: " + (uf.find(1) == uf.find(3)));
    }

}
