// Reverse Alternate Level nodes of Binary Tree
package datastructures.day18;

import java.util.*;

class Node {
    char data;
    Node left, right;

    Node(char data) {
        this.data = data;
        left = right = null;
    }
}

class ReverseAlternateLevelBinaryTree {
    Node root;


    // Method to reverse the nodes at alternate levels (even levels) and print them
    public void reverseAlternateLevels() {
        if (root == null) {
            return;
        }

        // Perform a level-order traversal using a queue
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        int level = 0;

        // Level order Traversal
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            // Temporary stack for reversing nodes at even levels
            Stack<Node> stack = new Stack<>();

            // Collect all nodes for the current level
            for (int i = 0; i < levelSize; i++) {
                Node node = queue.poll();

                // If the level is even, push the node to the stack (for reverse order)
                if (level % 2 == 0) {
                    stack.push(node);
                } else {
                    // Otherwise, print nodes directly
                    System.out.print(node.data + " ");
                }

                // Enqueue children for the next level
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }

            // After processing all nodes at this level, print nodes in reverse order if it's an even level
            if (level % 2 == 0) {
                while (!stack.isEmpty()) {
                    System.out.print(stack.pop().data + " ");
                }
            }

            System.out.println(); // Move to the next line for the next level
            level++;
        }
    }

    // Driver Code
    public static void main(String[] args) {
        ReverseAlternateLevelBinaryTree tree = new ReverseAlternateLevelBinaryTree();

        // Creating the binary tree as per the input
        tree.root = new Node('A');
        tree.root.left = new Node('B');
        tree.root.right = new Node('C');
        tree.root.left.left = new Node('D');
        tree.root.left.right = new Node('E');
        tree.root.right.left = new Node('F');
        tree.root.right.right = new Node('G');
        tree.root.left.left.left = new Node('H');
        tree.root.left.left.right = new Node('I');
        tree.root.left.right.left = new Node('J');
        tree.root.left.right.right = new Node('K');
        tree.root.right.left.left = new Node('L');
        tree.root.right.left.right = new Node('M');
        tree.root.right.right.left = new Node('N');
        tree.root.right.right.right = new Node('O');

        System.out.println("Tree after reversing alternate levels (even levels): ");
        tree.reverseAlternateLevels();  // Will print the tree level by level and reverse on even levels
    }
}
