// Trees data structures - searching operation in BST
package datastructures.day15;

/*
//Already created TreeNode class in class Task1to4 so commenting out
TreeNode class
class TreeNode {
    int data;
    datastructures.day15.TreeNode left;
    datastructures.day15.TreeNode right;

    public TreeNode(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}*/

// Binary Search Tree class
class BinarySearchTree1 {
    datastructures.day15.TreeNode root;

    // Insert method
    public void insert(int value) {
        root = insertRec(root, value);
    }

    // Recursive insert method
    private datastructures.day15.TreeNode insertRec(datastructures.day15.TreeNode root, int value) {
        if (root == null) {
            return new datastructures.day15.TreeNode(value);
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
    private void inorderRec(datastructures.day15.TreeNode root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.print(root.data + " ");
            inorderRec(root.right);
        }
    }

    // Search a value in the BST
    public boolean search(int key) {
        return searchRec(root, key);
    }

    private boolean searchRec(TreeNode root, int key) {
        if (root == null) {
            return false;
        }
        if (key == root.data) {
            return true;
        } else if (key < root.data) {
            return searchRec(root.left, key);
        } else {
            return searchRec(root.right, key);
        }
    }
}

public class Task6{
    public static void main(String[] args) {
        BinarySearchTree1 bst = new BinarySearchTree1();

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

        // Search for a value
        int searchKey = 70;
        if (bst.search(searchKey)) {
            System.out.println("\nNode " + searchKey + " found in the tree");
        } else {
            System.out.println("\nNode " + searchKey + " not found in the tree");
        }
    }
}




