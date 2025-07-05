// Task 1 to Task 4
// TreeNode data structures - node creation, insertion and inorder traversal and main method
package datastructures.day15;

//TreeNode class
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

    // Inorder traversal method
    public void inorder() {
        inorderRec(root);
    }

    // Recursive inorder method
    private void inorderRec(TreeNode root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.print(root.data + " ");
            inorderRec(root.right);
        }
    }
}

public class Task1to4 {
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();

        // Insert values
        bst.insert(70);
        bst.insert(80);
        bst.insert(20);
        bst.insert(105);
        bst.insert(100);
        bst.insert(50);

        // Print inorder traversal
        System.out.println("Inorder traversal:");
        bst.inorder();
    }
}
