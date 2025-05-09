package com.dsa.problems.graph;

public class DisjointUnionSetByRank {

    private int[] parent;
    private int[] rank;

    public DisjointUnionSetByRank(int n) {
        parent = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 0;
        }
    }

    int find(int i) {
        if (parent[i] == i) {
            return i;
        }
        parent[i] = find(parent[i]);
        return parent[i];
    }

    public void union(int i, int j) {
        int parentI = find(i);
        int parentJ = find(j);
        if (parentI == parentJ) {
            return;
        }
        if (rank[parentI] < rank[parentJ]) {
            parent[parentI] = parentJ;
        } else if (rank[parentI] > rank[parentJ]) {
            parent[parentJ] = parentI;
        } else {
            parent[parentI] = parentJ;
            rank[parentJ]++;
        }
    }

    public static void main(String[] args) {
        DisjointUnionSetByRank disjointUnionSetByRank = new DisjointUnionSetByRank(5);
        disjointUnionSetByRank.union(1, 2);
        disjointUnionSetByRank.union(4, 2);
        disjointUnionSetByRank.union(0, 3);
        System.out.println(" 3 & 4 are connected: " + (disjointUnionSetByRank.find(3) == disjointUnionSetByRank.find(4)));
        System.out.println(" 1 & 2 are connected: " + (disjointUnionSetByRank.find(1) == disjointUnionSetByRank.find(2)));
        System.out.println(" 1 & 4 are connected: " + (disjointUnionSetByRank.find(1) == disjointUnionSetByRank.find(4)));
    }
}
