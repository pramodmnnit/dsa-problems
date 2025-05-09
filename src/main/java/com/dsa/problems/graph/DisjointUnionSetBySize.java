package com.dsa.problems.graph;

public class DisjointUnionSetBySize {
    private int[] parent;
    private int[] size;

    public DisjointUnionSetBySize(int n) {
        parent = new int[n];
        size = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    public int find(int i) {
        if (parent[i] == i) {
            return i;
        } else {
            parent[i] = find(parent[i]);
            return parent[i];
        }
    }

    public void union(int i, int j) {
        int parentI = find(i);
        int parentJ = find(j);
        if (parentI == parentJ) {
            return;
        }
        if (size[parentI] < size[parentJ]) {
            parent[parentI] = parentJ;
            size[parentJ] += size[parentI];
        } else if (size[parentI] > size[parentJ]) {
            parent[parentJ] = parentI;
            size[parentI] += size[parentJ];
        } else {
            parent[parentI] = parentJ;
            size[parentJ] += size[parentI];
        }
    }

    public static void main(String[] args) {
        DisjointUnionSetBySize disjointUnionSetBySize = new DisjointUnionSetBySize(5);
        disjointUnionSetBySize.union(1, 2);
        disjointUnionSetBySize.union(4, 2);
        disjointUnionSetBySize.union(0, 3);
        System.out.println(" 3 & 4 are connected: " + (disjointUnionSetBySize.find(3) == disjointUnionSetBySize.find(4)));
        System.out.println(" 1 & 2 are connected: " + (disjointUnionSetBySize.find(1) == disjointUnionSetBySize.find(2)));
        System.out.println(" 1 & 4 are connected: " + (disjointUnionSetBySize.find(1) == disjointUnionSetBySize.find(4)));
    }
}
