// Print the corner nodes of a binary tree
package datastructures.day18;
import java.util.*;
class TreeNode {
    int data;
    TreeNode left, right;

    TreeNode(int item) {
        data = item;
        left = right = null;
    }
}

class BinaryTree {


    public static void cornerNodes(TreeNode root) {
        if (root == null) {
            return;
        }

        // Start with the root node
       Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int nodeCount = queue.size();
            TreeNode first = null;
            TreeNode last = null;

            // Traverse each level and identify corner nodes
            for (int i = 0; i < nodeCount; i++) {
                TreeNode currentNode = queue.poll();

                // Mark the first and last node of the level
                if (i == 0) {
                    first = currentNode;
                }
                if (i == nodeCount - 1) {
                    last = currentNode;
                }

                // Add the child nodes to the queue
                if (currentNode.left != null) {
                    queue.add(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.add(currentNode.right);
                }
            }

            // Print the first and last corner nodes of the current level

            System.out.print(first.data + " ");
            if (first != last) {
                System.out.print(last.data + " ");
            }
            System.out.println();

        }
    }
}
public class Task10{
    public static void main(String[] args) {
        // Build the binary tree with nodes from 1 to 15

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        root.left.left.left = new TreeNode(8);
        root.left.left.right = new TreeNode(9);
        root.left.right.left = new TreeNode(10);
        root.left.right.right = new TreeNode(11);
        root.right.left.left = new TreeNode(12);
        root.right.left.right = new TreeNode(13);
        root.right.right.left = new TreeNode(14);
        root.right.right.right = new TreeNode(15);


        // Print corner nodes
        System.out.println("Corner nodes of the binary tree at each level:");
        BinaryTree.cornerNodes(root);
    }
}

