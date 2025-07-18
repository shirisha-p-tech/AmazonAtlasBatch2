// Binary Tree Right Side View
package datastructures.day18;
import datastructures.day18.TreeNode;
import java.util.LinkedList;
import java.util.Queue;

class BinaryTreeRightSideView {


    public static void rightNodes(TreeNode root) {
        if (root == null) {
            return;
        }

        // Start with the root node
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int nodeCount = queue.size();
            TreeNode last = null;

            // Traverse each level and identify corner nodes
            for (int i = 0; i < nodeCount; i++) {
                TreeNode currentNode = queue.poll();


                // last saves the right side view nodes
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


            System.out.print(last.data + " ");

            System.out.println();

        }
    }
}
public class Task19{
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


        // Print right side view nodes
        System.out.println("Right side view of Binary Tree");
        BinaryTreeRightSideView.rightNodes(root);
    }
}

