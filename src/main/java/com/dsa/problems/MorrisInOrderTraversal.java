package com.dsa.problems;

public class MorrisInOrderTraversal {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        System.out.println("Inorder Traversal using Morris Traversal:");
        morrisTraversal(root);
    }

    private static void morrisTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode current = root;
        while (current != null) {
            if(current.left == null){
                System.out.print(current.data + " ");
                current = current.right;
            } else {
                TreeNode pre = current.left;
                while (pre.right != null && pre.right != current) {
                    pre = pre.right;
                }
                if (pre.right == null) {
                    pre.right = current;
                    current = current.left;
                } else {
                    pre.right = null;
                    System.out.print(current.data + " ");
                    current = current.right;
                }
            }
        }
    }
}
