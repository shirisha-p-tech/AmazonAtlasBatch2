// Home Task - Preorder Traversal - Root Left Right
package datastructures.day16;

class TreeNode {
    int data;
    TreeNode left;
    TreeNode right;

    public TreeNode(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

// Binary Search Tree class
class BinarySearchTree {
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

    // Preorder traversal method
    public void preorder() {
        preorderRec(root);
    }

    // Recursive preorder method
    private void preorderRec(TreeNode root) {
        if (root != null) {
            System.out.print(root.data + " ");  // Visit root first
            preorderRec(root.left);             // Traverse left subtree
            preorderRec(root.right);            // Traverse right subtree
        }
    }
}

public class Task18 {
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();

        // Insert values
        bst.insert(70);
        bst.insert(80);
        bst.insert(20);
        bst.insert(105);
        bst.insert(100);
        bst.insert(50);

        // Print preorder traversal
        System.out.println("Preorder traversal:");
        bst.preorder();
    }
}

