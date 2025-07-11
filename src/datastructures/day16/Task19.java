// Home Task - Postorder Traversal - Left Right Root
package datastructures.day16;

import datastructures.day16.TreeNode;

// Binary Search Tree class
class BinarySearchTree1 {
    TreeNode root;

    // Insert method
    public void insert(int value) {
        root = insertRec(root, value);
    }

    // Recursive insert method
    private TreeNode insertRec(TreeNode root, int value) {
        if (root == null) {
            return new TreeNode(value);
        }
        if (value < root.data) {
            root.left = insertRec(root.left, value);
        } else if (value > root.data) {
            root.right = insertRec(root.right, value);
        }
        return root;
    }

    // Postorder traversal method
    public void postorder() {
        postorderRec(root);
    }

    // Recursive postorder method
    private void postorderRec(TreeNode root) {
        if (root != null) {

            postorderRec(root.left);             // Traverse left subtree
            postorderRec(root.right);            // Traverse right subtree
            System.out.print(root.data + " ");  // Visit root last
        }
    }
}

public class Task19 {
    public static void main(String[] args) {
        BinarySearchTree1 bst = new BinarySearchTree1();

        // Insert values
        bst.insert(70);
        bst.insert(80);
        bst.insert(20);
        bst.insert(105);
        bst.insert(100);
        bst.insert(50);

        // Print postorder traversal
        System.out.println("Postorder traversal:");
        bst.postorder();
    }
}


