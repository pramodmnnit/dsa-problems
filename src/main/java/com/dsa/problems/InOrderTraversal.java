package com.dsa.problems;

import java.util.Stack;

public class InOrderTraversal {


    public void printInOrderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        printInOrderTraversal(root.left);
        System.out.print(root.data + " ");
        printInOrderTraversal(root.right);
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        InOrderTraversal inOrderTraversal = new InOrderTraversal();
        System.out.println("In-order traversal:");
        inOrderTraversal.printInOrderTraversal(root);
        System.out.println("\nIn-order traversal iterative:");
        inOrderTraversal.inOrderTraversalIterative(root);
    }

    public void inOrderTraversalIterative(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode current = root;
        Stack<TreeNode> stack = new Stack<>();
        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }
            current = stack.pop();
            System.out.print(current.data + " ");
            current = current.right;
        }
    }


}
