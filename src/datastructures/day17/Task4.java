// Red-Black Tree Traversal
package datastructures.day17;

class RB_Node {
    int key;
    RB_Node left, right, parent;
    boolean color; // true for Black, false for Red

    public RB_Node(int key) {
        this.key = key;
        this.color = false; // New nodes are always red
        this.left = this.right = this.parent = null;
    }
}

class RedBlackTree {
    private RB_Node root;

    public RedBlackTree() {
        root = null;
    }

    // Left rotate
    private void leftRotate(RB_Node x) {
        RB_Node y = x.right;
        x.right = y.left;
        if (y.left != null) {
            y.left.parent = x;
        }
        y.parent = x.parent;
        if (x.parent == null) {
            root = y;
        } else if (x == x.parent.left) {
            x.parent.left = y;
        } else {
            x.parent.right = y;
        }
        y.left = x;
        x.parent = y;
    }

    // Right rotate
    private void rightRotate(RB_Node x) {
        RB_Node y = x.left;
        x.left = y.right;
        if (y.right != null) {
            y.right.parent = x;
        }
        y.parent = x.parent;
        if (x.parent == null) {
            root = y;
        } else if (x == x.parent.right) {
            x.parent.right = y;
        } else {
            x.parent.left = y;
        }
        y.right = x;
        x.parent = y;
    }

    // Fix the Red-Black Tree after insertion
    private void fixInsert(RB_Node k) {
        RB_Node u;

        while (k.parent != null && k.parent.color == false) { // While parent is red
            if (k.parent == k.parent.parent.right) {
                u = k.parent.parent.left; // Uncle node

                // Case 1: Uncle is red
                if (u != null && u.color == false) {
                    u.color = true; // Uncle becomes black
                    k.parent.color = true; // Parent becomes black
                    k.parent.parent.color = false; // Grandparent becomes red
                    k = k.parent.parent; // Move up the tree
                } else { // Case 2: Uncle is black or null
                    if (k == k.parent.left) {
                        k = k.parent; // Perform a right rotation if the node is on the left
                        rightRotate(k);
                    }
                    // Case 3: Uncle is black or null and node is on the right, perform left rotation
                    k.parent.color = true; // Parent becomes black
                    k.parent.parent.color = false; // Grandparent becomes red
                    leftRotate(k.parent.parent);
                }
            } else {
                u = k.parent.parent.right; // Uncle node

                // Case 1: Uncle is red
                if (u != null && u.color == false) {
                    u.color = true; // Uncle becomes black
                    k.parent.color = true; // Parent becomes black
                    k.parent.parent.color = false; // Grandparent becomes red
                    k = k.parent.parent; // Move up the tree
                } else { // Case 2: Uncle is black or null
                    if (k == k.parent.right) {
                        k = k.parent; // Perform a left rotation if the node is on the right
                        leftRotate(k);
                    }
                    // Case 3: Uncle is black or null and node is on the left, perform right rotation
                    k.parent.color = true; // Parent becomes black
                    k.parent.parent.color = false; // Grandparent becomes red
                    rightRotate(k.parent.parent);
                }
            }

            if (k.parent == null) {
                break; // Reached the root, no more fixing needed
            }
        }

        root.color = true; // Ensure the root is always black
    }

    // Insert node
    public void insert(int key) {
        RB_Node node = new RB_Node(key);
        RB_Node y = null;
        RB_Node x = root;

        while (x != null) {
            y = x;
            if (node.key < x.key) {
                x = x.left;
            } else {
                x = x.right;
            }
        }

        node.parent = y;
        if (y == null) {
            root = node;
        } else if (node.key < y.key) {
            y.left = node;
        } else {
            y.right = node;
        }

        node.left = null;
        node.right = null;
        node.color = false; // New nodes are always red

        fixInsert(node); // Fix any violations of the Red-Black Tree properties
    }

    // Inorder traversal (for printing the tree)
    public void inorderTraversal() {
        inorderTraversalHelper(this.root);
    }

    private void inorderTraversalHelper(RB_Node node) {
        if (node != null) {
            inorderTraversalHelper(node.left);
            System.out.print(node.key + " (" + (node.color ? "B" : "R") + ") ");
            inorderTraversalHelper(node.right);
        }
    }
}

public class Task4{
    public static void main(String[] args) {
        RedBlackTree tree = new RedBlackTree();

        tree.insert(5);
        tree.insert(10);
        tree.insert(40);
        tree.insert(15);
        tree.insert(20);

        System.out.println("Red-Black Tree Inorder Traversal:");
        tree.inorderTraversal();
    }
}

