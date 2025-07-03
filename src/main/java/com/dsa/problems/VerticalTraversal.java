package com.dsa.problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class VerticalTraversal {

    public static void printVerticalOrder(TreeNode root, int[] minMaxHd, int hd, Map<Integer, ArrayList<Integer>> hdMap) {
        if (root == null) {
            return;
        }
        ArrayList<Integer> list = hdMap.getOrDefault(hd, new ArrayList<>());
        list.add(root.data);
        hdMap.put(hd, list);
        if (hd < minMaxHd[0]) {
            minMaxHd[0] = hd;
        }
        if (hd > minMaxHd[1]) {
            minMaxHd[1] = hd;
        }
        printVerticalOrder(root.left, minMaxHd, hd - 1, hdMap);
        printVerticalOrder(root.right, minMaxHd, hd + 1, hdMap);
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(3);
        treeNode.left.left = new TreeNode(4);
        treeNode.left.right = new TreeNode(5);
        treeNode.right.left = new TreeNode(6);
        treeNode.right.right = new TreeNode(7);
        treeNode.right.left.right = new TreeNode(8);
        treeNode.right.right.right = new TreeNode(9);
        Map<Integer, ArrayList<Integer>> hdMap = new HashMap<>();
        int[] minMaxHd = new int[2];
        minMaxHd[0] = Integer.MAX_VALUE;
        printVerticalOrder(treeNode, minMaxHd, 0, hdMap);
        System.out.println("Vertical order traversal of binary tree is: ");
        for (int i = minMaxHd[0]; i <= minMaxHd[1]; i++) {
            System.out.println(hdMap.get(i));
        }

    }
}
